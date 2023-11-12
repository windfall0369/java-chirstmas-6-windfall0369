package christmas.domain.menu.view.inputView;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.util.message.ErrorMessage;
import java.util.Map;

public class MenuInputView {

    private static final String PAIR_DELIMITER = "-";
    private static final String SPLIT_DELIMITER = ",";

    public Map<String, Integer> getUserMenu() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validateMenuInput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_MENU.getErrorMessage());
            }
        }
    }

    private Map<String, Integer> validateMenuInput(String userInput) {
        try {
            checkPair(userInput);
            checkSplit(userInput);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    private void checkPair(String userInput) {
        if (!userInput.contains(PAIR_DELIMITER)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSplit(String userInput) {

    }


    private boolean checkExistingMenu(String userInput) {

    }

}
