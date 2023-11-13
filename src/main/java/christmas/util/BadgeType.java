package christmas.util;

public enum BadgeType {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);
    
    private final String name;
    private final int condition;
    
    BadgeType(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCondition() {
        return condition;
    }
}
