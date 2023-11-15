package christmas.domain.event.domain;

public class EventChecker {

    private static final String WEEKEND_DISCOUNT = "주말 이벤 적용 ";
    private static final String WEEKDAY_DISCOUNT = "주중 이벤트 적용 ";
    private static final String NO_DATE_DISCOUNT = "요일 이벤트 미적용 ";
    private static final String SPECIAL_DISCOUNT = "특별할인 적용 ";
    private static final String NO_SPECIAL_DISCOUNT = "특별할인 미적용 ";
    private static final String SPECIAL_MENU_EVENT = "증정 이벤트 적용 ";
    private static final String NO_SPECIAL_MENU_EVENT = "증정 이벤트 미적용 ";
    private static final int SPECIAL_DISCOUNT_PRICE = 1000;
    private static final int NO_SPECIAL_DISCOUNT_PRICE = 0;

    private SpecialMenuGift specialMenuGift;
    private int dDayDiscount;
    private WeekDiscount weekDiscount;
    private SpecialDiscount specialDiscount;

    public int getdDayDiscount() {
        return dDayDiscount;
    }

    public void setdDayDiscount(int dDayDiscount) {
        this.dDayDiscount = dDayDiscount;
    }

    public WeekDiscount getWeekDiscount() {
        return weekDiscount;
    }

    public String getWeekDiscountCheck() {
        if (weekDiscount.equals(WeekDiscount.WEEKEND)) {
            return WEEKEND_DISCOUNT;
        }

        if (weekDiscount.equals(WeekDiscount.WEEKDAY)) {
            return WEEKDAY_DISCOUNT;
        }

        return NO_DATE_DISCOUNT;
    }

    public void setWeekDiscount(WeekDiscount weekDiscount) {
        this.weekDiscount = weekDiscount;
    }

    public SpecialMenuGift getSpecialMenuGift() {
        return specialMenuGift;
    }

    public String getSpecialMenuGiftCheck() {
        if (specialMenuGift.equals(SpecialMenuGift.PARTICIPATED)) {
            return SPECIAL_MENU_EVENT;
        }
        return NO_SPECIAL_MENU_EVENT;
    }

    public void setSpecialMenuGift(SpecialMenuGift specialMenuGift) {
        this.specialMenuGift = specialMenuGift;
    }

    public SpecialDiscount getSpecialDiscount() {
        return specialDiscount;
    }

    public String getSpecialDiscountCheck() {
        if (specialDiscount.equals(SpecialDiscount.PARTICIPATED)) {
            return SPECIAL_DISCOUNT;
        }

        return NO_SPECIAL_DISCOUNT;
    }

    public int getSpecialDiscountPrice() {
        if (specialDiscount.equals(SpecialDiscount.PARTICIPATED)) {
            return SPECIAL_DISCOUNT_PRICE;
        }
        return NO_SPECIAL_DISCOUNT_PRICE;
    }

    public void setSpecialDiscount(SpecialDiscount specialDiscount) {
        this.specialDiscount = specialDiscount;
    }
}
