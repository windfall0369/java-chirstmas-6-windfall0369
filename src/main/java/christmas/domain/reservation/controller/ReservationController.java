package christmas.domain.reservation.controller;

import christmas.domain.reservation.view.inputView.ReservationInputView;
import christmas.domain.reservation.view.outputView.ReservationOutputView;

public class ReservationController {

    private final ReservationInputView inputView = new ReservationInputView();
    private final ReservationOutputView outputView = new ReservationOutputView();


    public int chooseReservationDate() {
        outputView.printRequestVisitDate();
        return inputView.getUserVisitDate();
    }


}
