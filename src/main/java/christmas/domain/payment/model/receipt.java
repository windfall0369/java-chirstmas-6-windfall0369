package christmas.domain.payment.model;

import christmas.domain.event.domain.EventChecker;

public class receipt {

    private Payment payment;
    private EventChecker eventChecker;
    private int reservationDate;

    public receipt(Payment payment, EventChecker eventChecker, int reservationDate) {
        this.payment = payment;
        this.eventChecker = eventChecker;
        this.reservationDate = reservationDate;
    }

    public void makeReceipt() {

    }
}
