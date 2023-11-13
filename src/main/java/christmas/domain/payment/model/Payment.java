package christmas.domain.payment.model;

public class Payment {

    private int orderPrice; //할인 전 총주문 금액

    private int weekDiscountPrice;//요일 할인
    private int dDayDiscountPrice; //디데이 할인
    private int sumOfDiscountPrice; //(총)할인 금액 = 요일 할인 + 디데이 할인

    private int eventMenuPrice;//증정 메뉴 금액  =샴페인(25,000)
    private int totalDiscountPrice; //총 혜택 금액 = sumOfDiscountPrice + eventMenuPrice;

    private int totalOrderPrice;//총주문 금액 = orderPrice - sumOfDiscountPrice
    private int eventDiscount;//특별 할인
    private int totalPrice; //할인 후 예상 결제 금액 = totalOrderPrice - eventDiscount;

}
