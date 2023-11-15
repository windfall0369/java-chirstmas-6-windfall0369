package christmas.domain.payment.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentDtoTest {

    @DisplayName("Test를 위한 PaymentDto 생성")
    PaymentDto makePaymentDto() {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setOrderPrice(5500);
        paymentDto.setEventDiscountPrice(0);
        paymentDto.setTotalDiscountPrice(0);
        paymentDto.setTotalPrice(5500);

        return paymentDto;
    }

    @DisplayName("주문 가격이 5000원인지 확인한다")
    @Test
    void getOrderPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int orderPrice = 5500;

        assertThat(paymentDto.getOrderPrice()).isEqualTo(orderPrice);
    }

    @DisplayName("주문 가격이 11000원으로 변경됐는지 확인한다")
    @Test
    void setOrderPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int orderPrice = 5500;
        int changedOrderPrice = 11000;

        assertThat(paymentDto.getOrderPrice()).isEqualTo(orderPrice);
        paymentDto.setOrderPrice(changedOrderPrice);
        assertThat(paymentDto.getOrderPrice()).isEqualTo(changedOrderPrice);
    }


    @DisplayName("총혜택 가격이 0원인지 확인한다")
    @Test
    void getTotalDiscountPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int totalDiscountPrice = 0;

        assertThat(paymentDto.getTotalDiscountPrice()).isEqualTo(totalDiscountPrice);
    }

    @DisplayName("총혜택 가격이 1000원으로 변경됐는지 확인한다")
    @Test
    void setTotalDiscountPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int totalDiscountPrice = 0;
        int changedTotalDiscountPrice = 1000;

        assertThat(paymentDto.getTotalDiscountPrice()).isEqualTo(totalDiscountPrice);
        paymentDto.setTotalDiscountPrice(changedTotalDiscountPrice);
        assertThat(paymentDto.getTotalDiscountPrice()).isEqualTo(changedTotalDiscountPrice);
    }

    @DisplayName("할인 가격이 0원인지 확인한다")
    @Test
    void getEventDiscountPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int eventDiscountPrice = 0;

        assertThat(paymentDto.getEventDiscountPrice()).isEqualTo(eventDiscountPrice);
    }

    @DisplayName("할인 가격이 1000원으로 변경됐는지 확인한다")
    @Test
    void setEventDiscountPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int eventDiscountPrice = 0;
        int changedEventDiscountPrice = 1000;

        assertThat(paymentDto.getEventDiscountPrice()).isEqualTo(eventDiscountPrice);
        paymentDto.setEventDiscountPrice(changedEventDiscountPrice);
        assertThat(paymentDto.getEventDiscountPrice()).isEqualTo(changedEventDiscountPrice);

    }

    @DisplayName("총 가격이 5500원인지 확인한다")
    @Test
    void getTotalPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int totalPrice = 5500;

        assertThat(paymentDto.getTotalPrice()).isEqualTo(totalPrice);
    }

    @DisplayName("총 가격이 11000원으로 변경됐는지 확인한다")
    @Test
    void setTotalPrice() {
        PaymentDto paymentDto = makePaymentDto();
        int totalPrice = 5500;
        int changedTotalPrice = 11000;

        assertThat(paymentDto.getTotalPrice()).isEqualTo(totalPrice);
        paymentDto.setTotalPrice(changedTotalPrice);
        assertThat(paymentDto.getTotalPrice()).isEqualTo(changedTotalPrice);
    }
}