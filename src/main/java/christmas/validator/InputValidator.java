package christmas.validator;

public class InputValidator {
    
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 31;
    
    public void checkNumeric(String day) {
        if (!day.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
    
    public void checkDateCondition(String day) {
        int newDay = Integer.parseInt(day);
        if (newDay < FIRST_DAY || newDay > LAST_DAY) {
            throw new IllegalArgumentException();
        }
    }
}
