package christmas.domain.payment.model;

public class Payment {

    private final int orderPrice;
    private final int totalDiscountPrice;
    private final int eventDiscountPrice;
    private final int totalPrice;

    public PaymentDto createDto() {
        return new PaymentDto();
    }

    public Payment(PaymentDto paymentDto) {
        this.orderPrice = paymentDto.getOrderPrice();
        this.totalDiscountPrice = paymentDto.getTotalDiscountPrice();
        this.eventDiscountPrice = paymentDto.getEventDiscountPrice();
        this.totalPrice = paymentDto.getTotalPrice();
    }
}
