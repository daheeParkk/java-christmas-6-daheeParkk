package christmas.service;

import christmas.domain.Customer;
import java.util.Map;

public class ReservationService {
    
    private Customer customer;
    
    public void reserve(int day, String menu) {
        customer = new Customer(day, menu);
    }
    
    public Map<String, Integer> checkOrderInformation() {
        return customer.getOrderMenu();
    }
    
    public int checkTotalOrderAmount() {
        return customer.getTotalOrderAmount();
    }
    
    public Map<String, Integer> checkGiveawayMenu() {
        return customer.getGiveaway();
    }
    
    public Map<String, Integer> checkDiscount() {
        return customer.getAvailableDiscounts();
    }
    
    public int checkTotalDiscountAmount() {
        return customer.getBenefitAmount();
    }
    
    public int checkAmountOfPayment() {
        return customer.getAmountOfPayment();
    }
    
    public String checkBadge() {
        return customer.getBadge();
    }
}
