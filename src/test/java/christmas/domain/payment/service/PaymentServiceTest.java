package christmas.domain.payment.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.SpecialDiscount;
import christmas.domain.event.domain.SpecialMenuGift;
import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.reservation.model.ReservationDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    @DisplayName("주문 메뉴가 타파스 1개 일 때, 할인 전 총주문 가격 5500원을 반환한다 ")
    @Test
    void calculateOrderPrice() {
        ReservationDto reservationDto = makeReservationDto();
        PaymentService paymentService = new PaymentService();
        int orderPrice = 5500;

        paymentService.calculateOrderPrice(reservationDto);
        assertThat(paymentService.calculateOrderPrice(reservationDto)).isEqualTo(orderPrice);
    }

    @DisplayName("총 가격 계산 테스트")
    @Test
    void calculateTotalPrice() {
        ReservationDto reservationDto = makeReservationDto();
        PaymentService paymentService = new PaymentService();
        int totalPrice = 5500;

        assertThat(paymentService.calculateTotalPrice(reservationDto)).isEqualTo(totalPrice);
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
}