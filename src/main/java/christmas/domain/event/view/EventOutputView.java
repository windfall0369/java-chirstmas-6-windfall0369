package christmas.domain.event.view;

import christmas.domain.event.model.WeekDiscount;
import java.util.List;

public class EventOutputView {

    private static final String START_FORMAT = "<";
    private static final String END_FORMAT = ">";
    private static final String EVENT_MENU_MESSAGE = "증정 메뉴";
    private static final String EVENT_MENU = "샴페인 1병";
    private static final String NO_EVENT_MENU = "없음";
    private static final String EVENT_DETAIL = "혜택 내역";
    private static final String D_DAY_DISCOUNT = "크리스마스 디데이 할인";
    private static final String WEEKDAY_DISCOUNT = "평일 할인:";
    private static final String WEEKEND_DISCOUNT = "주말 할인:";
    private static final String SPECIAL_DISCOUNT = "특별 할인:";
    private static final String SPECIAL_MENU_EVENT = "증정 이벤트:";
    private static final int D_DAY_DISCOUNT_INDEX = 0;
    private static final int WEEK_DISCOUNT_INDEX = 1;
    private static final int SPECIAL_DISCOUNT_INDEX = 2;
    private static final int SPECIAL_MENU_EVENT_INDEX = 3;
    private static final String EVENT_DETAIL_EMPTY = "없음";
    private static final String DISCOUNT_MARK = "-";
    private static final String DISCOUNT_UNIT = "원";
    private static final String DISCOUNT_PRICE_FORMAT = "%,d원";
    private static final String TOTAL_DISCOUNT_PRICE = "총 헤택 금액";


    public void printEventMenuMessage() {
        System.out.println(START_FORMAT + EVENT_MENU_MESSAGE + END_FORMAT);
        System.out.println(EVENT_MENU);
    }

    public void printNoEventMenuMessage() {
        System.out.println(START_FORMAT + EVENT_MENU_MESSAGE + END_FORMAT);
        System.out.println(NO_EVENT_MENU);
    }

    public void printAllEventDetail(List<Integer> discountPrice, WeekDiscount weekDiscount) {
        System.out.println(START_FORMAT + EVENT_DETAIL + END_FORMAT);
        if (weekDiscount.equals(WeekDiscount.NOT_PARTICIPATED)) {
            printDiscountEmpty();
        }

        if (weekDiscount.equals(WeekDiscount.WEEKDAY)) {
            printWeekdayDiscount(discountPrice);
        }

        if (weekDiscount.equals(WeekDiscount.WEEKEND)) {
            printWeekendDiscount(discountPrice);
        }
    }

    public void printAllEventDiscountPrice(int sumOfEventDiscountPrice) {
        System.out.println(START_FORMAT + TOTAL_DISCOUNT_PRICE + END_FORMAT);
        System.out.printf(DISCOUNT_PRICE_FORMAT, sumOfEventDiscountPrice);
    }

    private void printDiscountEmpty() {
        System.out.println(EVENT_DETAIL_EMPTY);
    }

    private void printWeekdayDiscount(List<Integer> discountPrice) {
        System.out.println(D_DAY_DISCOUNT + DISCOUNT_MARK + discountPrice.get(D_DAY_DISCOUNT_INDEX)
            + DISCOUNT_UNIT);
        System.out.println(WEEKDAY_DISCOUNT + DISCOUNT_MARK + discountPrice.get(WEEK_DISCOUNT_INDEX)
            + DISCOUNT_UNIT);
        System.out.println(
            SPECIAL_DISCOUNT + DISCOUNT_MARK + discountPrice.get(SPECIAL_DISCOUNT_INDEX)
                + DISCOUNT_UNIT);
        System.out.println(
            SPECIAL_MENU_EVENT + DISCOUNT_MARK + discountPrice.get(SPECIAL_MENU_EVENT_INDEX)
                + DISCOUNT_UNIT);
    }

    private void printWeekendDiscount(List<Integer> discountPrice) {
        System.out.println(D_DAY_DISCOUNT + DISCOUNT_MARK + discountPrice.get(D_DAY_DISCOUNT_INDEX)
            + DISCOUNT_UNIT);
        System.out.println(WEEKEND_DISCOUNT + DISCOUNT_MARK + discountPrice.get(WEEK_DISCOUNT_INDEX)
            + DISCOUNT_UNIT);
        System.out.println(
            SPECIAL_DISCOUNT + DISCOUNT_MARK + discountPrice.get(SPECIAL_DISCOUNT_INDEX)
                + DISCOUNT_UNIT);
        System.out.println(
            SPECIAL_MENU_EVENT + DISCOUNT_MARK + discountPrice.get(SPECIAL_MENU_EVENT_INDEX)
                + DISCOUNT_UNIT);

    }
}
