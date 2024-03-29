package christmas.domain.event.service;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.SpecialDiscount;
import christmas.domain.event.domain.SpecialMenuGift;
import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.util.Calender;

public class EventService {

    private static final int EVENT_MINIMUM_PRICE = 10_000;
    private static final int EVENT_GIFT_MENU_MINIMUM_PRICE = 120_000;
    private static final int CHRISTMAS_DAY = 25;

    private final EventChecker eventChecker = new EventChecker();

    private void initEventCondition(int dDayCount) {
        eventChecker.setSpecialMenuGift(SpecialMenuGift.NOT_PARTICIPATED);
        eventChecker.setdDayDiscount(dDayCount);
        eventChecker.setWeekDiscount(WeekDiscount.NOT_PARTICIPATED);
        eventChecker.setSpecialDiscount(SpecialDiscount.NOT_PARTICIPATED);
    }

    public EventChecker checkEventCondition(int orderPrice, int reservationDate) {
        int dDayCount = checkDdayDiscount(reservationDate);
        initEventCondition(dDayCount);

        if (checkMinPrice(orderPrice)) {
            eventChecker.setSpecialMenuGift(checkSpecialMenuGift(orderPrice));
            eventChecker.setdDayDiscount(dDayCount);
            eventChecker.setWeekDiscount(checkWeekDiscount(reservationDate));
            eventChecker.setSpecialDiscount(checkSpecialDiscount(reservationDate));
            return eventChecker;
        }
        return eventChecker;
    }

    private boolean checkMinPrice(int orderPrice) {
        return orderPrice >= EVENT_MINIMUM_PRICE;
    }

    private SpecialMenuGift checkSpecialMenuGift(int orderPrice) {
        if (orderPrice >= EVENT_GIFT_MENU_MINIMUM_PRICE) {
            return SpecialMenuGift.PARTICIPATED;
        }
        return SpecialMenuGift.NOT_PARTICIPATED;
    }

    private int checkDdayDiscount(int reservationDate) {
        int dDayCount = 0;
        if (reservationDate <= CHRISTMAS_DAY) {
            dDayCount = reservationDate - 1;
            return dDayCount;
        }
        return dDayCount;
    }


    private WeekDiscount checkWeekDiscount(int reservationDate) {
        for (Calender day : Calender.values()) {
            if (reservationDate == day.getFriday() || reservationDate == day.getSaturday()) {
                return WeekDiscount.WEEKEND;
            }
        }
        return WeekDiscount.WEEKDAY;
    }

    private SpecialDiscount checkSpecialDiscount(int reservationDate) {
        for (Calender day : Calender.values()) {
            if (reservationDate == day.getSunday()
                || reservationDate == Calender.WEEK_5.getMonday()) {
                return SpecialDiscount.PARTICIPATED;
            }
        }
        return SpecialDiscount.NOT_PARTICIPATED;
    }

    public boolean applySpecialMenu(EventChecker eventChecker) {
        if (eventChecker.getSpecialMenuGift().equals(SpecialMenuGift.PARTICIPATED)) {
            return true;
        }
        return false;
    }

    public Badge checkBadge(int eventDiscountPrice) {
        if (eventDiscountPrice >= Badge.SANTA.getTotalDiscountPrice()) {
            return Badge.SANTA;
        }
        if (eventDiscountPrice >= Badge.TREE.getTotalDiscountPrice()) {
            return Badge.TREE;
        }
        if (eventDiscountPrice >= Badge.STAR.getTotalDiscountPrice()) {
            return Badge.STAR;
        }

        return Badge.NOTHING;
    }
}
