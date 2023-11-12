package christmas.domain.menu.view.inputView;

import camp.nextstep.edu.missionutils.Console;
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
        return menuOrderSheet(userInput, menuType);

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
        List<String> menuSplit = Arrays.asList(userInput.split(SPLIT_DELIMITER));

        try {
            for (int i = 0; i < menuType; i++) {
                List<String> menuPair = Arrays.asList(menuSplit.get(i).split(PAIR_DELIMITER));

                String menuName = menuPair.get(MENU_NAME_INDEX);
                Integer menuAmount = Integer.valueOf(menuPair.get(MENU_AMOUNT_INDEX));
                menuOrderSheet.put(menuName, menuAmount);
            }
            return menuOrderSheet;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
