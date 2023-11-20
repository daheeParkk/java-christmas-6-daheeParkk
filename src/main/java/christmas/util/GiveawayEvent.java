package christmas.util;

public enum GiveawayEvent {
    CHAMPAGNE("샴페인", 25000,120000, 1, 31);
    
    private final String item;
    private final int discountAmount;
    private final int condition;
    private final int startDate;
    private final int endDate;
    
    GiveawayEvent(String item, int discountAmount, int condition, int startDate, int endDate) {
        this.item = item;
        this.discountAmount = discountAmount;
        this.condition = condition;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String getItem() {
        return item;
    }
    
    public int getDiscountAmount() {
        return discountAmount;
    }
    
    public int getCondition() {
        return condition;
    }
    
    public int getStartDate() {
        return startDate;
    }
    
    public int getEndDate() {
        return endDate;
    }
}
