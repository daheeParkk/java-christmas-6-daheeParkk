package christmas.domain;

import christmas.util.Menu;
import java.util.HashMap;
import java.util.Map;

public class Order {
    
    private final static String ORDER_DELIMITER = ",";
    private final static String ORDER_NUMBER_DELIMITER = "-";
    private final Map<Menu, Integer> menu = new HashMap<>();
    
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
    
    public int calculatePurchaseAmount() {
        int purchaseAmount = 0;
        
        for (Menu oneMenu : menu.keySet()) {
            purchaseAmount += oneMenu.getPrice() * menu.get(oneMenu);
        }
        return purchaseAmount;
    }
    
    public boolean hasMenuType(String menuType) {
        for (Menu oneMenu : menu.keySet()) {
            if (oneMenu.getType().equals(menuType)) {
                return true;
            }
        }
        return false;
    }
    
    public Map<String, Integer> getOrderMenu() {
        Map<String, Integer> orderMenu = new HashMap<>();
        for (Menu oneMenu : menu.keySet()) {
            orderMenu.put(oneMenu.getName(), menu.get(oneMenu));
        }
        return orderMenu;
    }
}
