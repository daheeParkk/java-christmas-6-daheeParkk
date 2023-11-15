package christmas.domain.christmasEvent.giveaway;

import static christmas.util.GiveawayEvent.*;

public class ChampagneGiveaway extends Giveaway {
    
    private static final int NUMBER_OF_GIVEAWAY = 1;
    
    private final int discountAmount = CHAMPAGNE.getDiscountAmount();
    private final String name = CHAMPAGNE.getItem();
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getNumberOfGiveaway() {
        return NUMBER_OF_GIVEAWAY;
    }
    
    @Override
    public int getDiscountAmount() {
        return discountAmount;
    }
}
