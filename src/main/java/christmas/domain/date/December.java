package christmas.domain.date;

import christmas.domain.date.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class December extends Date {
    
    private static final int CHRISTMAS = 25;
    private static final String DELIMITER = ",";
    private static final String WEEKEND = "1,2,8,9,15,16,22,23,29,30";
    private static final String SUNDAY = "3,10,17,24,31";
    
    private final List<Integer> sunday;
    
    public December(int day) {
        super(day);
        weekend = new ArrayList<>(dateSetting(WEEKEND));
        sunday = new ArrayList<>(dateSetting(SUNDAY));
    }
    
    private List<Integer> dateSetting(String days) {
        return Arrays.stream(days.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
    
    public boolean isSunday() {
        return sunday.contains(day);
    }
    
    public boolean isChristmas() {
        return day == CHRISTMAS;
    }
}
