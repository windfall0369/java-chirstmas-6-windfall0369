package christmas.domain.payment.model;

public class PaymentDto {

    private int orderPrice;
    private int totalDiscountPrice;
    private int eventDiscountPrice;
    private int totalPrice;

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
