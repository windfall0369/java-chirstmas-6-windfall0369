package christmas.domain.event.controller;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.service.EventService;
import christmas.domain.event.view.EventOutputView;

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

    public Badge getEventBadge(int eventDiscountPrice) {
        Badge evnetBadge = eventService.checkBadge(eventDiscountPrice);
        outputView.printEventBadge(evnetBadge);
        return evnetBadge;
    }
}
