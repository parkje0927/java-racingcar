package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import step3.domain.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("10 미만 랜덤값 생성 테스트")
    void randomNumberTest() {
        RandomNumber randomNumber = new RandomNumber();
        for (int i = 0; i < 1000; i++) {
            assertThat(randomNumber.randomNumber() < 10).isTrue();
        }
    }
}