package christmas.domain.reservation.model;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.model.EntireMenu;
import java.util.Map;

public class ReservationDto {

    private int reservationDate;
    private Map<EntireMenu, Integer> userMenu;
    private int orderPrice;
    private EventChecker events;
    private int eventDiscountPrice;
    private int totalPrice;
    private Badge eventBadge;

    public int getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(int reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Map<EntireMenu, Integer> getUserMenu() {
        return userMenu;
    }

    public void setUserMenu(
        Map<EntireMenu, Integer> userMenu) {
        this.userMenu = userMenu;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public EventChecker getEvents() {
        return events;
    }

    public void setEvents(EventChecker events) {
        this.events = events;
    }

    public int getEventDiscountPrice() {
        return eventDiscountPrice;
    }

    public void setEventDiscountPrice(int eventDiscountPrice) {
        this.eventDiscountPrice = eventDiscountPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Badge getEventBadge() {
        return eventBadge;
    }

    public void setEventBadge(Badge eventBadge) {
        this.eventBadge = eventBadge;
    }
}
