package christmas;

import christmas.domain.event.controller.EventController;
import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.controller.MenuController;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.payment.model.DiscountPrice;
import christmas.domain.reservation.controller.ReservationController;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();
        MenuController menuController = new MenuController();
        PaymentController paymentController = new PaymentController();
        EventController eventController = new EventController();

        int reservationDate = reservationController.chooseReservationDate(); //고객 예상 방문 날짜

        Map<EntireMenu, Integer> userMenu = menuController.chooseMenu(); //고객 주문 메뉴
        menuController.showMenu(userMenu, reservationDate);

        int orderPrice = paymentController.getOrderPrice(userMenu); // 할인 전 총 주문 가격

        EventChecker events = eventController.getEvent(orderPrice, reservationDate);//이벤트 참가 목록

        DiscountPrice discountPrice = paymentController.getDiscountPrice(userMenu, events);
        int eventDiscountPrice = paymentController.getEventDiscount(discountPrice,
            events.getWeekDiscount());//총혜택 금액 출력
        int totalPrice = paymentController.getTotalPrice(eventDiscountPrice, events,
            orderPrice); //할인 후 예상 결제 금액 계산

        Badge eventBadge = eventController.getEventBadge(eventDiscountPrice); //이벤트 배지
        //영수증 만들기
    }
}
