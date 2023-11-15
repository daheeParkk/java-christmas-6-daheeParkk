package christmas.domain.christmasEvent.discount;

import static christmas.util.DiscountType.WEEKEND_DISCOUNT;

import christmas.domain.Order;

public class WeekendDiscount extends Discount {
    
    protected static final String DISCOUNT_MENU_TYPE = "메인";
    private static final int DISCOUNT_AMOUNT = 2023;
    
    private final String name = WEEKEND_DISCOUNT.getName();
    private final Order order;
    
    public WeekendDiscount(Order order) {
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
