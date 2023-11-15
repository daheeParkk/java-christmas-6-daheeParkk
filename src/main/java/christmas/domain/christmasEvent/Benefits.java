package christmas.domain.christmasEvent;

import christmas.domain.Order;
import christmas.domain.christmasEvent.badge.Badge;
import christmas.domain.christmasEvent.discount.Discounts;
import christmas.domain.christmasEvent.giveaway.Giveaway;
import christmas.domain.date.December;
import java.util.HashMap;
import java.util.Map;

public class Benefits {
    
    private final Discounts discounts;
    private final Giveaway giveaway;
    
    private  Badge badge;
    
    public Benefits(December date, Order order) {
        giveaway = new Giveaway().checkChampagneGiveaway(date, order);
        discounts = new Discounts(date, order);
    }
    
    public Map<String, Integer> getAvailableDiscounts() {
        Map<String, Integer> availableDiscount = discounts.getAvailableDiscounts();
        availableDiscount.put(giveaway.getName(), giveaway.getDiscountAmount());
        return availableDiscount;
    }
    
    public int calculateTotalDiscountAmount() {
        return discounts.calculateDiscountAmount() + giveaway.getDiscountAmount();
    }
    
    public int calculateDiscountAmount() {
        return discounts.calculateDiscountAmount();
    }
    
    public Map<String, Integer> getGiveaway() {
        Map<String,Integer> champagneGiveaway = new HashMap<>();
        champagneGiveaway.put(giveaway.getName(), giveaway.getNumberOfGiveaway());
        return champagneGiveaway;
    }
    
    public String getBadge() {
        badge = Badge.create(calculateTotalDiscountAmount());
        return badge.getName();
    }
}
