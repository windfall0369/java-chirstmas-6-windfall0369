package christmas.domain.event.controller;

import christmas.domain.event.model.EventChecker;
import christmas.domain.event.model.WeekDiscount;
import christmas.domain.event.service.EventService;
import christmas.domain.event.view.EventOutputView;
import java.util.List;

public class EventController {

    private final EventService eventService = new EventService();
    private final EventOutputView outputView = new EventOutputView();

    public EventChecker getEvent(int orderPrice, int reservationDate) {
        EventChecker eventChecker = eventService.checkEventCondition(orderPrice, reservationDate);

        if (eventService.applySpecialMenu(eventChecker)) {
            outputView.printEventMenuMessage();
            return eventChecker;
        }
        outputView.printNoEventMenuMessage();
        return eventChecker;
    }

    public void getEventDiscount(List<Integer> discountPrice, WeekDiscount weekDiscount) {
        outputView.printAllEventDetail(discountPrice, weekDiscount);
        int sumOfEventDiscountPrice = eventService.calculateSumOfEventDiscountPrice(discountPrice,
            weekDiscount);
        outputView.printAllEventDiscountPrice(sumOfEventDiscountPrice);
    }
}
