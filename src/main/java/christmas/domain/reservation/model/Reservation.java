package christmas.domain.reservation.model;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.model.EntireMenu;
import java.util.Map;

public class Reservation {

    private final int reservationDate;
    private final Map<EntireMenu, Integer> userMenu;
    private final int orderPrice;
    private final EventChecker events;
    private final int eventDiscountPrice;
    private final int totalPrice;

    public Reservation(int reservationDate, Map<EntireMenu, Integer> userMenu, int orderPrice,
        EventChecker events, int eventDiscountPrice, int totalPrice) {
        this.reservationDate = reservationDate;
        this.userMenu = userMenu;
        this.orderPrice = orderPrice;
        this.events = events;
        this.eventDiscountPrice = eventDiscountPrice;
        this.totalPrice = totalPrice;
    }

    public ReservationDto createDto() {
        return new ReservationDto();
    }

}
