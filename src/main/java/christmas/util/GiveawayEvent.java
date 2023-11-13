package christmas.util;

public enum GiveawayEvent {
    CHAMPAGNE("샴페인", 120000, 1, 31);
    
    private final String item;
    private final int condition;
    private final int startDate;
    private final int endDate;
    
    GiveawayEvent(String item, int condition, int startDate, int endDate) {
        this.item = item;
        this.condition = condition;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String getItem() {
        return item;
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
