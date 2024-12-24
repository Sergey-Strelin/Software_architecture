package auto.car;

import java.awt.*;
import java.util.List;

import auto.refueling.FuelType;
import auto.wiping.WipingType;

public class SoprtCar extends Car {
    public SoprtCar(String make, String model, Color color, FuelType fuelType, List<WipingType> wipingType) {
        super(make, model, color, fuelType, wipingType);
        setWheelsCount(3);
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }
}
