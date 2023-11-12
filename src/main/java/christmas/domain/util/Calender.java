package christmas.domain.util;

public enum Calender {

    WEEK_1(0, 0, 0, 0, 0, 1, 2),
    WEEK_2(3, 4, 5, 6, 7, 8, 9),
    WEEK_3(10, 11, 12, 13, 14, 15, 16),
    WEEK_4(17, 18, 19, 20, 21, 22, 23),
    WEEK_5(24, 25, 26, 27, 28, 29, 30),
    WEEK_6(31, 0, 0, 0, 0, 0, 0),
    ;

    private final int sunday;
    private final int monday;
    private final int tuesday;
    private final int wednesday;
    private final int thursday;
    private final int friday;
    private final int saturday;

    Calender(int sunday, int monday, int tuesday, int wednesday, int thursday, int friday,
        int saturday) {
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }
}
