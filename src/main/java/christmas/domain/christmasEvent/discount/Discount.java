package christmas.domain.christmasEvent.discount;

import static christmas.util.DiscountType.CHRISTMAS_D_DAY_DISCOUNT;

import christmas.domain.date.December;

public class Discount {
    
    public Discount checkChristmasDDayDiscount(December date) {
        int day = date.getDay();
        
        if (day >= ChristmasDDayDiscount.START_DATE && day <= ChristmasDDayDiscount.END_DATE) {
            return new ChristmasDDayDiscount(day);
        }
        return null;
    }
    
    public int calculateDiscountAmount() {
        return 0;
    }
}
