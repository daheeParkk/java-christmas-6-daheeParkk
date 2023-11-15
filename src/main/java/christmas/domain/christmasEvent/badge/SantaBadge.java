package christmas.domain.christmasEvent.badge;

import static christmas.util.BadgeType.*;

public class SantaBadge extends Badge {
    
    private final String name = SANTA.getName();
    
    @Override
    public String getName() {
        return name;
    }
}
