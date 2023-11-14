package christmas.domain.event.controller;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.service.EventService;
import christmas.domain.event.view.EventOutputView;
import christmas.domain.reservation.model.ReservationDto;

public class EventController {

    private final EventService eventService = new EventService();
    private final EventOutputView outputView = new EventOutputView();

    public EventChecker getEvent(ReservationDto reservationDto) {
        int orderPrice = reservationDto.getOrderPrice();
        int reservationDate = reservationDto.getReservationDate();
        EventChecker events = eventService.checkEventCondition(orderPrice, reservationDate);

        if (eventService.applySpecialMenu(events)) {
            outputView.printEventMenuMessage();
            return events;
        }
        outputView.printNoEventMenuMessage();
        return events;
    }

    public Badge getEventBadge(ReservationDto reservationDto) {
        int eventDiscountPrice = reservationDto.getEventDiscountPrice();
        Badge eventBadge = eventService.checkBadge(eventDiscountPrice);

        outputView.printEventBadge(eventBadge);

        return eventBadge;
    }
}
