package christmas.christmasEventTest.discountTest;

import christmas.domain.Order;
import christmas.domain.christmasEvent.discount.Discount;
import christmas.domain.date.December;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpecialDiscountTest {
    
    private static final String ORDER_MORE_THAN_MINIMUM_AMOUNT = "티본스테이크-1";
    
    @DisplayName("이벤트 달력에 별이 있는 날이면 할인 이름이 '특별 할인'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    public void checkSpecialDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
        Order order = new Order(ORDER_MORE_THAN_MINIMUM_AMOUNT);
        
        Discount specialDiscount = discount.checkSpecialDiscount(date, order);
    
        Assertions.assertThat(specialDiscount.getName()).isEqualTo("특별 할인");
    }
    
    @DisplayName("이벤트 달력에 별이 있는 날이 아니면 할인 이름이 '없음'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {1,6,13,20,23,27})
    public void checkNotSpecialDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
        Order order = new Order(ORDER_MORE_THAN_MINIMUM_AMOUNT);
        
        Discount specialDiscount = discount.checkSpecialDiscount(date, order);
        
        Assertions.assertThat(specialDiscount.getName()).isEqualTo("없음");
    }
    
    @DisplayName("이벤트 달력에 별이 있는 날일 때 할인 금액은 1000원이 된다.")
    @Test
    public void calculateDiscountAmountTest() {
        December date = new December(25);
        Discount discount = new Discount();
        Order order = new Order(ORDER_MORE_THAN_MINIMUM_AMOUNT);
        Discount specialDiscount = discount.checkSpecialDiscount(date, order);
        
        int discountAmount = specialDiscount.calculateDiscountAmount();
        
        Assertions.assertThat(discountAmount).isEqualTo(1000);
    }
}
