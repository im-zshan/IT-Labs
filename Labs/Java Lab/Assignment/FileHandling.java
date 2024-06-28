import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        // Task 1: Create a directory named "Demo" in the current working directory
        String directoryName = "Demo";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory: " + directory.getAbsolutePath());
                return;
            }
        }

        // Task 2: Create a text file named "example.txt" inside the "Demo" directory
        String fileName = directoryName + File.separator + "example.txt";
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }

        // Task 3: Write some sample text content to the file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("    Hi there, I am Zeeshan Chowdhary giving console the very first content.");
            System.out.println("\n $ Content written to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // Task 4: Read the contents of the file and display them on the console
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n ## Contents of the file is:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Task 5: Update the content of the file by appending new text
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("\n    This is additional text that I added. I am from IT branch of NIT Srinagar.");
            System.out.println("\n $ Additional content appended to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file: " + e.getMessage());
        }

        // Task 6: Read the updated contents of the file and display them on the console
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n ## Updated contents of the file is:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Task 7: Delete the file "example.txt"
        if (file.delete()) {
            System.out.println("\nFile deleted: " + file.getAbsolutePath());
        } else {
            System.out.println("Failed to delete file: " + file.getAbsolutePath());
        }

        // Task 8: Delete the directory "Demo"
        if (directory.delete()) {
            System.out.println("Directory deleted: " + directory.getAbsolutePath());
        } else {
            System.out.println("Failed to delete directory: " + directory.getAbsolutePath());
        }
    }
}
