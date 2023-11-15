package christmas.christmasEventTest.discountTest;

import christmas.domain.Order;
import christmas.domain.christmasEvent.discount.ChristmasDDayDiscount;
import christmas.domain.christmasEvent.discount.Discount;
import christmas.domain.date.December;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasDDayDiscountTest {
    
    private static final String ORDER_MORE_THAN_MINIMUM_AMOUNT = "티본스테이크-1";
    
    @DisplayName("1~25일 사이이면 크리스마스 디데이 할인 클래스가 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 22, 25})
    public void checkChristmasDDayDiscountTest(int day) {
        Discount discount = new Discount();
        December date = new December(day);
        Order order = new Order(ORDER_MORE_THAN_MINIMUM_AMOUNT);
        
        Discount christmasDDayDiscount = discount.checkChristmasDDayDiscount(date, order);
    
        Assertions.assertThat(christmasDDayDiscount).isInstanceOf(ChristmasDDayDiscount.class);
    }
    
    @DisplayName("1~25일 사이가 아니면 할인 이름이 '없음'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {26, 28, 29, 31})
    public void checkNotChristmasDDayDiscountTest(int day) {
        Discount discount = new Discount();
        December date = new December(day);
        Order order = new Order(ORDER_MORE_THAN_MINIMUM_AMOUNT);
        
        Discount christmasDDayDiscount = discount.checkChristmasDDayDiscount(date, order);
        
        Assertions.assertThat(christmasDDayDiscount.getName()).isEqualTo("없음");
    }
    
    @DisplayName("1~25일 사이일 때 날짜에 맞는 크리스마스 디데이 할인 가격이 반환된다.")
    @ParameterizedTest
    @CsvSource(value = {"1-1000", "10-1900", "22-3100", "25-3400"}, delimiter = '-')
    public void calculateDiscountAmountTest(int day, int discountAmount) {
        Discount discount = new Discount();
        December date = new December(day);
        Order order = new Order(ORDER_MORE_THAN_MINIMUM_AMOUNT);
        
        Discount christmasDDayDiscount = discount.checkChristmasDDayDiscount(date, order);
        
        Assertions.assertThat(christmasDDayDiscount.calculateDiscountAmount()).isEqualTo(discountAmount);
    }
}
