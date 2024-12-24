package editor3d;

public interface UILayer {

    void openProject(String fileName);
    void showProjectSettings();
    void saveProject(String fileName);
    void changeProgect(String fileName, int setting1, String setting2,  String setting3);
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);

    void addModel(Model3D model);

    void addTexture();

    void removeModel(int i);

    void removeTexture(int i);
}
