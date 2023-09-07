import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalc1 {
    private BMICalc calculator;

    @BeforeEach
    public void init() {
        calculator = new BMICalc();
    }

    @Test
    @DisplayName("[1] Test to see that BMI is calculated correctly")
    public void testShouldReturnCorrectBMI() {
        double height = 1.95;
        double weight = 80;

        double expected = 21.0;
        double actual = calculator.calculateBMI(height, weight);

        assertEquals(expected, actual);
    }
}
