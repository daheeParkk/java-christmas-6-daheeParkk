package christmas.domain.christmasEvent.badge;

import static christmas.util.BadgeType.STAR;

public class StarBadge extends Badge {
    
    private final String name = STAR.getName();
    
    @Override
    public String getName() {
        return name;
    }
}
