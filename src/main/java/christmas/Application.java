package christmas;

import christmas.domain.reservation.controller.ReservationController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ReservationController reservationController = new ReservationController();

        reservationController.chooseReservationDate();

    }
}
