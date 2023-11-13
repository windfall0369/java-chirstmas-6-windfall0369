package christmas.domain.menu.model;

public enum EntireMenu {
    MUSHROOM_SOUP(Course.APPETIZER, "양송이수프", 6_000),
    TAPAS(Course.APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(Course.APPETIZER, "시저샐러드", 8_000),
    ZERO_COKE(Course.BEVERAGE, "제로콜라", 3_000),
    RED_WINE(Course.BEVERAGE, "레드와인", 60_000),
    CHAMPAGNE(Course.BEVERAGE, "샴페인", 25_000),
    CHOCOLATE_CAKE(Course.DESSERT, "초코케이크", 15_000),
    ICE_CREAM(Course.DESSERT, "아이스크림", 5_000),
    T_BONE_STEAK(Course.MAIN_DISH, "티본스테이크", 55_000),
    BBQ_LIP(Course.MAIN_DISH, "바비큐립", 54_000),
    SEAFOOD_PASTA(Course.MAIN_DISH, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(Course.MAIN_DISH, "크리스마스파스타", 25_000),
    ;

    private final Course course;
    private final String name;
    private final int price;

    EntireMenu(Course course, String name, int price) {
        this.course = course;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Course getCourse() {
        return course;
    }
}
