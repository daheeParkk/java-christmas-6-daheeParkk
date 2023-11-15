package christmas.message;

import java.text.DecimalFormat;

public enum OutputMessage {
    GREETINGS("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    BENEFITS_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_HEADER("<주문 메뉴>"),
    ORDER_MENU("%s %d개"),
    TOTAL_ORDER_AMOUNT_HEADER("<할인 전 총주문 금액>"),
    TOTAL_ORDER_AMOUNT("%s원"),
    GIVEAWAY_MENU_HEADER("<증정 메뉴>"),
    GIVEAWAY_MENU("%s %d개"),
    BENEFITS_HEADER("<혜택 내역>"),
    BENEFITS("%s -%s원"),
    TOTAL_BENEFIT_AMOUNT_HEADER("<총혜택 금액>"),
    TOTAL_BENEFIT_AMOUNT("%s원"),
    AMOUNT_OF_PAYMENT_HEADER("<할인 후 예상 결제 금액>"),
    AMOUNT_OF_PAYMENT("%s원"),
    BADGE_HEADER("<12월 이벤트 배지>");
    
    private final String message;
    
    OutputMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getMessageWithCount(String name, int count) {
        return String.format(message, name, count);
    }
    
    public String getMessageWithAmount(String name, int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return String.format(message, name, df.format(amount));
    }
    
    public String getMessage(int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return String.format(message, df.format(amount));
    }
    
    public String getMessageByDay(int day) {
        return String.format(message, day);
    }
}
