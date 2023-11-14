package christmas.domain.christmasEvent.discount;

import christmas.domain.date.December;

public class Discount {
    
    private final String name = "없음";
    
    public Discount checkChristmasDDayDiscount(December date) {
        int day = date.getDay();
        
        if (day >= ChristmasDDayDiscount.START_DATE && day <= ChristmasDDayDiscount.END_DATE) {
            return new ChristmasDDayDiscount(day);
        }
        return new Discount();
    }
    
    public int calculateDiscountAmount() {
        return 0;
    }
}
