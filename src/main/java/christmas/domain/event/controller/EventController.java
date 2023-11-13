package christmas.domain.event.controller;

import christmas.domain.event.model.EventList;
import christmas.domain.event.service.EventService;
import christmas.domain.event.view.EventOutputView;

public class EventController {

    private final EventService eventService = new EventService();
    private final EventOutputView outputView = new EventOutputView();

    public EventList handleEvent(int orderPrice, int reservationDate) {
        EventList events = eventService.checkEventCondition(orderPrice, reservationDate);

        if (eventService.applySpecialMenu(events)) {
            outputView.printEventMenuMessage();
            return events;
        }
        outputView.printNoEventMenuMessage();
        return events;
    }
}
