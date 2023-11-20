package christmas.view;

import static christmas.message.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;

public class InputView {
    
    private final InputValidator inputValidator = new InputValidator();
    
    public String inputDateOfVisit() {
        System.out.println(DATE_OF_VISIT.getMessage());
        String day = Console.readLine();
        validateDay(day);
        return day;
    }
    
    private void validateDay(String day) {
        inputValidator.checkNumeric(day);
        inputValidator.checkDateCondition(day);
    }
    
    public String inputOrderMenu() {
        System.out.println(ORDER_MENU.getMessage());
        return Console.readLine();
    }
}
