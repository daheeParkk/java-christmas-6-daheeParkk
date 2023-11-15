package christmas.view;

import static christmas.message.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    
    public String inputDateOfVisit() {
        System.out.println(DATE_OF_VISIT.getMessage());
        return Console.readLine();
    }
    
    public String inputOrderMenu() {
        System.out.println(ORDER_MENU.getMessage());
        return Console.readLine();
    }
}
