package christmas.domain;

import christmas.util.BadgeType;

public class STAR extends Badge {
    
    private final String name;
    
    public STAR() {
        name = BadgeType.STAR.getName();
    }
    
    public String getName() {
        return name;
    }
}
