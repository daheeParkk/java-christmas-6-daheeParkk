package christmas.domain.christmasEvent.giveaway;

import static christmas.util.GiveawayEvent.*;

public class ChampagneGiveaway extends Giveaway {
    
    private static final int NUMBER_OF_GIVEAWAY = 1;
    
    private final String name = CHAMPAGNE.getItem();
    
    @Override
    public String getName() {
        return name;
    }
    
    public int getNumberOfGiveaway() {
        return NUMBER_OF_GIVEAWAY;
    }
}
