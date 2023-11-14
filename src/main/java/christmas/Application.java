package christmas;

import christmas.domain.reservation.controller.ReservationController;
import christmas.domain.reservation.model.ReservationDto;

public class Application {

    public static ReservationDto reservationDto;

    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();

        reservationDto = reservationController.chooseReservationDate();//고객 예상 방문 날짜

        reservationDto = reservationController.makeReservationMenu(reservationDto);
        reservationDto = reservationController.getReservationOrderPrice(reservationDto);
        reservationDto = reservationController.getDiscountList(reservationDto);
        reservationDto = reservationController.getReservationDiscountPrice(reservationDto);
        reservationDto = reservationController.getReservationResult(reservationDto);

        //reservation을 만들어서 여기에 값 추가하고 토스

    }
}
