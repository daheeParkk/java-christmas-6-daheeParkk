package christmas.domain.christmasEvent.badge;

import static christmas.util.BadgeType.*;

public class Badge {
    
    private final String name = "없음";
    
    public static Badge create(int benefitAmount) {
        if (benefitAmount >= SANTA.getCondition()) {
            return new SantaBadge();
        }
        if (benefitAmount >= TREE.getCondition()) {
            return new TreeBadge();
        }
        if (benefitAmount >= STAR.getCondition()) {
            return new StarBadge();
        }
        return new Badge();
    }
    
    public String getName() {
        return name;
    }
}
