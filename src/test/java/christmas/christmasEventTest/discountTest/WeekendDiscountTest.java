package christmas.christmasEventTest.discountTest;

import christmas.domain.Order;
import christmas.domain.christmasEvent.discount.Discount;
import christmas.domain.date.December;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekendDiscountTest {
    
    private static final String DESSERT_ORDER = "초코케이크-1,아이스크림-2";
    private static final String MAIN_MENU_ORDER = "티본스테이크-1,크리스마스파스타-2";
    
    @DisplayName("날짜가 주말이 아니면 할인 이름이 '없음'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 11, 19, 25, 28, 31})
    public void isNotDateConditionWeekendDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
        
        Discount weekendDiscount = discount.checkWeekendDiscount(date, new Order(MAIN_MENU_ORDER));
        
        Assertions.assertThat(weekendDiscount.getName()).isEqualTo("없음");
    }
    
    @DisplayName("날짜가 주말이면 할인 이름이 '주말 할인'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 15, 23, 29})
    public void isDateConditionWeekendDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
    
        Discount weekendDiscount = discount.checkWeekendDiscount(date, new Order(MAIN_MENU_ORDER));
    
        Assertions.assertThat(weekendDiscount.getName()).isEqualTo("주말 할인");
    }
    
    @DisplayName("날짜가 주말일 때 메인 메뉴가 없으면 할인 이름이 '없음'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 15, 23, 29})
    public void isNotOrderConditionWeekendDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
    
        Discount weekendDiscount = discount.checkWeekendDiscount(date, new Order(DESSERT_ORDER));
    
        Assertions.assertThat(weekendDiscount.getName()).isEqualTo("없음");
    }
    
    @DisplayName("날짜가 주말일 때 메인 메뉴가 있으면 할인 이름이 '주말 할인'이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 15, 23, 29})
    public void isOrderConditionWeekendDiscountTest(int day) {
        December date = new December(day);
        Discount discount = new Discount();
    
        Discount weekendDiscount = discount.checkWeekendDiscount(date, new Order(MAIN_MENU_ORDER));
    
        Assertions.assertThat(weekendDiscount.getName()).isEqualTo("주말 할인");
    }
    
    @DisplayName("주말 할인이 될 때 메인 메뉴를 메뉴 1개당 2,023원을 할인하도록 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"아이스크림-2,티본스테이크-1=2023", "바비큐립-1,크리스마스파스타-2=6069"}, delimiter = '=')
    public void calculateDiscountAmountTest(String menu, int result) {
        December date = new December(1);
        Discount discount = new Discount();
        
        Discount weekendDiscount = discount.checkWeekendDiscount(date, new Order(menu));
        int discountAmount = weekendDiscount.calculateDiscountAmount();
        
        Assertions.assertThat(discountAmount).isEqualTo(result);
    }
}
