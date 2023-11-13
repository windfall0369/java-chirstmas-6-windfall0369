package christmas.domain.evnetPlanner.controller;

import christmas.domain.event.controller.EventController;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.controller.MenuController;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.payment.model.DiscountPrice;
import java.util.Map;

public class EventPlannerController {

    PaymentController paymentController = new PaymentController();
    EventController eventController = new EventController();
    MenuController menuController = new MenuController();

    public Map<EntireMenu, Integer> makeReservationMenu(int reservationDate) {
        Map<EntireMenu, Integer> userMenu = menuController.chooseMenu(); //고객 주문 메뉴
        menuController.showMenu(userMenu, reservationDate);

        return userMenu;
    }

    public EventChecker getDiscountList(Map<EntireMenu, Integer> userMenu, int reservationDate,
        int orderPrice) {
        EventChecker events = eventController.getEvent(orderPrice, reservationDate);//이벤트 참가 목록

        return events;
    }

    public int getReservationDiscountPrice(Map<EntireMenu, Integer> userMenu, int reservationDate,
        EventChecker events) {
        DiscountPrice discountPrice = paymentController.getDiscountPrice(userMenu, events);
        int eventDiscountPrice = paymentController.getEventDiscount(discountPrice,
            events.getWeekDiscount());//총혜택 금액 출력

        return eventDiscountPrice;
    }

    public void getReservationResult(int eventDiscountPrice, EventChecker events, int orderPrice) {
        int totalPrice = paymentController.getTotalPrice(eventDiscountPrice, events,
            orderPrice); //할인 후 예상 결제 금액 계산
        eventController.getEventBadge(eventDiscountPrice); //이벤트 배지
    }
}
