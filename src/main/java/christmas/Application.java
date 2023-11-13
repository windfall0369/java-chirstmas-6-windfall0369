package christmas;

import christmas.domain.discount.controller.DiscountController;
import christmas.domain.event.controller.EventController;
import christmas.domain.event.model.EventChecker;
import christmas.domain.menu.controller.MenuController;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.reservation.controller.ReservationController;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();
        MenuController menuController = new MenuController();
        PaymentController paymentController = new PaymentController();
        EventController eventController = new EventController();
        DiscountController discountController = new DiscountController();

        //예약 컨트롤러
        int reservationDate = reservationController.chooseReservationDate(); //고객 예상 방문 날짜

        //메뉴 컨트롤러
        Map<EntireMenu, Integer> userMenu = menuController.chooseMenu(); //고객 주문 메뉴
        menuController.showMenu(userMenu);

        //결제 컨트롤러
        int orderPrice = paymentController.getOrderPrice(userMenu); // 할인 전 총 주문 가격

        //이벤트 컨트롤러
        EventChecker events = eventController.getEvent(orderPrice, reservationDate);//이벤트 참가 목록
        //증정 메뉴 출력

        //할인 컨트롤러
        List<Integer> discountPrice = discountController.getDiscountPrice(userMenu, events);

        //이벤트 컨트롤러 -> 혜택 내역 출력, 총 헤택 금액까지 출력
        eventController.getEventDiscount(discountPrice, events.getWeekDiscount());


    }
}
