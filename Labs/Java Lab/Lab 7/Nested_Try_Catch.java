// Implementataion of Nested Try Catch

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Nested_Try_Catch {
    public static void main(String[] args) {
        try {
            readFromFile("input.txt");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void readFromFile(String filename) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    System.out.println("Number: " + number);
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid number format: " + line);
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
