package christmas;

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

        int reservationDate = reservationController.chooseReservationDate();
        Map<EntireMenu, Integer> userMenu = menuController.chooseMenu();
        menuController.showMenu(userMenu);
        int orderPrice = paymentController.getOrderPrice(userMenu);


        //증정메뉴 구현
        //메인 문 ㅈㄴ 길어질 거 같은데 어떻게 해결할 것인가 고


    }
}
