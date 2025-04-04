package laborator6;

public class Main {
    public static void main() {
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + result);
    }
}
