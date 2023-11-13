package christmas;

import christmas.domain.December;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DecemberTest {
    
    @DisplayName("날짜가 일요일이면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 31})
    public void isSundayTest(int day) {
        December date = new December(day);
        
        Assertions.assertTrue(date.isSunday());
    }
}
