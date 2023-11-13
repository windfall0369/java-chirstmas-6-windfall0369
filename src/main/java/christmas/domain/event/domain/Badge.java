package christmas.domain.event.domain;

public enum Badge {
    NOTHING(0, ""),
    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타");

    private final int totalDiscountPrice;
    private final String badgeName;

    Badge(int totalDiscountPrice, String badgeName) {
        this.totalDiscountPrice = totalDiscountPrice;
        this.badgeName = badgeName;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
