package christmas.domain.event.service;

import christmas.domain.event.model.DdayDiscount;
import christmas.domain.event.model.EventList;
import christmas.domain.event.model.SpecialDiscount;
import christmas.domain.event.model.SpecialMenuGift;
import christmas.domain.event.model.WeekDiscount;
import christmas.domain.util.Calender;

public class EventService {

    private static final int EVENT_MINIMUM_PRICE = 10_000;
    private static final int EVENT_GIFT_MENU_MINIMUM_PRICE = 120_000;

    private final EventList events = new EventList();

    private void initEventCondition() {
        events.setSpecialMenuGift(SpecialMenuGift.NOT_PARTICIPATED);
        events.setdDayDiscount(DdayDiscount.NOT_PARTICIPATED);
        events.setWeekDiscount(WeekDiscount.NOT_PARTICIPATED);
        events.setSpecialDiscount(SpecialDiscount.NOT_PARTICIPATED);
    }

    public EventList checkEventCondition(int orderPrice, int reservationDate) {
        initEventCondition();

        if (checkMinPrice(orderPrice)) {
            checkSpecialMenuGift(orderPrice);
            checkDdayDiscount();
            checkWeekDiscount();
            checkSpecialDiscount(reservationDate);

            return events;
        }
        return events;
    }

    private boolean checkMinPrice(int orderPrice) {
        return orderPrice >= EVENT_MINIMUM_PRICE;
    }

    private void checkSpecialMenuGift(int orderPrice) {
        if (orderPrice >= EVENT_GIFT_MENU_MINIMUM_PRICE) {
            events.setSpecialMenuGift(SpecialMenuGift.PARTICIPATED);
        }
        events.setSpecialDiscount(SpecialDiscount.NOT_PARTICIPATED);

    }

    private void checkDdayDiscount() {
        events.setdDayDiscount(DdayDiscount.PARTICIPATED);

    }

    private void checkWeekDiscount() {
        events.setWeekDiscount(WeekDiscount.PARTICIPATED);

    }

    private void checkSpecialDiscount(int reservationDate) {
        for (Calender day : Calender.values()) {
            if (reservationDate == day.getSunday()
                || reservationDate == Calender.WEEK_5.getMonday()) {
                events.setSpecialDiscount(SpecialDiscount.PARTICIPATED);
            }
        }
    }

    public boolean applySpecialMenu(EventList eventList) {
        if (eventList.getSpecialMenuGift().equals(SpecialMenuGift.PARTICIPATED)) {
            return true;
        }
        return false;
    }
}
