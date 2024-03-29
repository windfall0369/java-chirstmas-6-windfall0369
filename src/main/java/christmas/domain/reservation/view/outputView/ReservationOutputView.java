package christmas.domain.reservation.view.outputView;

public class ReservationOutputView {

    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public void printRequestVisitDate() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(VISIT_DATE_MESSAGE);
    }
}
