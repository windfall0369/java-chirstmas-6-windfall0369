package christmas;

import christmas.domain.event.controller.EventController;
import christmas.domain.event.model.EventList;
import christmas.domain.menu.controller.MenuController;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.reservation.controller.ReservationController;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();
        MenuController menuController = new MenuController();
        PaymentController paymentController = new PaymentController();
        EventController eventController = new EventController();

        //예약 컨트롤러
        int reservationDate = reservationController.chooseReservationDate();

        //메뉴 컨트롤러
        Map<EntireMenu, Integer> userMenu = menuController.chooseMenu();
        menuController.showMenu(userMenu);

        //결제 컨트롤러
        int orderPrice = paymentController.getOrderPrice(userMenu);

        //이벤트 컨트롤러
        EventList events = eventController.handleEvent(orderPrice, reservationDate);

        //할인 컨트롤러

        //메인 문 ㅈㄴ 길어질 거 같은데 어떻게 해결할 것인가 고민


    }
}
