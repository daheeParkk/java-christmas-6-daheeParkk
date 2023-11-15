package christmas.domain.christmasEvent.giveaway;

import static christmas.util.GiveawayEvent.*;

import christmas.domain.Order;
import christmas.domain.date.December;
import christmas.util.GiveawayEvent;

public class Giveaway {
    
    private final String name = "없음";
    private final int count = 0;
    
    public Giveaway checkChampagneGiveaway(December date, Order order) {
        if (isGiveawayDate(date.getDay(), CHAMPAGNE) && isConditionChampagneGiveaway(order)) {
            return new ChampagneGiveaway();
        }
        return new Giveaway();
    }
    
    private boolean isConditionChampagneGiveaway(Order order) {
        return order.calculatePurchaseAmount() >= CHAMPAGNE.getCondition();
    }
    
    private boolean isGiveawayDate(int day, GiveawayEvent giveawayEvent) {
        return day >= giveawayEvent.getStartDate() && day <= giveawayEvent.getEndDate();
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumberOfGiveaway() {
        return count;
    }
}
