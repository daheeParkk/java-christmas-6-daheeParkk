package christmas.domain;

import christmas.util.Menu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private final static String ORDER_DELIMITER = ",";
    private final static String ORDER_NUMBER_DELIMITER = "-";
    private final Map<Menu,Integer> menu = new HashMap<>();
    
    public Order(String order) {
        separateMenu(order);
    }
    
    private void separateMenu(String order) {
        String[] orders = order.split(ORDER_DELIMITER);
        
        for (String oneOrder : orders) {
            String[] menuAndNumber = oneOrder.split(ORDER_NUMBER_DELIMITER);
            String menuName = menuAndNumber[0];
            int menuNumber = Integer.parseInt(menuAndNumber[1]);
            Menu menu1 = Menu.getMenuOf(menuName);
            menu.put(menu1, menuNumber);
        }
    }
    
    public int countMenuType(String menuType) {
        int count = 0;
        
        for (Menu oneMenu : menu.keySet()) {
            if (oneMenu.getType().equals(menuType)) {
                count += menu.get(oneMenu);
            }
        }
        
        return count;
    }
}
