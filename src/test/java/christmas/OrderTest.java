package christmas;

import christmas.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OrderTest {
    
    @DisplayName("메뉴 타입인 메인 메뉴를 전달하면 메인 메뉴의 개수를 센다.")
    @ParameterizedTest
    @CsvSource(value = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1=2", "크리스마스파스타-2,바비큐립-3,초코케이크-2=5"}, delimiter = '=')
    public void countMenuTypeTest(String menu, int result) {
        Order order = new Order(menu);
        
        int menuCount = order.countMenuType("메인");
        
        Assertions.assertThat(menuCount).isEqualTo(result);
    }
    
    @DisplayName("주문한 메뉴로 구매 금액을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"타파스-1,제로콜라-1=8500", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1=142000"}, delimiter = '=')
    public void calculatePurchaseAmountTest(String menu, int result) {
        Order order = new Order(menu);
        
        int purchaseAmount = order.calculatePurchaseAmount();
        
        Assertions.assertThat(purchaseAmount).isEqualTo(result);
    }
}
