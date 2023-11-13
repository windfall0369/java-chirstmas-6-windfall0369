package christmas.domain.payment.view.outputView;

import christmas.domain.event.domain.WeekDiscount;
import christmas.domain.payment.model.DiscountPolicy;
import christmas.domain.payment.model.DiscountPrice;

public class PaymentOutputView {

    private static final String ORDER_PRICE = "할인 전 총주문 금액";
    private static final String START_FORMAT = "<";
    private static final String END_FORMAT = ">";
    private static final String NEXT_LINE_MARK = "\n";
    private static final String EVENT_DETAIL = "혜택 내역";
    private static final String D_DAY_DISCOUNT = "크리스마스 디데이 할인";
    private static final String WEEKDAY_DISCOUNT = "평일 할인:";
    private static final String WEEKEND_DISCOUNT = "주말 할인:";
    private static final String SPECIAL_DISCOUNT = "특별 할인:";
    private static final String SPECIAL_MENU_EVENT = "증정 이벤트:";
    private static final String EVENT_DETAIL_EMPTY = "없음";
    private static final String DISCOUNT_MARK = "-";
    private static final String DISCOUNT_UNIT = "원";
    private static final String PRICE_FORMAT = "%,d원";
    private static final String TOTAL_DISCOUNT_PRICE = "총혜택 금액";
    private static final String TOTAL_PRICE = "할인 후 예상 결제 금액";

    public void printOrderPrice(int orderPrice) {
        System.out.print(NEXT_LINE_MARK);
        System.out.println(START_FORMAT + ORDER_PRICE + END_FORMAT);
        System.out.printf("%,d원" + NEXT_LINE_MARK, orderPrice);
        System.out.print(NEXT_LINE_MARK);
    }

    public void printAllEventDetail(DiscountPrice discountPrice, WeekDiscount weekDiscount) {
        System.out.println(START_FORMAT + EVENT_DETAIL + END_FORMAT);
        if (weekDiscount.equals(WeekDiscount.NOT_PARTICIPATED)) {
            printDiscountEmpty();
            return;
        }
        printTotalDiscount(discountPrice);

    }

    private void printDiscountEmpty() {
        System.out.println(EVENT_DETAIL_EMPTY);
    }

    private void printTotalDiscount(DiscountPrice discountPrice) {
        if (discountPrice.getDiscountPrice().containsKey(DiscountPolicy.DDAY)) {
            System.out.println(D_DAY_DISCOUNT + DISCOUNT_MARK + discountPrice.getDiscountPrice()
                .get(DiscountPolicy.DDAY) + DISCOUNT_UNIT);
        }
        if (discountPrice.getDiscountPrice().containsKey(DiscountPolicy.WEEKDAY)) {
            System.out.println(WEEKDAY_DISCOUNT + DISCOUNT_MARK + discountPrice.getDiscountPrice()
                .get(DiscountPolicy.WEEKDAY) + DISCOUNT_UNIT);
        }
        if (discountPrice.getDiscountPrice().containsKey(DiscountPolicy.WEEKEND)) {
            System.out.println(WEEKEND_DISCOUNT + DISCOUNT_MARK + discountPrice.getDiscountPrice()
                .get(DiscountPolicy.WEEKEND) + DISCOUNT_UNIT);
        }
        if (discountPrice.getDiscountPrice().containsKey(DiscountPolicy.SPECIAL)) {
            System.out.println(SPECIAL_DISCOUNT + DISCOUNT_MARK + discountPrice.getDiscountPrice()
                .get(DiscountPolicy.SPECIAL) + DISCOUNT_UNIT);
        }
        if (discountPrice.getDiscountPrice().containsKey(DiscountPolicy.EVENT_GIFT)) {
            System.out.println(SPECIAL_MENU_EVENT + DISCOUNT_MARK + discountPrice.getDiscountPrice()
                .get(DiscountPolicy.EVENT_GIFT) + DISCOUNT_UNIT);
        }
    }

    public void printAllEventDiscountPrice(int sumOfEventDiscountPrice) {
        System.out.print(NEXT_LINE_MARK);
        System.out.println(START_FORMAT + TOTAL_DISCOUNT_PRICE + END_FORMAT);
        System.out.printf(PRICE_FORMAT, sumOfEventDiscountPrice);
        System.out.print(NEXT_LINE_MARK);
    }

    public void printTotalPrice(int totalPrice) {
        System.out.print(NEXT_LINE_MARK);
        System.out.println(START_FORMAT + TOTAL_PRICE + END_FORMAT);
        System.out.printf(PRICE_FORMAT, totalPrice);
    }
}
