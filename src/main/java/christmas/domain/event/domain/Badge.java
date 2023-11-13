package christmas.domain.event.domain;

public enum Badge {
    NOTHING(0),
    STAR(5_000),
    TREE(10_000),
    SANTA(20_000);

    private final int totalDiscountPrice;

    Badge(int totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public int getTotalDiscountPrice() {
        return totalDiscountPrice;
    }
}
