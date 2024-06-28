// Creaing our own custom exception in java.

class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }
}

public class User_defined_Exception {
    public static void main(String[] args) {
        try {
            String name = "Zeeshan";
            validateName(name);
        } catch (NameException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void validateName(String name) throws NameException {
        if (name.equalsIgnoreCase("Saqib")) {
            throw new NameException("Name not allowed: " + name);
        }
        System.out.println("Name is valid: " + name);
    }
}
