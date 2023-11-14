package christmas.christmasEventTest.discountTest;

import christmas.domain.christmasEvent.discount.ChristmasDDayDiscount;
import christmas.domain.christmasEvent.discount.Discount;
import christmas.domain.date.December;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DiscountTest {
    
    @DisplayName("1~25일 사이이면 크리스마스 디데이 할인 클래스를 리턴한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 22, 25})
    public void checkChristmasDDayDiscountTest(int day) {
        Discount discount = new Discount();
        December date = new December(day);
        
        Discount christmasDDayDiscount = discount.checkChristmasDDayDiscount(date);
    
        Assertions.assertThat(christmasDDayDiscount).isInstanceOf(ChristmasDDayDiscount.class);
    }
    
    @DisplayName("1~25일 사이가 아니면 null을 리턴한다.")
    @ParameterizedTest
    @ValueSource(ints = {26, 28, 29, 31})
    public void checkNotChristmasDDayDiscountTest(int day) {
        Discount discount = new Discount();
        December date = new December(day);
        
        Discount christmasDDayDiscount = discount.checkChristmasDDayDiscount(date);
        
        Assertions.assertThat(christmasDDayDiscount).isEqualTo(null);
    }
}
