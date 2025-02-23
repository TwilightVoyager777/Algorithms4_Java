package Chapter0_JavaBasic.ExceptionHandling;

public class ExceptionHandling {
    public static void divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            System.out.println(a / b);
        }
    }

    public static void main(String[] args) {
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}
