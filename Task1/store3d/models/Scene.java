package store3d.models;

import java.util.List;

public class Scene {

  public int getID() {
    return this.ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public List<PoligonalModel> getModels() {
    return this.models;
  }

  public void setModels(List<PoligonalModel> models) {
    this.models = models;
  }

  public List<Flash> getFlashes() {
    return this.flashes;
  }

  public void setFlashes(List<Flash> flashes) {
    this.flashes = flashes;
  }

  public List<Camera> getCameras() {
    return this.cameras;
  }

  public void setCameras(List<Camera> cameras) {
    this.cameras = cameras;
  }

  public int ID;
  public List<PoligonalModel> models;
  public List<Flash> flashes;
  public List<Camera> cameras;

  public Scene(int id, List<PoligonalModel> models, List<Flash> flashes, List<Camera> cameras) throws Exception {
    this.ID = id;
    if (models.size() > 0) {
      this.models = models;
    } else {
      throw new Exception("Должна быть хотя бы одна модель");
    }
    this.flashes = flashes;

    if (flashes.size() > 0) {
      this.flashes = flashes;
    } else {
      throw new Exception("Должен быть хотя бы один источник света");
    }

    if (cameras.size() > 0) {
      this.cameras = cameras;
    } else {
      throw new Exception("Должна быть хотя бы одна камера");
    }
  }

  public <T> T method1(T flash) {
    return flash;
  }

  public <T, E> T method2(T Model, E Flash) {
    return Model;
  }

}