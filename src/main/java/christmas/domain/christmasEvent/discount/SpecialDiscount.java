package christmas.domain.christmasEvent.discount;

import static christmas.util.DiscountType.SPECIAL_DISCOUNT;

import java.util.ArrayList;
import java.util.List;

public class SpecialDiscount extends Discount {
    
    protected static final List<Integer> SPECIAL_DAYS = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
    
    private final String name = SPECIAL_DISCOUNT.getName();
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int calculateDiscountAmount() {
        return SPECIAL_DISCOUNT.getAmount();
    }
}
