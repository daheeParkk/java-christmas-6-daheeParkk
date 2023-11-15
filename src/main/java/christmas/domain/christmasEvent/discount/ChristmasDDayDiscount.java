package christmas.domain.christmasEvent.discount;

import static christmas.util.DiscountType.*;

public class ChristmasDDayDiscount extends Discount {

    private static final int BASIC_DISCOUNT_AMOUNT = 1000;
    private final String name = CHRISTMAS_D_DAY_DISCOUNT.getName();
    private final int day;
    
    public ChristmasDDayDiscount(int day) {
        this.day = day;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int calculateDiscountAmount() {
        int increasingAmount = CHRISTMAS_D_DAY_DISCOUNT.getAmount();
        return BASIC_DISCOUNT_AMOUNT + (day - 1) * increasingAmount;
    }
}
