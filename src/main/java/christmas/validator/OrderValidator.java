package christmas.validator;

import christmas.util.Menu;
import java.util.HashMap;
import java.util.Map;

public class OrderValidator {
    
    private final static String ORDER_NUMBER_DELIMITER = "-";
    private int orderCount = 0;
    
    public void checkDuplicate(String[] orders) {
        int size = orders.length;
        Map<Menu, Integer> menu = new HashMap<>();
        
        for (String oneOrder : orders) {
            String[] menuAndNumber = oneOrder.split(ORDER_NUMBER_DELIMITER);
            String menuName = menuAndNumber[0];
            int count = Integer.parseInt(menuAndNumber[1]);
            orderCount += count;
            menu.put(Menu.getMenuOf(menuName), count);
        }
    
        if (menu.size() != size) {
            throw new IllegalArgumentException();
        }
    }
    
    public void checkSize() {
        if (orderCount < 1 || orderCount > 20) {
            throw new IllegalArgumentException();
        }
    }
    
    public void checkMenuType(Map<Menu, Integer> menu) {
        boolean onlyDrinks = true;
        for (Menu oneMenu : menu.keySet()) {
            if (!oneMenu.getType().equals("음료")) {
                onlyDrinks = false;
            }
        }
        if (onlyDrinks) {
            throw new IllegalArgumentException();
        }
    }
}
