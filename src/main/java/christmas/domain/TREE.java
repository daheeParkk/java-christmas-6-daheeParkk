package christmas.domain;

import christmas.util.BadgeType;

public class TREE extends Badge {
    
    private final String name;
    
    public TREE() {
        name = BadgeType.TREE.getName();
    }
    
    public String getName() {
        return name;
    }
}
