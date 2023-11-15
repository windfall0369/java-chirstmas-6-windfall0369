package christmas;

import christmas.domain.payment.model.Receipt;
import christmas.domain.reservation.controller.ReservationController;
import christmas.domain.reservation.model.ReservationDto;

public class Application {

    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();

        reservationController.chooseReservationDate();//고객 예상 방문 날짜
        reservationController.makeReservationMenu();
        reservationController.getReservationOrderPrice();
        reservationController.getDiscountList();
        reservationController.getReservationDiscountPrice();
        ReservationDto reservationResult = reservationController.getReservationResult();
        Receipt reservationReceipt = reservationController.getReservationReceipt();

        //영수증 + 테스트 작성
        //payment 랑 discountPrice 역할 모호
        //payment 가격을 담고 있음
        // ""할인 전 총주문 가격,  총혜택 금액, 행사 할인 가격(샴페인 뺀 거), 할인 후 예상 결제 금액(totalPrice)
        //discountPrice 할인과 할인에 해당하는 가격을 담고 있음
        // "" 디데이, 특별, 평일-주말, 증정

        //그럼 orderPrice랑 discountPrice만 있으면 되는 거 아님?
    }
}
