
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalc2 {
    private BMICalc calculator;

    @BeforeEach
    public void init() {
        calculator = new BMICalc();
    }

    @Test
    @DisplayName("[1] Test underweight")
    public void testUnderweight() {
        double height = 1.90;
        double weight = 66.424;

        double expectedBMI = 18.4;
        double actualBMI = calculator.calculateBMI(height, weight);
        String actualBMIText = calculator.getBMICategoryString(height, weight);

        assertEquals(expectedBMI, actualBMI);
        assertEquals("Underweight", actualBMIText);
    }

    @Test
    @DisplayName("[1] Test if boundary for normal weight operates correctly")
    public void testNormalWeightBoundary() {
        double height = 1.90;
        double weight = 66.785;

        double expectedBMI = 18.5;
        double actualBMI = calculator.calculateBMI(height, weight);
        String actualBMIText = calculator.getBMICategoryString(height, weight);

        assertEquals(expectedBMI, actualBMI);
        assertEquals("Normal weight", actualBMIText);
    }

    @Test
    @DisplayName("[1] Test BMI calculation and categorization of a normal weight person")
    public void testNormalWeight() {
        double height = 1.90;
        double weight = 90;

        double expectedBMI = 24.9;
        double actualBMI = calculator.calculateBMI(height, weight);
        String actualBMIText = calculator.getBMICategoryString(height, weight);

        assertEquals(expectedBMI, actualBMI);
        assertEquals("Normal weight", actualBMIText);
    }

    @Test
    @DisplayName("[1] Test if boundary for overweight operates correctly")
    public void testOverweightBoundary() {
        double height = 1.90;
        double weight = 90.25;

        double expectedBMI = 25.0;
        double actualBMI = calculator.calculateBMI(height, weight);
        String actualBMIText = calculator.getBMICategoryString(height, weight);

        assertEquals(expectedBMI, actualBMI);
        assertEquals("Overweight", actualBMIText);
    }

    @Test
    @DisplayName("[1] Test BMI calculation and categorization of an overweight person")
    public void testOverweight() {
        double height = 1.90;
        double weight = 100;

        double expectedBMI = 27.7;
        double actualBMI = calculator.calculateBMI(height, weight);
        String actualBMIText = calculator.getBMICategoryString(height, weight);

        assertEquals(expectedBMI, actualBMI);
        assertEquals("Overweight", actualBMIText);
    }

    @Test
    @DisplayName("[1] Test if boundary for obese operates correctly")
    public void testObeseBoundary() {
        double height = 1.90;
        double weight = 108.3;

        double expectedBMI = 30.0;
        double actualBMI = calculator.calculateBMI(height, weight);
        String actualBMIText = calculator.getBMICategoryString(height, weight);

        assertEquals(expectedBMI, actualBMI);
        assertEquals("Obese", actualBMIText);
    }

    @Test
    @DisplayName("[1] Test BMI calculation and categorization of an obese person")
    public void testObese() {
        double height = 1.90;
        double weight = 180;

        double expectedBMI = 49.9;
        double actualBMI = calculator.calculateBMI(height, weight);
        String actualBMIText = calculator.getBMICategoryString(height, weight);

        assertEquals(expectedBMI, actualBMI);
        assertEquals("Obese", actualBMIText);
    }

    @Test
    @DisplayName("[1] Test error handling with invalid input for weight")
    public void testNegativeOrZeroWeight() {
        double expected = -1;

        double actual = calculator.calculateBMI(1.6, 0);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("[1] Test error handling with invalid input for height")
    public void testNegativeOrZeroheight() {
        double expected = -1;

        double actual = calculator.calculateBMI(0, 90);

        assertEquals(expected, actual);
    }
}
