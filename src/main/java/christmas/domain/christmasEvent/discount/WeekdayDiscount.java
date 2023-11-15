package christmas.domain.christmasEvent.discount;

import static christmas.util.DiscountType.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.util.DiscountType.WEEKDAY_DISCOUNT;

import christmas.domain.Order;

public class WeekdayDiscount extends Discount {

    protected static final String DISCOUNT_MENU_TYPE = "디저트";
    private static final int DISCOUNT_AMOUNT = 2023;
    
    private final String name = WEEKDAY_DISCOUNT.getName();
    private final Order order;
    
    public WeekdayDiscount(Order order) {
        this.order = order;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int calculateDiscountAmount() {
        int menuCount = order.countMenuType(DISCOUNT_MENU_TYPE);
        return DISCOUNT_AMOUNT * menuCount;
    }
}
