package christmas.domain.payment.service;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.SpecialMenuGift;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.reservation.model.ReservationDto;
import java.util.Map;
import java.util.Map.Entry;

public class PaymentService {

    public int calculateOrderPrice(ReservationDto reservationDto) {
        Map<EntireMenu, Integer> userMenu = reservationDto.getUserMenu();
        int orderPrice = 0;

        for (Entry<EntireMenu, Integer> menu : userMenu.entrySet()) {
            orderPrice += menu.getKey().getPrice() * menu.getValue();
        }
        return orderPrice;
    }

    public int calculateTotalPrice(ReservationDto reservationDto) {
        int orderPrice = reservationDto.getOrderPrice();
        EventChecker events = reservationDto.getEvents();
        int eventDiscountPrice = reservationDto.getEventDiscountPrice();

        int totalPrice;
        if (events.getSpecialMenuGift().equals(SpecialMenuGift.PARTICIPATED)) {
            totalPrice = orderPrice - eventDiscountPrice + EntireMenu.CHAMPAGNE.getPrice();
            return totalPrice;
        }
        totalPrice = orderPrice - eventDiscountPrice;
        return totalPrice;
    }

}
