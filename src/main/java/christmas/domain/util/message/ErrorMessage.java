package christmas.domain.util.message;

public enum ErrorMessage {

    PREFIX("[ERROR] "),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    CAN_NOT_ONLY_BEVERAGE("음료만 주문 시, 주문할 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return PREFIX.message + message;
    }
}
