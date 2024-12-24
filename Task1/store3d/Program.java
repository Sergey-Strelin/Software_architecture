package store3d;

import java.util.ArrayList;
import java.util.List;

import store3d.inmemorymodel.CustomService1;
import store3d.inmemorymodel.ModelStore;
import store3d.models.Poligon;
import store3d.models.PoligonalModel;

public class Program {
    public static void main(String[] args) {

        CustomService1 customsevise1 = new CustomService1();

        ModelStore store = new ModelStore();
        store.registerModelChanger(customsevise1);

        Poligon p1 = new Poligon();
        List<Poligon> poligons = new ArrayList<>();
        poligons.add(p1);
        PoligonalModel poligonalModel = new PoligonalModel(poligons);
        store.add(poligonalModel);
    }
}