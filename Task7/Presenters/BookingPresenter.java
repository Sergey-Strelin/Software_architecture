package Task7.Presenters;

import Task7.Models.TableModel;
import Task7.Views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }
    public void updateTables(){
        view.showTables(model.loadTables());
    }

    private void showReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date reservtionDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reservtionDate, tableNo, name);
            showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            showReservationTableResult(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name) {
        try {
            int reservationNo = model.changeReservationTable(oldReservation, reservtionDate, tableNo, name);
            showChangeReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            showChangeReservationTableResult(-1);
        }
    }

    private void showChangeReservationTableResult(int reservationNo) { view.showChangeReservationTableResult(reservationNo); }
}
