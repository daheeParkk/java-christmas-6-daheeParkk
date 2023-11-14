package christmas.domain.christmasEvent.discount;

import christmas.domain.Order;
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
    
    public Discount checkWeekdayDiscount(December date, Order order) {
        int day = date.getDay();
    
        if (day >= WeekdayDiscount.START_DATE && day <= WeekdayDiscount.END_DATE && date.isWeekday()) {
            if (order.hasMenuType(WeekdayDiscount.DISCOUNT_MENU_TYPE)) {
                return new WeekdayDiscount(order);
            }
        }
        return new Discount();
    }
    
    public int calculateDiscountAmount() {
        return 0;
    }
    
    public String getName() {
        return name;
    }
}
