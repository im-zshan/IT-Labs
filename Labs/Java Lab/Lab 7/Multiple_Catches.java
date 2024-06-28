// Implementation of Try with Multiple Catches

import java.io.FileNotFoundException;
import java.io.IOException;

public class Multiple_Catches {
    public static void main(String[] args) {
        try {
            
            throwException("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }

    public static void throwException(String filename) throws IOException, FileNotFoundException {
        if (filename.isEmpty()) {
            throw new FileNotFoundException("File name is empty.");
        } else {
            throw new IOException("An IO error occurred.");
        }
    }
}
