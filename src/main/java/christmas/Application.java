package christmas;

import christmas.domain.menu.controller.MenuController;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.reservation.controller.ReservationController;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ReservationController reservationController = new ReservationController();
        MenuController menuController = new MenuController();
        PaymentController paymentController = new PaymentController();

        int reservationDate = reservationController.chooseReservationDate();
        Map<String, Integer> userMenu = menuController.chooseMenu();
        menuController.showMenu(userMenu);
        int orderPrice = paymentController.calculateOrderPrice(userMenu);



    }
}
