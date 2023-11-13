package christmas.domain;

import christmas.util.BadgeType;

public class SANTA extends Badge {
    
    private final String name;
    
    public SANTA() {
        name = BadgeType.SANTA.getName();
    }
    
    public String getName() {
        return name;
    }
}
