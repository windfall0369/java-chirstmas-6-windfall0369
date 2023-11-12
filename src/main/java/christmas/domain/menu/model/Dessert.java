package christmas.domain.menu.model;

public enum Dessert {
    CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    ;

    private final String name;
    private final int price;

    Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
