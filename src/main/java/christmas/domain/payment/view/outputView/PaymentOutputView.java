package christmas.domain.payment.view.outputView;

public class PaymentOutputView {

    private static final String ORDER_PRICE = "<할인 전 총주문 금액>";

    public void printOrderPrice(int orderPrice) {
        System.out.println(ORDER_PRICE);
        System.out.printf("%,d원", orderPrice);
    }

}
