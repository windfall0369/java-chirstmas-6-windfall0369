package christmas.domain.discount.service;

import christmas.domain.event.model.EventChecker;
import christmas.domain.event.model.SpecialDiscount;
import christmas.domain.event.model.SpecialMenuGift;
import christmas.domain.event.model.WeekDiscount;
import christmas.domain.menu.model.Course;
import christmas.domain.menu.model.EntireMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DiscountService {

    private static final int SPECIAL_MENU_GIFT_PRICE = 25_000;
    private static final int NOT_SPECIAL_MENU_SERVED = 0;
    private static final int D_DAY_DISCOUNT_PRICE_DEFAULT = 1_000;
    private static final int D_DAY_DISCOUNT_PRICE_PER_DAY = 100;
    private static final int SPECIAL_DISCOUNT = 1_000;
    private static final int NOT_SPECIAL_DISCOUNT = 0;
    private static final int NOT_EVENT_PARTICIPATED = 0;
    private static final int DEFAULT_DISCOUNT_PRICE = 0;
    private static final int WEEK_DISCOUNT_PRICE = 2_023;

    public List<Integer> calculateDiscountPrice(Map<EntireMenu, Integer> userMenu,
        EventChecker events) {
        List<Integer> discountPrice = new ArrayList<>();
        int dDayDiscountPrice = calculateDdayDiscount(events);
        int weekDiscountPrice = calculateWeekDiscount(userMenu, events);
        int specialDiscountPrice = calculateSpecialDiscount(events);
        int specialMenuGiftPrice = calculateSpecialMenuGiftPrice(events);

        discountPrice.add(dDayDiscountPrice);
        discountPrice.add(weekDiscountPrice);
        discountPrice.add(specialDiscountPrice);
        discountPrice.add(specialMenuGiftPrice);

        //디데이 할인, 평일-주말 할인, 특별 할인, 증정 이벤트 순서
        return discountPrice;
    }

    private int calculateDdayDiscount(EventChecker events) {
        if (events.getWeekDiscount().equals(WeekDiscount.NOT_PARTICIPATED)) {
            return NOT_SPECIAL_DISCOUNT;
        }
        int dDayDiscountPrice = D_DAY_DISCOUNT_PRICE_DEFAULT;
        dDayDiscountPrice += D_DAY_DISCOUNT_PRICE_PER_DAY * events.getdDayDiscount();

        return dDayDiscountPrice;
    }

    private int calculateWeekDiscount(Map<EntireMenu, Integer> userMenu, EventChecker events) {
        int weekDiscount = NOT_EVENT_PARTICIPATED;
        if (events.getWeekDiscount().equals(WeekDiscount.NOT_PARTICIPATED)) {
            return weekDiscount;
        }
        if (events.getWeekDiscount().equals(WeekDiscount.WEEKDAY)) {
            weekDiscount = calculateWeekdayDiscount(userMenu);
        }
        if (events.getWeekDiscount().equals(WeekDiscount.WEEKEND)) {
            weekDiscount = calculateWeekendDiscount(userMenu);
        }

        return weekDiscount;
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

    private int calculateSpecialDiscount(EventChecker events) {
        if (events.getSpecialDiscount().equals(SpecialDiscount.PARTICIPATED)) {
            return SPECIAL_DISCOUNT;
        }
        return NOT_SPECIAL_DISCOUNT;
    }

    private int calculateSpecialMenuGiftPrice(EventChecker events) {
        if (events.getSpecialMenuGift().equals(SpecialMenuGift.PARTICIPATED)) {
            return SPECIAL_MENU_GIFT_PRICE;
        }
        return NOT_SPECIAL_MENU_SERVED;
    }
}
