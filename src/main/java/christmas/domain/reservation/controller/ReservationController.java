package christmas.domain.reservation.controller;

import christmas.domain.reservation.view.inputView.ReservationInputView;
import christmas.domain.reservation.view.outputView.ReservationOutputView;

public class ReservationController {

    private final ReservationInputView inputView = new ReservationInputView();
    private final ReservationOutputView outputView = new ReservationOutputView();


    public void chooseReservationDate() {
        outputView.printRequestVisitDate();
        int userVisitDate = inputView.getUserVisitDate();
    }


}
