package christmas.domain.menu.model;

public enum Appetizer {

    SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    SALAD("시저샐러드", 8_000),
    ;

    private final String name;
    private final int price;

    Appetizer(String name, int price) {
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

