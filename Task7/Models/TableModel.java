package Task7.Models;

import Task7.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables){
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(tableNo, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name) {
        // проверяем, что столик с номером tableNo существует и можно на него бронировать
        int tableNoCorrect = 0;
        for (Table table : tables) {
            if (table.getNo() == tableNo){
                tableNoCorrect = 1;
                break;
            }
        }
        if (tableNoCorrect == 0){ throw new RuntimeException("Столика с таким номером нет!");}

        for (Table table : tables) {
            Collection<Reservation> reservations = table.getReservations();
            for (Reservation reservation : reservations) {
                if (reservation.getId() == oldReservation) {
                    reservation.setTableNo(tableNo);
                    reservation.setDate(reservtionDate);
                    reservation.setName(name);
                    return reservation.getId();

                }
            }
        }

        throw new RuntimeException("Не верный номер резерва");
    }

}
