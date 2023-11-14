package christmas.domain.christmasEvent.discount;

import christmas.domain.date.December;

public class Discount {
    
    public Discount checkChristmasDDayDiscount(December date) {
        int day = date.getDay();
        
        if (day >= ChristmasDDayDiscount.START_DATE && day <= ChristmasDDayDiscount.END_DATE) {
            return new ChristmasDDayDiscount(day);
        }
        return null;
    }
}
