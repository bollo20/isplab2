package laborator6;

public class Main {
    public static void main() {
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + result);
        NewIntCalculator intCalculator = new NewIntCalculator();
        intCalculator.init(10);
        int intResult2 = intCalculator.add(5).subtract(3).multiply(2).result();
        System.out.println("Rezultatul pentru NewIntCalculator: " + intResult2); // Output: 24
        DoubleCalculator doubleCalculator = new DoubleCalculator();
        doubleCalculator.init(10.0);
        double doubleResult = doubleCalculator.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("Rezultatul pentru DoubleCalculator: " + doubleResult);
    }
}
