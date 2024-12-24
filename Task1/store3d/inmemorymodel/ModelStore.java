package store3d.inmemorymodel;

import java.util.List;

import store3d.models.Camera;
import store3d.models.Flash;
import store3d.models.PoligonalModel;
import store3d.models.Scene;

public class ModelStore implements ModelChanger {


    private List<ModelChangedObserver> observers;
    private List<PoligonalModel> models;
    private List<Flash> flashes;
    private List<Scene> scenes;
    private List<Camera> cameras;


    public void add(PoligonalModel model){
        models.add(model);
        notifyChange();
    }

    public void add(Flash flash){
        flashes.add(flash);
        notifyChange();
    }      

    public void add(Scene scene){
        scenes.add(scene);
        notifyChange();
    }      
    
    public void add(Camera camera){
        cameras.add(camera);
        notifyChange();
    }    


    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : observers){
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        observers.remove(o);
    }

}