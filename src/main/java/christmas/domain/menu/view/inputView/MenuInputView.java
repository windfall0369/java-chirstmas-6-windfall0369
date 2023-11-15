package christmas.domain.menu.view.inputView;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.menu.model.Course;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.util.message.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuInputView {

    private static final String PAIR_DELIMITER = "-";
    private static final String SPLIT_DELIMITER = ",";
    private static final int MENU_NAME_INDEX = 0;
    private static final int MENU_AMOUNT_INDEX = 1;
    private static final int INDEX_START = 0;
    private static final int MINIMUM_AMOUNT = 1;
    private static final int MAXIMUM_AMOUNT = 20;


    public Map<EntireMenu, Integer> getUserMenu() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validateMenuInput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_ORDER.getErrorMessage());
            }
        }
    }

    private Map<EntireMenu, Integer> validateMenuInput(String userInput) {
        checkPaired(userInput);
        int menuType = checkSplit(userInput);
        List<String> menuSplit = Arrays.asList(userInput.split(SPLIT_DELIMITER));
        Map<EntireMenu, Integer> userMenu = menuOrderSheet(menuSplit, menuType);
        checkMenuOrderSheet(userMenu);
        return userMenu;
    }

    private void checkPaired(String userInput) {
        if (!userInput.contains(PAIR_DELIMITER)) {
            throw new IllegalArgumentException();
        }
    }

    private int checkSplit(String userInput) {
        int menuType = 1;
        if (userInput.contains(SPLIT_DELIMITER)) {
            long count = userInput.chars().filter(chars -> chars == ',').count();
            menuType += Long.valueOf(count).intValue();
            return menuType;
        }
        return menuType;
    }

    private Map<EntireMenu, Integer> menuOrderSheet(List<String> menuSplit, int menuType) {
        Map<EntireMenu, Integer> menuOrderSheet = new HashMap<>();

        try {
            checkOnlyBeverage(menuSplit);
            for (int index = INDEX_START; index < menuType; index++) {
                List<String> menuPair = List.of(menuSplit.get(index).split(PAIR_DELIMITER));
                EntireMenu menuName = checkMenuName(menuPair.get(MENU_NAME_INDEX));
                Integer menuAmount = checkMenuAmount(
                    Integer.parseInt(menuPair.get(MENU_AMOUNT_INDEX)));
                menuOrderSheet.put(menuName, menuAmount);
            }
            return menuOrderSheet;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMenuOrderSheet(Map<EntireMenu, Integer> menuOrderSheet) {
        int count = 0;
        for (Integer amount : menuOrderSheet.values()) {
            count += amount;
        }
        if (count > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOnlyBeverage(List<String> menuSplit) {
        List<String> menuNameOnly = new ArrayList<>();
        int count = 0;

        for (String string : menuSplit) {
            String[] split = string.split(PAIR_DELIMITER);
            menuNameOnly.add(split[MENU_NAME_INDEX]);
        }
        for (String s : menuNameOnly) {
            if (checkBeverage(s)) {
                count++;
            }
        }
        isOnlyBeverage(count, menuNameOnly);
    }

    private void isOnlyBeverage(int count, List<String> menuNameOnly) {
        if (count == menuNameOnly.size()) {
            System.out.println(ErrorMessage.CAN_NOT_ONLY_BEVERAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private boolean checkBeverage(String menuName) {
        for (EntireMenu menu : EntireMenu.values()) {
            if (menuName.equals(menu.getName()) && menu.getCourse() == Course.BEVERAGE) {
                return true;
            }
        }
        return false;
    }

    private EntireMenu checkMenuName(String menuName) {
        EntireMenu menuNameInMenu;
        for (EntireMenu menu : EntireMenu.values()) {
            if (menu.getName().equals(menuName)) {
                menuNameInMenu = menu;
                return menuNameInMenu;
            }
        }
        throw new IllegalArgumentException();
    }

    private int checkMenuAmount(Integer menuAmount) {
        if (menuAmount < MINIMUM_AMOUNT || 20 < MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException();
        }
        return menuAmount;
    }
}
