package christmas.domain.event.model;

public class EventList {

    private DdayDiscount dDayDiscount;
    private WeekDiscount weekDiscount;
    private SpecialMenuGift specialMenuGift;
    private SpecialDiscount specialDiscount;


    public DdayDiscount getdDayDiscount() {
        return dDayDiscount;
    }

    public void setdDayDiscount(DdayDiscount dDayDiscount) {
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
