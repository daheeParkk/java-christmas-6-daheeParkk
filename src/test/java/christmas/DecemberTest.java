package christmas;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.December;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DecemberTest {
    
    @DisplayName("날짜가 일요일이면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 31})
    public void isSundayTest(int day) {
        December date = new December(day);
        
        Assertions.assertTrue(date.isSunday());
    }
    
    @DisplayName("날짜가 일요일이 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 18, 25, 30})
    public void isNotSundayTest(int day) {
        December date = new December(day);
        
        Assertions.assertFalse(date.isSunday());
    }
    
    @DisplayName("날짜가 크리스마스라면 true를 반환하고 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"25-true","24-false","26-false"}, delimiter = '-')
    public void isChristmasTest(int day, boolean result) {
        December date = new December(day);
    
        assertThat(date.isChristmas()).isEqualTo(result);
    }
}
