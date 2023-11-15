package christmas.domain.payment.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.SpecialDiscount;
import christmas.domain.event.domain.SpecialMenuGift;
import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.payment.model.DiscountPolicy;
import christmas.domain.payment.model.DiscountPrice;
import christmas.domain.reservation.model.ReservationDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPriceServiceTest {

    @DisplayName("주문 가격이 0원이면 할인 가격이 0원이다")
    @Test
    void calculateDiscountPrice() {
        DiscountPriceService discountService = new DiscountPriceService();
        ReservationDto reservationDto = makeReservationDto();
        Map<DiscountPolicy, Integer> discountPrice = new HashMap<>();

        discountPrice.put(DiscountPolicy.EVENT_GIFT, 0);

        assertThat(
            discountService.calculateDiscountPrice(reservationDto).getDiscountPrice()).isEqualTo(
            discountPrice);
    }

    @DisplayName("테스트를 위한 ReservationDto 생성, 예약일 3일, 타파스 1개")
    ReservationDto makeReservationDto() {
        ReservationDto reservationDto = new ReservationDto();
        EventChecker events = new EventChecker();
        Map<EntireMenu, Integer> userMenu = new HashMap<>();
        int reservationDate = 3;
        int orderPrice = 5500;
        int eventDiscountPrice = 0;
        int totalPrice = 5500;

        userMenu.put(EntireMenu.TAPAS, 1);

        events.setdDayDiscount(2);
        events.setSpecialDiscount(SpecialDiscount.NOT_PARTICIPATED);
        events.setSpecialMenuGift(SpecialMenuGift.NOT_PARTICIPATED);
        events.setWeekDiscount(WeekDiscount.NOT_PARTICIPATED);

        reservationDto.setReservationDate(reservationDate);
        reservationDto.setOrderPrice(orderPrice);
        reservationDto.setUserMenu(userMenu);
        reservationDto.setEvents(events);
        reservationDto.setEventDiscountPrice(eventDiscountPrice);
        reservationDto.setTotalPrice(totalPrice);
        reservationDto.setEventBadge(Badge.NOTHING);

        return reservationDto;
    }

    @DisplayName("이벤트 불참인 경우 총혜택 금액 0원을 반환한다")
    @Test
    void calculateSumOfEventDiscountPrice() {
        DiscountPriceService discountService = new DiscountPriceService();
        DiscountPrice discountPrice = new DiscountPrice();

        WeekDiscount weekDiscount = WeekDiscount.NOT_PARTICIPATED;

        discountService.calculateSumOfEventDiscountPrice(discountPrice, weekDiscount);
    }
}