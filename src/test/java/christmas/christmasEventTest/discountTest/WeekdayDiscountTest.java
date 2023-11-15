package christmas.christmasEventTest.discountTest;

import christmas.domain.Order;
import christmas.domain.christmasEvent.discount.Discount;
import christmas.domain.date.December;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayDiscountTest {
    
    private static final String DESSERT_ORDER = "초코케이크-1";
    
    @DisplayName("날짜가 평일이 아니면 할인 이름이 '없음'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 15, 23, 29})
    public void isNotConditionWeekdayDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
        
        Discount weekdayDiscount = discount.checkWeekdayDiscount(date, new Order(DESSERT_ORDER));
    
        Assertions.assertThat(weekdayDiscount.getName()).isEqualTo("없음");
    }
    
    @DisplayName("날짜가 평일이면 할인 이름이 '평일 할인'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 11, 19, 25, 28, 31})
    public void isConditionWeekdayDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
        
        Discount weekdayDiscount = discount.checkWeekdayDiscount(date, new Order(DESSERT_ORDER));
        
        Assertions.assertThat(weekdayDiscount.getName()).isEqualTo("평일 할인");
    }
}
