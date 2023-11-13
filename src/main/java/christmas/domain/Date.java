package christmas.domain;

import java.util.List;

public abstract class Date {
    
    protected final int day;
    
    protected List<Integer> weekend;
    
    protected Date(int day) {
        this.day = day;
    }
}
