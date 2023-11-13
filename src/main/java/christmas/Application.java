package christmas;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.evnetPlanner.controller.EventPlannerController;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.reservation.controller.ReservationController;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();
        PaymentController paymentController = new PaymentController();
        EventPlannerController eventPlannerController = new EventPlannerController();

        int reservationDate = reservationController.chooseReservationDate(); //고객 예상 방문 날짜

        Map<EntireMenu, Integer> userMenu = eventPlannerController.makeReservationMenu(
            reservationDate);
        int orderPrice = paymentController.getOrderPrice(userMenu); // 할인 전 총 주문 가격

        EventChecker events = eventPlannerController.getDiscountList(userMenu, reservationDate,
            orderPrice);
        int eventDiscountPrice = eventPlannerController.getReservationDiscountPrice(userMenu,
            reservationDate, events);

        eventPlannerController.getReservationResult(eventDiscountPrice, events, orderPrice);

        //영수증 만들기
    }
}
