package christmas.domain.payment.model;

public class PaymentDto {

    private int orderPrice; //할인 전 총주문 금액
    private int totalDiscountPrice; //총 혜택 금액 = weekDiscountPrice + dDayDiscountPrice + eventMenuPrice + specialDiscount;
    private int eventDiscountPrice;//할인 금액 =weekDiscountPrice + dDayDiscountPrice + specialDiscount;
    private int totalPrice; //할인 후 예상 결제 금액 = orderPrice - eventDiscount;

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public void setTotalDiscountPrice(int totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public int getEventDiscountPrice() {
        return eventDiscountPrice;
    }

    public void setEventDiscountPrice(int eventDiscountPrice) {
        this.eventDiscountPrice = eventDiscountPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
