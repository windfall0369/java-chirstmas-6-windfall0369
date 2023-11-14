package christmas.domain.payment.controller;

import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.model.DiscountPrice;
import christmas.domain.payment.model.Payment;
import christmas.domain.payment.service.DiscountPriceService;
import christmas.domain.payment.service.PaymentService;
import christmas.domain.payment.view.outputView.PaymentOutputView;
import christmas.domain.reservation.model.ReservationDto;
import java.util.Map;

public class PaymentController {

    private final Payment payment = new Payment();
    private final PaymentOutputView outputView = new PaymentOutputView();
    private final PaymentService paymentService = new PaymentService();
    private final DiscountPriceService discountService = new DiscountPriceService();

    public int getOrderPrice(ReservationDto reservationDto) {
        int orderPrice = paymentService.calculateOrderPrice(reservationDto);
        payment.setOrderPrice(orderPrice); //할인 전 총주문
        outputView.printOrderPrice(orderPrice);
        return orderPrice;
    }

    public DiscountPrice getDiscountPrice(Map<EntireMenu, Integer> userMenu, EventChecker events) {

        return discountService.calculateDiscountPrice(userMenu, events);
    }

    public int getTotalPrice(ReservationDto reservationDto) {

        int totalPrice = paymentService.calculateTotalPrice(reservationDto);
        payment.setTotalPrice(totalPrice);
        outputView.printTotalPrice(totalPrice);
        return totalPrice;
    }

    public int getEventDiscount(DiscountPrice discountPrice, WeekDiscount weekDiscount) {
        int sumOfEventDiscountPrice = discountService.calculateSumOfEventDiscountPrice(
            discountPrice, weekDiscount);
        payment.setTotalDiscountPrice(sumOfEventDiscountPrice); //총 혜택 금액
        outputView.printAllEventDetail(discountPrice, weekDiscount);
        outputView.printAllEventDiscountPrice(sumOfEventDiscountPrice);
        return sumOfEventDiscountPrice;
    }
}
