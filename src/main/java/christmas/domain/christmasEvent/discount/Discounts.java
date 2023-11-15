package christmas.domain.christmasEvent.discount;

import static christmas.util.DiscountType.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.util.DiscountType.SPECIAL_DISCOUNT;
import static christmas.util.DiscountType.WEEKDAY_DISCOUNT;
import static christmas.util.DiscountType.WEEKEND_DISCOUNT;

import christmas.domain.Order;
import christmas.domain.date.December;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discounts {
    
    private final List<Discount> discounts = new ArrayList<>();
    
    public Discounts(December date, Order order) {
        checkAvailableDiscounts(date, order);
    }
    
    private void checkAvailableDiscounts(December date, Order order) {
        Discount discount = new Discount();
        checkChristmasDDayDiscount(discount, date, order);
        checkWeekdayDiscount(discount, date, order);
        checkWeekendDiscount(discount, date, order);
        checkSpecialDiscount(discount, date, order);
    }
    
    private void checkSpecialDiscount(Discount discount, December date, Order order) {
        Discount specialDiscount = discount.checkSpecialDiscount(date, order);
    
        if (specialDiscount.getName().equals(SPECIAL_DISCOUNT.getName())) {
            discounts.add(specialDiscount);
        }
    }
    
    private void checkWeekendDiscount(Discount discount, December date, Order order) {
        Discount weekendDiscount = discount.checkWeekendDiscount(date, order);
    
        if (weekendDiscount.getName().equals(WEEKEND_DISCOUNT.getName())) {
            discounts.add(weekendDiscount);
        }
    }
    
    private void checkWeekdayDiscount(Discount discount, December date, Order order) {
        Discount weekdayDiscount = discount.checkWeekdayDiscount(date, order);
        
        if (weekdayDiscount.getName().equals(WEEKDAY_DISCOUNT.getName())) {
            discounts.add(weekdayDiscount);
        }
    }
    
    private void checkChristmasDDayDiscount(Discount discount, December date, Order order) {
        Discount christmasDDayDiscount = discount.checkChristmasDDayDiscount(date, order);
        
        if (christmasDDayDiscount.getName().equals(CHRISTMAS_D_DAY_DISCOUNT.getName())) {
            discounts.add(christmasDDayDiscount);
        }
    }
    
    public Map<String, Integer> getAvailableDiscounts() {
        Map<String, Integer> availableDiscounts = new HashMap<>();
        
        for (Discount discount : discounts) {
            availableDiscounts.put(discount.getName(), discount.calculateDiscountAmount());
        }
        return availableDiscounts;
    }
    
    public int calculateDiscountAmount() {
        int discountAmount = 0;
        for (Discount discount : discounts) {
            discountAmount += discount.calculateDiscountAmount();
        }
        return discountAmount;
    }
}
