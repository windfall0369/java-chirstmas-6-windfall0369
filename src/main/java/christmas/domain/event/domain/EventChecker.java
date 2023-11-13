package christmas.domain.event.domain;

public class EventChecker {

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

    public void setWeekDiscount(WeekDiscount weekDiscount) {
        this.weekDiscount = weekDiscount;
    }

    public SpecialMenuGift getSpecialMenuGift() {
        return specialMenuGift;
    }

    public void setSpecialMenuGift(SpecialMenuGift specialMenuGift) {
        this.specialMenuGift = specialMenuGift;
    }

    public SpecialDiscount getSpecialDiscount() {
        return specialDiscount;
    }

    public void setSpecialDiscount(SpecialDiscount specialDiscount) {
        this.specialDiscount = specialDiscount;
    }
}
