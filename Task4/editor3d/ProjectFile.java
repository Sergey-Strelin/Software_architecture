package editor3d;

public class ProjectFile {

    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean getSetting3() {
        return setting3;
    }

    public String getFileName() {
        return fileName;
    }

    public ProjectFile(String fileName){
        this.fileName = fileName;
        // Загрузка настроек проекта, получаем объектное представление
        setting1 = 1;
        setting2 = "..";
        setting3 = false;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSetting1(int setting1) {
        this.setting1 = setting1;
    }

    public void setSetting2(String setting2) {
        this.setting2 = setting2;
    }

    public void setSetting3(boolean setting3) {
        this.setting3 = setting3;
    }
}
