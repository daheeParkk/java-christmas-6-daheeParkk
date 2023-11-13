package christmas.domain;

import static christmas.util.BadgeType.*;

public class Badge {
    
    private Badge() {
    }
    
    public Badge createBadge(int purchaseAmount) {
        if (purchaseAmount >= SANTA.getCondition()) {
            return new SANTA();
        }
        if (purchaseAmount >= TREE.getCondition()) {
            return new TREE();
        }
        if (purchaseAmount >= STAR.getCondition()) {
            return new STAR();
        }
        return null;
    }
}
