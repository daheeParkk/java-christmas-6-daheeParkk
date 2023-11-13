package christmas.domain;

import static christmas.util.BadgeType.*;

public class Badge {
    
    private final String name;
    
    protected Badge(String name) {
        this.name = name;
    }
    
    public static Badge create(int purchaseAmount) {
        if (purchaseAmount >= SANTA.getCondition()) {
            return new SantaBadge();
        }
        if (purchaseAmount >= TREE.getCondition()) {
            return new TreeBadge();
        }
        if (purchaseAmount >= STAR.getCondition()) {
            return new StarBadge();
        }
        return null;
    }
    
    public String getName() {
        return name;
    }
}
