package christmas.domain.payment.controller;

import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.payment.model.DiscountPolicy;
import christmas.domain.payment.model.DiscountPrice;
import christmas.domain.payment.model.Receipt;
import christmas.domain.payment.service.DiscountPriceService;
import christmas.domain.payment.service.PaymentService;
import christmas.domain.payment.view.outputView.PaymentOutputView;
import christmas.domain.reservation.model.ReservationDto;
import java.util.Map;

public class PaymentController {

    private final PaymentOutputView outputView = new PaymentOutputView();
    private final PaymentService paymentService = new PaymentService();
    private final DiscountPriceService discountService = new DiscountPriceService();

    public int getOrderPrice(ReservationDto reservationDto) {
        int orderPrice = paymentService.calculateOrderPrice(reservationDto);

        outputView.printOrderPrice(orderPrice);
        return orderPrice;
    }

    public DiscountPrice getDiscountPrice(ReservationDto reservationDto) {

        return discountService.calculateDiscountPrice(reservationDto);
    }

    public int getTotalPrice(ReservationDto reservationDto) {

        int totalPrice = paymentService.calculateTotalPrice(reservationDto);

        outputView.printTotalPrice(totalPrice);
        return totalPrice;
    }

    public int getEventDiscount(DiscountPrice discountPrice, WeekDiscount weekDiscount) {
        int sumOfEventDiscountPrice = discountService.calculateSumOfEventDiscountPrice(
            discountPrice, weekDiscount);

        outputView.printAllEventDetail(discountPrice, weekDiscount);
        outputView.printAllEventDiscountPrice(sumOfEventDiscountPrice);

        return sumOfEventDiscountPrice;
    }

    public Receipt getReceipt(ReservationDto reservationDto, DiscountPrice discountPrice) {
        Map<DiscountPolicy, Integer> discountPrices = discountPrice.getDiscountPrice();
        Receipt receipt = new Receipt(reservationDto, discountPrices);
        outputView.printReceipt(receipt);

        return receipt;
    }
}
