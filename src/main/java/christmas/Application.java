package christmas;

import christmas.domain.menu.controller.MenuController;
import christmas.domain.reservation.controller.ReservationController;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ReservationController reservationController = new ReservationController();
        MenuController menuController = new MenuController();

        int reservationDate = reservationController.chooseReservationDate();
        Map<String, Integer> userMenu = menuController.chooseMenu();

    }
}
