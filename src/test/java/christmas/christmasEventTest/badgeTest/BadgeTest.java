package christmas.christmasEventTest.badgeTest;

import christmas.domain.christmasEvent.badge.Badge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {
    
    @DisplayName("할인 금액이 5,000원 아래면 '없음'이 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 4000, 4999})
    public void createNullBadgeTest(int discountAmount) {
        Badge badge = Badge.create(discountAmount);
    
        Assertions.assertThat(badge.getName()).isEqualTo("없음");
    }
    
    @DisplayName("할인 금액이 5,000 ~ 9,999원이면 '별'이 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {5000, 6000, 9000, 9999})
    public void createStarBadgeTest(int discountAmount) {
        Badge badge = Badge.create(discountAmount);
        
        Assertions.assertThat(badge.getName()).isEqualTo("별");
    }
    
    @DisplayName("할인 금액이 10,000 ~ 19,999원이면 '트리'가 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {10000, 16000, 19000, 19999})
    public void createTreeBadgeTest(int discountAmount) {
        Badge badge = Badge.create(discountAmount);
        
        Assertions.assertThat(badge.getName()).isEqualTo("트리");
    }
    
    @DisplayName("할인 금액이 20,000원 이상이면 '산타'가 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {20000, 36000, 59000, 79999})
    public void createSantaBadgeTest(int discountAmount) {
        Badge badge = Badge.create(discountAmount);
        
        Assertions.assertThat(badge.getName()).isEqualTo("산타");
    }
}
