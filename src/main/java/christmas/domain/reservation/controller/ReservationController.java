package christmas.domain.reservation.controller;

import christmas.domain.event.controller.EventController;
import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.controller.MenuController;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.payment.model.DiscountPrice;
import christmas.domain.payment.model.Receipt;
import christmas.domain.reservation.model.Reservation;
import christmas.domain.reservation.model.ReservationDto;
import christmas.domain.reservation.model.ReservationRepository;
import christmas.domain.reservation.view.inputView.ReservationInputView;
import christmas.domain.reservation.view.outputView.ReservationOutputView;
import java.util.Map;

public class ReservationController {

    private final ReservationInputView inputView = new ReservationInputView();
    private final ReservationOutputView outputView = new ReservationOutputView();
    private final PaymentController paymentController = new PaymentController();
    private final EventController eventController = new EventController();
    private final MenuController menuController = new MenuController();
    private final ReservationDto reservationDto = new ReservationDto();
    private final ReservationRepository reservationRepository = new ReservationRepository();

    public void chooseReservationDate() {
        outputView.printRequestVisitDate();

        int reservationDate = inputView.getUserVisitDate();
        this.reservationDto.setReservationDate(reservationDate);
    }

    public void makeReservationMenu() {
        Map<EntireMenu, Integer> userMenu = menuController.chooseMenu();

        this.reservationDto.setUserMenu(userMenu);
        menuController.showMenu(reservationDto);
    }

    public void getReservationOrderPrice() {
        int orderPrice = paymentController.getOrderPrice(this.reservationDto);

        this.reservationDto.setOrderPrice(orderPrice);
    }

    public void getDiscountList() {
        EventChecker events = eventController.getEvent(this.reservationDto);

        this.reservationDto.setEvents(events);
    }

    public void getReservationDiscountPrice() {
        EventChecker events = this.reservationDto.getEvents();
        DiscountPrice discountPrice = paymentController.getDiscountPrice(this.reservationDto);
        int eventDiscountPrice = paymentController.getEventDiscount(discountPrice,
            events.getWeekDiscount());

        this.reservationDto.setEventDiscountPrice(eventDiscountPrice);
    }

    public Reservation getReservationResult() {
        int totalPrice = paymentController.getTotalPrice(this.reservationDto);

        this.reservationDto.setTotalPrice(totalPrice);
        Badge eventBadge = eventController.getEventBadge(this.reservationDto);
        reservationDto.setEventBadge(eventBadge);

        return new Reservation(reservationDto);
    }

    public Receipt getReservationReceipt() {
        DiscountPrice discountPrice = paymentController.getDiscountPrice(this.reservationDto);

        return paymentController.getReceipt(this.reservationDto, discountPrice);
    }

    public void addReservationInRepository(Reservation reservation, Receipt receipt) {
        reservationRepository.addReservation(reservation, receipt);
    }
}
