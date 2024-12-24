package auto;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import auto.car.*;
import auto.refueling.*;
import auto.wiping.*;

    
public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     *
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     *
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
    *
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     *
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.

     * TODO: Домашнее задание:
     * Доработать приложение, спроектированное на семинаре. Добавить тип, описывающий "автомойку".
     * Продемонстрировать работу получившейся программы,
     * создать несколько типов автомобилей,
     * загнать каждый автомобиль на заправку, а затем и на автомойку.
     * @param args
     */
    public static void main(String[] args) {
        // создали две заправки
        RefuelingStation refuelingStation1 = new RefuelingStation();
        RefuelingStationV2 refuelingStation2 = new RefuelingStationV2();

        // создали две мойки
        WipingStation wipingStation1 = new WipingStation();
        WipingStation wipingStation2 = new WipingStation();

        // создали перечень для мойки для двух машин
        // перечисленно всё, но можно закомментировать что-то и пепечень помытого поменяется
        List<WipingType> wipingTypeHarvester = new ArrayList<>();
        wipingTypeHarvester.add(WipingType.WipMirrors);
        wipingTypeHarvester.add(WipingType.WipWindshield);
        //wipingTypeHarvester.add(WipingType.WipHeadlights);

        List<WipingType> wipingTypeSportCar = new ArrayList<>();
        wipingTypeSportCar.add(WipingType.WipMirrors);
        //wipingTypeSportCar.add(WipingType.WipWindshield);
        wipingTypeSportCar.add(WipingType.WipHeadlights);

        
        // создали две машины
        Harvester harvester = new Harvester("A", "B", Color.BLACK, FuelType.Diesel, wipingTypeHarvester);
        SoprtCar sportcar = new SoprtCar("E", "R", Color.RED, FuelType.Gasoline, wipingTypeSportCar);
        
        // связали машины с заправками
        harvester.setRefuelingStation(refuelingStation1);
        sportcar.setRefuelingStation(refuelingStation2);
    
        // связали машины с мойками
        harvester.setWipingStation(wipingStation1);
        sportcar.setWipingStation(wipingStation2);

        // заправили и помыли первую
        System.out.printf("Заправляем авто марки =%s (модель =%s) \n", harvester.getMake(), harvester.getModel());
        harvester.fuel();
        System.out.printf("Моем авто марки =%s (модель =%s) \n", harvester.getMake(), harvester.getModel());
        harvester.wiping();

        // заправили и помыли вторую
        System.out.printf("Заправляем авто марки =%s (модель =%s) \n", sportcar.getMake(), sportcar.getModel());
        sportcar.fuel();
        System.out.printf("Моем авто марки =%s (модель =%s) \n", sportcar.getMake(), sportcar.getModel());
        sportcar.wiping();
    }


    public static double calculateMaintenance(Car car){
        if (car.getWheelsCount() == 6){
            return 1500*6;
        }
        else {
            return 1000*4;
        }
    }

}
