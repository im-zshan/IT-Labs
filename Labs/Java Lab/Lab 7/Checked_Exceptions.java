// Implementation of Checked Exceptions.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Checked_Exceptions {
    public static void main(String[] args) {
        try {
            readFromFile("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IOException("An error occurred while reading the file.");
        }
    }
}
