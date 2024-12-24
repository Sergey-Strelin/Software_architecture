package editor3d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Editor3D implements UILayer{


    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    /**
     * Полностью пересобираем внутренние компоненты системы (новый проект)
     */
    private void initialize(){
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }


    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        initialize();
        database.load();
    }

    //сохраняем проект (возможно с другим именем)
    @Override
    public void saveProject(String fileName) {
        // Предусловие
        checkProjectFile();

        if (fileName == "") {
            fileName = projectFile.getFileName();
        }
        System.out.println("Проект сохраняется в файл "+ fileName );
        database.save();
    }

    // изменяем настройки проекта
    @Override
    public void changeProgect(String fileName, int setting1, String setting2, String setting3){
        // Предусловие
        checkProjectFile();

        projectFile.setFileName(fileName);
        if (setting1==0) setting1 = projectFile.getSetting1();
        projectFile.setSetting1(setting1);
        projectFile.setSetting2(setting2);
        if ( Boolean.parseBoolean(setting3) ) {
            projectFile.setSetting3(true);
        }
        else {
            projectFile.setSetting3(false);
        }
        System.out.println("Настройки проекта изменены!" );
    }

    @Override
    public void showProjectSettings() {
        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");
    }

    @Override
    public void printAllModels() {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++){
            System.out.printf("===Номер модели %d===\n", i);
            System.out.println("  ID модели: " + models.get(i));
            for (Texture texture: models.get(i).getTextures()) {
                System.out.printf("\t  ID текстуры: %s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++){
            System.out.printf("===Номер текстуры %d===\n", i);
            System.out.println("  ID текстуры: " + textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        // Предусловие
        checkProjectFile();

        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);

    }

    @Override
    public void renderModel(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);

    }

    @Override
    public void addModel(Model3D model) {
        // Предусловие
        checkProjectFile();

        databaseAccess.addEntity(new Model3D());
        System.out.println("3D модель успешно добавлена.");
    }
    // добавляем - удаляем модели
    @Override
    public void removeModel(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1) {
            throw new RuntimeException("Номер модели указан некорректно.");
        }
        databaseAccess.removeEntity(models.get(i));
        System.out.println("3D модель успешно удалена.");
    }

    // добавляем - удаляем текстуры
    @Override
    public void addTexture() {
        // Предусловие
        checkProjectFile();

        databaseAccess.addEntity(new Texture());
        System.out.println("Текстура успешно добавлена.");
    }

    @Override
    public void removeTexture(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        if (i < 0 || i > textures.size() - 1) {
            throw new RuntimeException("Номер текстуры указан некорректно.");
        }
        databaseAccess.removeEntity(textures.get(i));
        System.out.println("Текстура успешно удалена.");
    }

    // проверяем, что проект открыт
    private void checkProjectFile(){
        if (projectFile == null)
            throw new RuntimeException("Нет ни одного открытого проекта!");
    }


}
