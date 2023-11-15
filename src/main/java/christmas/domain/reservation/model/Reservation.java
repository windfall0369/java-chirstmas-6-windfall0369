package christmas.domain.reservation.model;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.model.EntireMenu;
import java.util.Map;

public class Reservation {

    private final int reservationDate;
    private final Map<EntireMenu, Integer> userMenu;
    private final int orderPrice;
    private final EventChecker events;
    private final int eventDiscountPrice;
    private final Badge eventBadge;
    private final int totalPrice;


    public Reservation(ReservationDto reservationDto) {
        this.reservationDate = reservationDto.getReservationDate();
        this.userMenu = reservationDto.getUserMenu();
        this.orderPrice = reservationDto.getOrderPrice();
        this.events = reservationDto.getEvents();
        this.eventDiscountPrice = reservationDto.getEventDiscountPrice();
        this.eventBadge = reservationDto.getEventBadge();
        this.totalPrice = reservationDto.getTotalPrice();
    }

    public ReservationDto createDto() {
        return new ReservationDto();
    }

}
