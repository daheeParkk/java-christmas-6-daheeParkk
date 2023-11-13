package christmas.util;

public enum DiscountType {
    CHRISTMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인", 100, 1, 25),
    WEEKDAY_DISCOUNT("평일 할인", 2023, 1, 31),
    WEEKEND_DISCOUNT("주말 할인", 2023, 1, 31),
    SPECIAL_DISCOUNT("특별 할인", 1000, 1, 31);
    
    private final String name;
    private final int amount;
    private final int startDate;
    private final int endDate;
    
    DiscountType(String name, int amount, int startDate, int endDate) {
        this.name = name;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int getStartDate() {
        return startDate;
    }
    
    public int getEndDate() {
        return endDate;
    }
}
