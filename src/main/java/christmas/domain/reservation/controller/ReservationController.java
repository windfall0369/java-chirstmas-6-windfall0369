package christmas.domain.reservation.controller;

import christmas.domain.event.controller.EventController;
import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.menu.controller.MenuController;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.controller.PaymentController;
import christmas.domain.payment.model.DiscountPrice;
import christmas.domain.reservation.model.ReservationDto;
import christmas.domain.reservation.view.inputView.ReservationInputView;
import christmas.domain.reservation.view.outputView.ReservationOutputView;
import java.util.Map;

public class ReservationController {

    private final ReservationInputView inputView = new ReservationInputView();
    private final ReservationOutputView outputView = new ReservationOutputView();
    private final PaymentController paymentController = new PaymentController();
    private final EventController eventController = new EventController();
    private final MenuController menuController = new MenuController();

    public ReservationDto chooseReservationDate() {
        ReservationDto reservationDto = new ReservationDto();
        int reservationDate;

        outputView.printRequestVisitDate();
        reservationDate = inputView.getUserVisitDate();
        reservationDto.setReservationDate(reservationDate);

        return reservationDto;
    }

    public ReservationDto makeReservationMenu(ReservationDto reservationDto) {
        Map<EntireMenu, Integer> userMenu = menuController.chooseMenu(); //고객 주문 메뉴

        reservationDto.setUserMenu(userMenu);
        menuController.showMenu(reservationDto);

        return reservationDto;
    }

    public ReservationDto getReservationOrderPrice(ReservationDto reservationDto) {
        int orderPrice = paymentController.getOrderPrice(reservationDto);

        reservationDto.setOrderPrice(orderPrice);

        return reservationDto;
    }

    public ReservationDto getDiscountList(ReservationDto reservationDto) {
        EventChecker events = eventController.getEvent(reservationDto);//이벤트 참가 목록

        reservationDto.setEvents(events);

        return reservationDto;
    }

    public ReservationDto getReservationDiscountPrice(ReservationDto reservationDto) {
        Map<EntireMenu, Integer> userMenu = reservationDto.getUserMenu();
        EventChecker events = reservationDto.getEvents();
        DiscountPrice discountPrice = paymentController.getDiscountPrice(reservationDto);
        int eventDiscountPrice = paymentController.getEventDiscount(discountPrice,
            events.getWeekDiscount());//총혜택 금액 출력

        reservationDto.setEventDiscountPrice(eventDiscountPrice);

        return reservationDto;
    }

    public ReservationDto getReservationResult(ReservationDto reservationDto) {
        int totalPrice = paymentController.getTotalPrice(reservationDto); //할인 후 예상 결제 금액 계산

        reservationDto.setTotalPrice(totalPrice);
        Badge eventBadge = eventController.getEventBadge(reservationDto);//이벤트 배지
        reservationDto.setEventBadge(eventBadge);

        return reservationDto;
    }
}
