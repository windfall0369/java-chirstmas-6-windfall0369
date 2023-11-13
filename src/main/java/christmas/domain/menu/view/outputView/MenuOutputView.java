package christmas.domain.menu.view.outputView;

import christmas.domain.menu.model.Course;
import christmas.domain.menu.model.EntireMenu;
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
    private static final String SPACE_BAR = " ";
    private static final String COUNT_UNIT = "개";

    public void printMenu() {
        System.out.println(ORDER_MENU_MESSAGE);
        printAppetizer();
        printMainDish();
        printDessert();
        printBeverage();
    }

    public void printUserMenu(Map<EntireMenu, Integer> userMenu) {
        System.out.println(DISH_START_FORMAT + ORDER_MENU + DISH_END_FORMAT);
        for (Entry<EntireMenu, Integer> userMenuName : userMenu.entrySet()) {
            System.out.println(
                userMenuName.getKey().getName() + SPACE_BAR + userMenuName.getValue() + COUNT_UNIT);
        }
    }

    private void printAppetizer() {
        System.out.println(DISH_START_FORMAT + APPETIZER + DISH_END_FORMAT);
        for (EntireMenu menu : EntireMenu.values()) {
            if (menu.getCourse() == Course.APPETIZER) {
                System.out.print(
                    menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
            }
        }
        System.out.println(NEXT_LINE_MARK);
    }

    private void printMainDish() {
        System.out.println(DISH_START_FORMAT + MAIN_DISH + DISH_END_FORMAT);
        for (EntireMenu menu : EntireMenu.values()) {
            if (menu.getCourse() == Course.MAIN_DISH) {
                System.out.print(
                    menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
            }
        }
        System.out.println(NEXT_LINE_MARK);
    }

    private void printDessert() {
        System.out.println(DISH_START_FORMAT + DESSERT + DISH_END_FORMAT);
        for (EntireMenu menu : EntireMenu.values()) {
            if (menu.getCourse() == Course.DESSERT) {
                System.out.print(
                    menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
            }
        }
        System.out.println(NEXT_LINE_MARK);
    }

    private void printBeverage() {
        System.out.println(DISH_START_FORMAT + BEVERAGE + DISH_END_FORMAT);
        for (EntireMenu menu : EntireMenu.values()) {
            if (menu.getCourse() == Course.BEVERAGE) {
                System.out.print(
                    menu.getName() + PRICE_START_FORMAT + menu.getPrice() + PRICE_END_FORMAT);
            }
        }
        System.out.println(NEXT_LINE_MARK);
    }
}
