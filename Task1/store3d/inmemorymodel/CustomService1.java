package store3d.inmemorymodel;

public class CustomService1 implements ModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Была добавлена новая полигональная модель - CustomService1");
    }    
}
