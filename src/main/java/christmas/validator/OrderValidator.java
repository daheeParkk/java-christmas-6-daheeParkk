package christmas.validator;

import christmas.util.Menu;
import java.util.HashMap;
import java.util.Map;

public class OrderValidator {
    
    private final static String ORDER_NUMBER_DELIMITER = "-";
    
    public void checkDuplicate(String[] orders) {
        int size = orders.length;
        Map<Menu, Integer> menu = new HashMap<>();
        
        for (String oneOrder : orders) {
            String[] menuAndNumber = oneOrder.split(ORDER_NUMBER_DELIMITER);
            String menuName = menuAndNumber[0];
            menu.put(Menu.getMenuOf(menuName), Integer.parseInt(menuAndNumber[1]));
        }
    
        if (menu.size() != size) {
            throw new IllegalArgumentException();
        }
    }
}
