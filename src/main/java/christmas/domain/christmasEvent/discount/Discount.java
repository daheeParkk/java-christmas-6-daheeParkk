package christmas.domain.christmasEvent.discount;

import static christmas.util.DiscountType.*;

import christmas.domain.Order;
import christmas.domain.date.December;
import christmas.util.DiscountType;

public class Discount {
    
    private final String name = "없음";
    
    public Discount checkChristmasDDayDiscount(December date) {
        if (isConditionChristmasDDayDiscount(date)) {
            return new ChristmasDDayDiscount(date.getDay());
        }
        return new Discount();
    }
    
    private boolean isConditionChristmasDDayDiscount(December date) {
        if (isDiscountDate(date.getDay(), CHRISTMAS_D_DAY_DISCOUNT)) {
            return true;
        }
        return false;
    }
    
    public Discount checkWeekdayDiscount(December date, Order order) {
        if(isConditionWeekdayDiscount(date,order)) {
            return new WeekdayDiscount(order);
        }
        return new Discount();
    }
    
    private boolean isConditionWeekdayDiscount(December date, Order order) {
        if (isDiscountDate(date.getDay(), WEEKDAY_DISCOUNT) && date.isWeekday()) {
            return order.hasMenuType(WeekdayDiscount.DISCOUNT_MENU_TYPE);
        }
        return false;
    }
    
    public int calculateDiscountAmount() {
        return 0;
    }
    
    public String getName() {
        return name;
    }
    
    private boolean isDiscountDate(int day, DiscountType discount) {
        return day >= discount.getStartDate() && day <= discount.getEndDate();
    }
}
