package christmas.domain.payment.model;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.SpecialDiscount;
import christmas.domain.event.domain.SpecialMenuGift;
import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.menu.model.Course;
import christmas.domain.menu.model.EntireMenu;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DiscountPrice {

    private static final int SPECIAL_MENU_GIFT_PRICE = 25_000;
    private static final int D_DAY_DISCOUNT_PRICE_DEFAULT = 1_000;
    private static final int D_DAY_DISCOUNT_PRICE_PER_DAY = 100;
    private static final int SPECIAL_DISCOUNT = 1_000;
    private static final int NOT_EVENT_PARTICIPATED = 0;
    private static final int DEFAULT_DISCOUNT_PRICE = 0;
    private static final int WEEK_DISCOUNT_PRICE = 2_023;

    private final Map<DiscountPolicy, Integer> discountPrice = new HashMap<>();

    public Map<DiscountPolicy, Integer> getDiscountPrice() {
        return discountPrice;
    }

    public void calculateDdayDiscount(EventChecker events) {
        if (events.getWeekDiscount().equals(WeekDiscount.NOT_PARTICIPATED)) {
            return;
        }
        int dDayDiscountPrice = D_DAY_DISCOUNT_PRICE_DEFAULT;
        dDayDiscountPrice += D_DAY_DISCOUNT_PRICE_PER_DAY * events.getdDayDiscount();

        discountPrice.put(DiscountPolicy.DDAY, dDayDiscountPrice);
    }

    public void calculateWeekDiscount(Map<EntireMenu, Integer> userMenu, EventChecker events) {
        int weekDiscount = NOT_EVENT_PARTICIPATED;
        if (events.getWeekDiscount().equals(WeekDiscount.NOT_PARTICIPATED)) {
            return;
        }
        if (events.getWeekDiscount().equals(WeekDiscount.WEEKDAY)) {
            weekDiscount = calculateWeekdayDiscount(userMenu);
            discountPrice.put(DiscountPolicy.WEEKDAY, weekDiscount);
            return;
        }
        if (events.getWeekDiscount().equals(WeekDiscount.WEEKEND)) {
            weekDiscount = calculateWeekendDiscount(userMenu);
            discountPrice.put(DiscountPolicy.WEEKEND, weekDiscount);
        }
    }

    private int calculateWeekdayDiscount(Map<EntireMenu, Integer> userMenu) {
        int weekdayDiscount = DEFAULT_DISCOUNT_PRICE;

        for (Entry<EntireMenu, Integer> menu : userMenu.entrySet()) {
            if (menu.getKey().getCourse().equals(Course.DESSERT)) {
                weekdayDiscount += menu.getValue() * WEEK_DISCOUNT_PRICE;
            }
        }
        return weekdayDiscount;
    }

    private int calculateWeekendDiscount(Map<EntireMenu, Integer> userMenu) {
        int weekendDiscount = DEFAULT_DISCOUNT_PRICE;

        for (Entry<EntireMenu, Integer> menu : userMenu.entrySet()) {
            if (menu.getKey().getCourse().equals(Course.MAIN_DISH)) {
                weekendDiscount += menu.getValue() * WEEK_DISCOUNT_PRICE;
            }
        }
        return weekendDiscount;
    }

    public void calculateSpecialDiscount(EventChecker events) {
        if (events.getSpecialDiscount().equals(SpecialDiscount.PARTICIPATED)) {
            discountPrice.put(DiscountPolicy.SPECIAL, SPECIAL_DISCOUNT);
        }
    }

    public void calculateSpecialMenuGiftPrice(EventChecker events) {
        if (events.getSpecialMenuGift().equals(SpecialMenuGift.PARTICIPATED)) {
            discountPrice.put(DiscountPolicy.EVENT_GIFT, SPECIAL_MENU_GIFT_PRICE);
        }
    }
}
