package christmas.domain.event.view;

public class EventOutputView {

    private static final String START_FORMAT = "<";
    private static final String END_FORMAT = ">";
    private static final String EVENT_MENU_MESSAGE = "증정 메뉴";
    private static final String EVENT_MENU = "샴페인 1병";
    private static final String NO_EVENT_MENU = "없음";

    public void printEventMenuMessage() {
        System.out.println(START_FORMAT + EVENT_MENU_MESSAGE + END_FORMAT);
        System.out.println(EVENT_MENU);
    }

    public void printNoEventMenuMessage() {
        System.out.println(START_FORMAT + EVENT_MENU_MESSAGE + END_FORMAT);
        System.out.println(NO_EVENT_MENU);
    }
}
