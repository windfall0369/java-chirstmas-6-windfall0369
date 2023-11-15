package christmas.domain.event.view;

import christmas.domain.event.domain.Badge;

public class EventOutputView {

    private static final String START_FORMAT = "<";
    private static final String END_FORMAT = ">";
    private static final String EVENT_MENU_MESSAGE = "증정 메뉴";
    private static final String EVENT_MENU = "샴페인 1병";
    private static final String NO_EVENT_MENU = "없음";
    private static final String NEXT_LINE_MARK = "\n";
    private static final String EVENT_BADGE = "12월 이벤트 배지";

    public void printEventMenuMessage() {
        System.out.println(START_FORMAT + EVENT_MENU_MESSAGE + END_FORMAT);
        System.out.println(EVENT_MENU);
        System.out.print(NEXT_LINE_MARK);
    }

    public void printNoEventMenuMessage() {
        System.out.println(START_FORMAT + EVENT_MENU_MESSAGE + END_FORMAT);
        System.out.println(NO_EVENT_MENU);
        System.out.print(NEXT_LINE_MARK);
    }

    public void printEventBadge(Badge eventBadge) {
        System.out.println(NEXT_LINE_MARK);
        System.out.println(START_FORMAT + EVENT_BADGE + END_FORMAT);
        System.out.println(eventBadge.getBadgeName());
    }
}
