package christmas.domain.menu.model;

public enum MainDish {
    STEAK("티본스테이크", 55_000),
    LIP("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스터", 25_000),
    ;

    private final String name;
    private final int price;

    MainDish(String name, int price) {
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
