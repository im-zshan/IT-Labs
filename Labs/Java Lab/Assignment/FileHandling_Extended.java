import java.io.*;

public class FileHandling_Extended {
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
            return;
        }

        // Task 3: Write some sample text content to the file using character streams
        try (Writer writer = new FileWriter(file)) {
            writer.write("Hi there, I am Zeeshan Chowdhary giving console the very first content.");
            System.out.println("\n$ Content written to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            return;
        }

        // Task 4: Read the contents of the file using character streams and display them on the console
        try (Reader reader = new FileReader(file)) {
            StringBuilder contentBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                contentBuilder.append((char) character);
            }
            String content = contentBuilder.toString();
            System.out.println("\n## Contents of the file is:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        // Task 5: Create a new text file named "byteExample.txt" and write some text using byte streams
        String byteFileName = directoryName + File.separator + "byteExample.txt";
        try (OutputStream outputStream = new FileOutputStream(byteFileName)) {
            String byteContent = "This is an example of writing text using byte streams.";
            byte[] byteData = byteContent.getBytes();
            outputStream.write(byteData);
            System.out.println("\n$ Content written to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            return;
        }

        // Task 6: Read the contents of "byteExample.txt" using byte streams and display them on the console
        try (InputStream inputStream = new FileInputStream(byteFileName)) {
            byte[] byteData = inputStream.readAllBytes();
            String byteContent = new String(byteData);
            System.out.println("\n## Contents of the file is:");
            System.out.println(byteContent);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        // Task 7: Create a new text file named "characterExample.txt" and write some text using character streams
        String characterFileName = directoryName + File.separator + "characterExample.txt";
        try (Writer writer = new FileWriter(characterFileName)) {
            String characterContent = "This is an example of writing text using character streams.";
            writer.write(characterContent);
            System.out.println("\n$ Content written to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            return;
        }

        // Task 8: Read the contents of "characterExample.txt" using character streams and display them on the console
        try (Reader reader = new FileReader(characterFileName)) {
            StringBuilder contentBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                contentBuilder.append((char) character);
            }
            String content = contentBuilder.toString();
            System.out.println("\n## Contents of the file is:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        // Task 9: Delete the file "example.txt"
        if (file.delete()) {
            System.out.println("\nFile deleted: " + file.getAbsolutePath());
        } else {
            System.out.println("Failed to delete file: " + file.getAbsolutePath());
        }

        // Task 10: Delete the directory "Demo"
        if (directory.delete()) {
            System.out.println("Directory deleted: " + directory.getAbsolutePath());
        } else {
            System.out.println("Failed to delete directory: " + directory.getAbsolutePath());
        }
    }
}
