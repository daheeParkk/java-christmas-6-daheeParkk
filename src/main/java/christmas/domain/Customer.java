package christmas.domain;

import christmas.domain.christmasEvent.Benefits;
import christmas.domain.date.December;
import java.util.Map;

public class Customer {
    
    private final December date;
    private final Order order;
    private final Benefits benefits;
    
    public Customer(int day, String order) {
        this.date = new December(day);
        this.order = new Order(order);
        benefits = new Benefits(this.date, this.order);
    }
    
    public Map<String, Integer> getAvailableDiscounts() {
        return benefits.getAvailableDiscounts();
    }
    
    public int getTotalOrderAmount() {
        return order.calculatePurchaseAmount();
    }
    
    public Map<String, Integer> getOrderMenu() {
        return order.getOrderMenu();
    }
    
    public Map<String, Integer> getGiveaway() {
        return benefits.getGiveaway();
    }
    
    public int getBenefitAmount() {
        return benefits.calculateDiscountAmount();
    }
    
    public int getAmountOfPayment() {
        return getTotalOrderAmount() - getBenefitAmount();
    }
    
    public String getBadge() {
        return benefits.getBadge();
    }
}
