package christmas;

import christmas.controller.WooTeCoRestaurantController;

public class Application {
    
    private static final WooTeCoRestaurantController wooTeCoRestaurantController = new WooTeCoRestaurantController();
    
    public static void main(String[] args) {
        wooTeCoRestaurantController.operate();
    }
}
