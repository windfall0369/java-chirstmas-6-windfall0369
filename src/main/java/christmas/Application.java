package christmas;

import christmas.domain.payment.model.Receipt;
import christmas.domain.reservation.controller.ReservationController;
import christmas.domain.reservation.model.Reservation;

public class Application {

    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();

        reservationController.chooseReservationDate();
        reservationController.makeReservationMenu();
        reservationController.getReservationOrderPrice();
        reservationController.getDiscountList();
        reservationController.getReservationDiscountPrice();

        Reservation reservationResult = reservationController.getReservationResult();
        Receipt reservationReceipt = reservationController.getReservationReceipt();

        reservationController.addReservationInRepository(reservationResult, reservationReceipt);
    }
}
