package auto.refueling;

public class RefuelingStation implements Refueling{

    public void processfuel(FuelType fuelType) {
        switch (fuelType){
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }

    @Override
    public void fuel(FuelType fuelType) {
        processfuel(fuelType);
    }
}
