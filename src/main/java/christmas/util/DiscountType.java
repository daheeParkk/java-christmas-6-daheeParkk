package christmas.util;

public enum BenefitType {
    CHRISTMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인", 100),
    WEEKDAY_DISCOUNT("평일 할인", 2023),
    WEEKEND_DISCOUNT("주말 할인", 2023),
    SPECIAL_DISCOUNT("특별 할인", 1000),
    GIVEAWAY_EVENT("증정 이벤트", );
    
    private final int discountAmount;
}
