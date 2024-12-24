package auto.car;

import java.awt.*;
import auto.refueling.*;
import auto.wiping.*;
import java.util.List;



public abstract class Car {

    private Refueling refueling;
    
    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    /**
     * Заправить автомобиль
     */
    public void fuel() {
        if (refueling != null){
            refueling.fuel(fuelType);
        }
    }

    private Wiping wiping;
    
    public void setWipingStation(Wiping wipingStation) {
        this.wiping = wipingStation;
    }

    public void wiping(){
        if (wiping != null){
            wiping.washing(wipingType);
        }
    }



    protected void setWheelsCount(int wheelsCount){
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // Движение
    public abstract void movement();
    // Обслуживание
    public abstract void maintenance();
    // Переключение передач
    public abstract boolean gearShifting();
    // Включение фар
    public abstract boolean switchHeadlights();
    // Включение дворников
    public abstract boolean switchWipers();

    //region Конструкторы

    public Car(String make, String model, Color color, FuelType fuelType, List<WipingType> wipingType) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
        this.wipingType = wipingType;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    //endregion

    //region Поля

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;

    // Тип мойки
    protected List<WipingType> wipingType;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;

    //endregion



}
