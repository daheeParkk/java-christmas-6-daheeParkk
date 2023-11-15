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
    private final Badge badge;
    
    public Benefits(December date, Order order) {
        giveaway = new Giveaway().checkChampagneGiveaway(date, order);
        discounts = new Discounts(date, order);
        badge = Badge.create(order.calculatePurchaseAmount());
    }
    
    public Map<String, Integer> getAvailableDiscounts() {
        Map<String, Integer> availableDiscount = discounts.getAvailableDiscounts();
        availableDiscount.put(giveaway.getName(), giveaway.getNumberOfGiveaway());
        return availableDiscount;
    }
    
    public int calculateDiscountAmount() {
        return discounts.calculateDiscountAmount() + giveaway.getDiscountAmount();
    }
    
    public Map<String, Integer> getGiveaway() {
        Map<String,Integer> champagneGiveaway = new HashMap<>();
        champagneGiveaway.put(giveaway.getName(), giveaway.getNumberOfGiveaway());
        return champagneGiveaway;
    }
    
    public String getBadge() {
        return badge.getName();
    }
}
