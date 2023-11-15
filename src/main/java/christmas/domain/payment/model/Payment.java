package christmas.domain.payment.model;

public class Payment {

    private int orderPrice; //할인 전 총주문 금액
    private int totalDiscountPrice; //총 혜택 금액 = weekDiscountPrice + dDayDiscountPrice + eventMenuPrice + specialDiscount;
    private int eventDiscountPrice;//할인 금액 =weekDiscountPrice + dDayDiscountPrice + specialDiscount;
    private int totalPrice; //할인 후 예상 결제 금액 = orderPrice - eventDiscount;

    public PaymentDto createDto() {
        return new PaymentDto();
    }
}
