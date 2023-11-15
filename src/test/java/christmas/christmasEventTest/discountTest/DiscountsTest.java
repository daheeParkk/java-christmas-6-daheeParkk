package christmas.christmasEventTest.discountTest;

import christmas.domain.Order;
import christmas.domain.christmasEvent.discount.Discounts;
import christmas.domain.date.December;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountsTest {
    
    private static final String DESSERT_ORDER = "초코케이크-1,아이스크림-2";
    
    @DisplayName("25일에 만원 이상 디저트를 시키면 3가지 종류의 할인을 받는 것을 확인할 수 있다.")
    @Test
    public void getAvailableDiscountsTest() {
        December date = new December(25);
        Order order = new Order(DESSERT_ORDER);
        Discounts discounts = new Discounts(date, order);
        
        Map<String,Integer> availableDiscounts = discounts.getAvailableDiscounts();
    
        Assertions.assertThat(availableDiscounts.size()).isEqualTo(3);
    }
    
    @DisplayName("25일에 만원 이상 디저트를 시키고 총 할인 금액을 확인할 수 있다.")
    @Test
    public void calculateDiscountAmountTest() {
        December date = new December(25);
        Order order = new Order(DESSERT_ORDER);
        Discounts discounts = new Discounts(date, order);
        
        int discountAmount = discounts.calculateDiscountAmount();
        
        Assertions.assertThat(discountAmount).isEqualTo(10469);
    }
}
