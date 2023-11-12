package christmas.domain.menu.view.outputView;

import christmas.domain.menu.model.Appetizer;
import christmas.domain.menu.model.Dessert;
import christmas.domain.menu.model.MainDish;
import java.util.Map;
import java.util.Map.Entry;

public class MenuOutputView {

    private static final String DISH_START_FORMAT = "<";
    private static final String DISH_END_FORMAT = ">";
    private static final String PRICE_START_FORMAT = "(";
    private static final String PRICE_END_FORMAT = "), ";
    private static final String APPETIZER = "애피타이저";
    private static final String MAIN_DISH = "메인";
    private static final String DESSERT = "디저트";
    private static final String BEVERAGE = "음료";
    private static final String NEXT_LINE_MARK = "\n";
    private static final String ORDER_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String ORDER_MENU = "주문 메뉴";


    public void printMenu() {
        System.out.println(ORDER_MENU_MESSAGE);
        printAppetizer();
        printMainDish();
        printDessert();
        printBeverage();
    }

    public void printUserMenu(Map<String, Integer> userMenu) {
        System.out.println(DISH_START_FORMAT + ORDER_MENU + DISH_END_FORMAT);
        for (Entry<String, Integer> userMenuType : userMenu.entrySet()) {
            System.out.println(userMenuType.getKey() + " " + userMenuType.getValue() + "개");
        }
    }


    private void printAppetizer() {
        System.out.println(DISH_START_FORMAT + APPETIZER + DISH_END_FORMAT);
        for (Appetizer menu : Appetizer.values()) {
            System.out.print(
                menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
        }
        System.out.println(NEXT_LINE_MARK);
    }

    private void printMainDish() {
        System.out.println(DISH_START_FORMAT + MAIN_DISH + DISH_END_FORMAT);
        for (MainDish menu : MainDish.values()) {
            System.out.print(
                menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
        }
        System.out.println(NEXT_LINE_MARK);
    }

    private void printDessert() {
        System.out.println(DISH_START_FORMAT + DESSERT + DISH_END_FORMAT);
        for (Dessert menu : Dessert.values()) {
            System.out.print(
                menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
        }
        System.out.println(NEXT_LINE_MARK);
    }

    private void printBeverage() {
        System.out.println(DISH_START_FORMAT + BEVERAGE + DISH_END_FORMAT);
        for (Dessert menu : Dessert.values()) {
            System.out.print(
                menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
        }
        System.out.println(NEXT_LINE_MARK);
    }
}
