package christmas.domain.menu.view.inputView;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.menu.model.Course;
import christmas.domain.menu.model.EntireMenu;
import christmas.domain.util.message.ErrorMessage;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuInputView {

    private static final String PAIR_DELIMITER = "-";
    private static final String SPLIT_DELIMITER = ",";
    private static final int MENU_NAME_INDEX = 0;
    private static final int MENU_AMOUNT_INDEX = 1;
    private static final int INDEX_START = 0;

    public Map<String, Integer> getUserMenu() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validateMenuInput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_ORDER.getErrorMessage());
            }
        }
    }

    private Map<String, Integer> validateMenuInput(String userInput) {
        checkPaired(userInput);
        int menuType = checkSplit(userInput);
        Map<String, Integer> userMenu = menuOrderSheet(userInput, menuType);
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

    private Map<String, Integer> menuOrderSheet(String userInput, int menuType) {
        Map<String, Integer> menuOrderSheet = new LinkedHashMap<>();
        List<String> menuSplit = checkOnlyBeverage(Arrays.asList(userInput.split(SPLIT_DELIMITER)));

        try {
            for (int index = INDEX_START; index < menuType; index++) {
                List<String> menuPair = Arrays.asList(menuSplit.get(index).split(PAIR_DELIMITER));
                String menuName = isMenuName(menuPair.get(MENU_NAME_INDEX));
                Integer menuAmount = checkMenuAmount(
                    Integer.valueOf(menuPair.get(MENU_AMOUNT_INDEX)));
                menuOrderSheet.put(menuName, menuAmount);
            }
            return menuOrderSheet;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMenuOrderSheet(Map<String, Integer> menuOrderSheet) {
        int count = 0;
        for (Integer amount : menuOrderSheet.values()) {
            count += amount;
        }
        if (count > 20) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> checkOnlyBeverage(List<String> menuSplit) {
        try {
            if (menuSplit.size() == 2) {
                checkBeverage(menuSplit);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.CAN_NOT_ONLY_BEVERAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }

        return menuSplit;
    }

    private void checkBeverage(List<String> menuSplit) {
        for (EntireMenu menu : EntireMenu.values()) {
            if (menuSplit.get(0).equals(menu.getName()) && menu.getCourse() == Course.BEVERAGE) {
                throw new IllegalArgumentException();
            }
        }
    }


    private String isMenuName(String menuName) {
        if (checkMenuName(menuName)) {
            return menuName;
        }
        throw new IllegalArgumentException();
    }

    private boolean checkMenuName(String menuName) {
        for (EntireMenu menu : EntireMenu.values()) {
            if (menu.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    private int checkMenuAmount(Integer menuAmount) {
        if (menuAmount < 1 || 20 < menuAmount) {
            throw new IllegalArgumentException();
        }
        return menuAmount;
    }
}
