package christmas.domain.reservation.view.inputView;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.util.message.ErrorMessage;

public class ReservationInputView {

    public int getUserVisitDate() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validateUserVisitDate(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_DATE.getErrorMessage());
            }
        }
    }

    private int validateUserVisitDate(String userInput) {
        int userVisitDate = isNumber(userInput);
        if (isNumberInRange(userVisitDate)) {
            return userVisitDate;
        }
        throw new IllegalArgumentException();
    }

    private int isNumber(String userInput) {
        int userVisitDate;
        try {
            userVisitDate = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return userVisitDate;
    }

    private boolean isNumberInRange(int userVisitDay) {
        if (userVisitDay < 1 || userVisitDay > 31) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
