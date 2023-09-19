public class BMICalc {

    public double calculateBMI(double height, double weight) {
        if (height == 0 || weight == 0) {
            return -1;
        }
        return Math.round(weight / (height * height) * 10) / 10.0;
    }

    public String getBMICategoryString(double height, double weight) {
        double BMI = calculateBMI(height, weight);
        if (BMI < 18.5) {
            return "Underweight";
        } else if (BMI < 25) {
            return "Normal weight";
        } else if (BMI < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
