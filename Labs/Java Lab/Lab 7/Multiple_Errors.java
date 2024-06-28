// Multiple Errors Handled using Single Catch (OR Operators)

public class Multiple_Errors {
    public static void main(String[] args) {
        try {
            performOperation(10, 0);
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void performOperation(int number, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        if (number == 0) {
            throw new NullPointerException("Number is null.");
        }
    }
}
