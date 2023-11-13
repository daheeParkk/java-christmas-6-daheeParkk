package christmas;

import christmas.domain.Badge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {
    
    @DisplayName("금액이 5,000원 아래면 null이 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 4000, 4999})
    public void createNullBadgeTest(int purchaseAmount) {
        Badge badge = Badge.create(purchaseAmount);
    
        Assertions.assertThat(badge).isEqualTo(null);
    }
}
