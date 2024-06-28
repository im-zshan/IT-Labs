// Implementing different methods of string class, for and for each loop along with Hasnext method

import java.util.Scanner;

public class String_Methods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Using various methods of String class
        System.out.println("String Length: " + inputString.length());
        System.out.println("Uppercase: " + inputString.toUpperCase());
        System.out.println("Lowercase: " + inputString.toLowerCase());
        System.out.println("Substring (2, 6): " + inputString.substring(2, 6));
        System.out.println("Index of 'a': " + inputString.indexOf('a'));
        System.out.println("Last index of 'a': " + inputString.lastIndexOf('a'));
        System.out.println("Contains 'abc': " + inputString.contains("abc"));

        // Using for loop
        System.out.println("\nUsing for loop:");
        for (int i = 0; i < inputString.length(); i++) {
            System.out.println(inputString.charAt(i));
        }

        // Using foreach loop
        System.out.println("\nUsing foreach loop:");
        for (char ch : inputString.toCharArray()) {
            System.out.println(ch);
        }

        // Using hasNext method
        System.out.println("\nUsing hasNext method:");
        Scanner stringScanner = new Scanner(inputString);
        while (stringScanner.hasNext()) {
            System.out.println(stringScanner.next());
        }

        scanner.close();
        stringScanner.close();
    }
}
