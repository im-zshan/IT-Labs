// Implementation of Simple Try Catch

public class Try_Catch {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3 };

        try {
            
            int result = numbers[4];      // Access an element outside the bounds of the array
            System.out.println("Result: " + result);
        }
        
        catch (ArrayIndexOutOfBoundsException e) {  // This catch block will not be executed
            
            System.out.println("Caught exception: " + e);
        }
    }
}