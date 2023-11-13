package christmas.domain.payment.service;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.model.DiscountPrice;
import java.util.Map;

public class DiscountPriceService {

    public DiscountPrice calculateDiscountPrice(Map<EntireMenu, Integer> userMenu,
        EventChecker events) {
        DiscountPrice discountPrice = new DiscountPrice();
        discountPrice.calculateDdayDiscount(events);
        discountPrice.calculateWeekDiscount(userMenu, events);
        discountPrice.calculateSpecialDiscount(events);
        discountPrice.calculateSpecialMenuGiftPrice(events);

        return discountPrice;
    }

    public int calculateSumOfEventDiscountPrice(DiscountPrice discountPrice,
        WeekDiscount weekDiscount) {
        int sumOfEventDiscountPrice = 0;

        if (weekDiscount.equals(WeekDiscount.NOT_PARTICIPATED)) {
            return sumOfEventDiscountPrice;
        }
        for (Integer discount : discountPrice.getDiscountPrice().values()) {
            sumOfEventDiscountPrice += discount;
        }

        return sumOfEventDiscountPrice;
    }
}