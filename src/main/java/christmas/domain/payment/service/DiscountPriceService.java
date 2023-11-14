package christmas.domain.payment.service;

import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.payment.model.DiscountPrice;
import christmas.domain.reservation.model.ReservationDto;

public class DiscountPriceService {

    public DiscountPrice calculateDiscountPrice(ReservationDto reservationDto) {
        DiscountPrice discountPrice = new DiscountPrice();
        discountPrice.calculateDdayDiscount(reservationDto);
        discountPrice.calculateWeekDiscount(reservationDto);
        discountPrice.calculateSpecialDiscount(reservationDto);
        discountPrice.calculateSpecialMenuGiftPrice(reservationDto);

        return discountPrice;
    }

    public int calculateSumOfEventDiscountPrice(DiscountPrice discountPrice,
        WeekDiscount weekDiscount) {
        int sumOfEventDiscountPrice = 0;

        if (weekDiscount.equals(WeekDiscount.NOT_PARTICIPATED)) {
            return sumOfEventDiscountPrice;
        }
        for (Integer discount : discountPrice.getDiscountPrice().values()) {
            sumOfEventDiscountPrice += discount;
        }

        return sumOfEventDiscountPrice;
    }
}