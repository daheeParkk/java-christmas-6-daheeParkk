package christmas.domain.christmasEvent.badge;

import static christmas.util.BadgeType.TREE;

public class TreeBadge extends Badge {
    
    private final String name = TREE.getName();
    
    @Override
    public String getName() {
        return name;
    }}
