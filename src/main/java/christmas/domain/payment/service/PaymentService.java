package christmas.domain.payment.service;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.SpecialMenuGift;
import christmas.domain.menu.model.EntireMenu;
import java.util.Map;
import java.util.Map.Entry;

public class PaymentService {

    public int calculateOrderPrice(Map<EntireMenu, Integer> userMenu) {
        int orderPrice = 0;

        for (Entry<EntireMenu, Integer> menu : userMenu.entrySet()) {
            orderPrice += menu.getKey().getPrice() * menu.getValue();
        }
        return orderPrice;
    }

    public int calculateTotalPrice(int eventDiscountPrice, EventChecker events, int orderPrice) {
        int totalPrice;
        if (events.getSpecialMenuGift().equals(SpecialMenuGift.PARTICIPATED)) {
            totalPrice = orderPrice - eventDiscountPrice + EntireMenu.CHAMPAGNE.getPrice();
            return totalPrice;
        }
        totalPrice = orderPrice - eventDiscountPrice;
        return totalPrice;
    }

}
