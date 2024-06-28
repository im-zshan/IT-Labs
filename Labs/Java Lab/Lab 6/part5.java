// Part 5: Implement the Interface level constants

// Here we define an interface called 'Constants', where we declare two interface-level constants: 'MAX_COUNT' & 'DEFAULT_NAME'
// These constants are declared as - public, static & final
// When the code is executed, it will print the values of the constants to the console

interface Constants {
     int MAX_COUNT = 100;
     String DEFAULT_NAME = "Zeeshan Sharif";
}

public class part5 implements Constants{
    public static void main(String[] args) {
        System.out.println("Max count: " + Constants.MAX_COUNT);
        System.out.println("Default name: " + Constants.DEFAULT_NAME);

    }
}
