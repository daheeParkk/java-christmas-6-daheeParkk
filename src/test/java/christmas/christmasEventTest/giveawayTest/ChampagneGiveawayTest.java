package christmas.christmasEventTest.giveawayTest;

import christmas.domain.Order;
import christmas.domain.christmasEvent.giveaway.Giveaway;
import christmas.domain.date.December;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChampagneGiveawayTest {
    
    @DisplayName("주문 금액이 12만원 이상이면 증정품 이름이 '샴페인'이 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", "티본스테이크-2,바비큐립-1,크리스마스파스타-2"})
    public void checkChampagneGiveawayTest(String menu) {
        Order order = new Order(menu);
        December date = new December(25);
        Giveaway giveaway = new Giveaway();
        
        Giveaway champagne = giveaway.checkChampagneGiveaway(date, order);
    
        Assertions.assertThat(champagne.getName()).isEqualTo("샴페인");
    }
    
    @DisplayName("주문 금액이 12만원 미만이면 증정품 이름이 '없음'이 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"초코케이크-2,제로콜라-1", "바비큐립-1,크리스마스파스타-1"})
    public void checkNotChampagneGiveawayTest(String menu) {
        Order order = new Order(menu);
        December date = new December(25);
        Giveaway giveaway = new Giveaway();
        
        Giveaway champagne = giveaway.checkChampagneGiveaway(date, order);
        
        Assertions.assertThat(champagne.getName()).isEqualTo("없음");
    }
}
