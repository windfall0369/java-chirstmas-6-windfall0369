package christmas.domain.event.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.domain.Badge;
import christmas.domain.event.domain.EventChecker;
import christmas.domain.event.domain.SpecialMenuGift;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventServiceTest {

    @DisplayName("가격이 1만원 이하일 경우 이벤트 참여 불가")
    @Test
    void checkEventCondition() {
        EventService eventService = new EventService();
        int orderPrice = 1000;
        int reservationDate = 3;
        EventChecker eventChecker = eventService.checkEventCondition(orderPrice, reservationDate);

        assertThat(eventChecker.getdDayDiscount()).isEqualTo(2);
    }

    @DisplayName("증정 이벤트에 해당하지 않을 경우 false 반환")
    @Test
    void applySpecialMenu() {
        EventService eventService = new EventService();
        EventChecker eventChecker = new EventChecker();
        eventChecker.setSpecialMenuGift(SpecialMenuGift.NOT_PARTICIPATED);

        assertThat(eventService.applySpecialMenu(eventChecker)).isEqualTo(false);
    }

    @DisplayName("혜택 금액이 0원이면 뱃지를 받지 않는다")
    @Test
    void checkBadge() {
        EventService eventService = new EventService();
        int eventDiscountPrice = 0;
        Badge badge = eventService.checkBadge(eventDiscountPrice);

        assertThat(badge).isEqualTo(Badge.NOTHING);
    }
}