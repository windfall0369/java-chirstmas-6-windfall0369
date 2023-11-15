package christmas.domain.payment.model;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.reservation.model.ReservationDto;
import java.util.Map;

public class Receipt {

    private final int reservationDate;
    private final int orderPrice; //할인 전 총주문 금액
    private final EventChecker events;
    private final int totalDiscountPrice; //총 혜택 금액 = weekDiscountPrice + dDayDiscountPrice + eventMenuPrice + specialDiscount;
    private final int eventMenuPrice;
    private final int eventDiscountPrice;//할인 금액 =weekDiscountPrice + dDayDiscountPrice + specialDiscount;
    private final int totalPrice; //할인 후 예상 결제 금액 = orderPrice - eventDiscount;
    private final Map<EntireMenu, Integer> userMenu;

    public Receipt(ReservationDto reservationDto, Map<DiscountPolicy, Integer> discountPrice) {
        this.reservationDate = reservationDto.getReservationDate();
        this.userMenu = reservationDto.getUserMenu();
        this.orderPrice = reservationDto.getOrderPrice();
        this.events = reservationDto.getEvents();
        this.totalDiscountPrice = reservationDto.getEventDiscountPrice();
        this.eventMenuPrice = discountPrice.get(DiscountPolicy.EVENT_GIFT);
        this.eventDiscountPrice = totalDiscountPrice - eventMenuPrice;
        this.totalPrice = orderPrice - eventDiscountPrice;
    }

    public int getReservationDate() {
        return reservationDate;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public EventChecker getEvents() {
        return events;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public int getEventMenuPrice() {
        return eventMenuPrice;
    }

    public int getEventDiscountPrice() {
        return eventDiscountPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Map<EntireMenu, Integer> getUserMenu() {
        return userMenu;
    }
}
