//  Interfaces
//      -> Partial Implementataion
//      -> Default / Static / Private Methods
//      -> Dynamic Method Dispatch
//      -> Nested Interfaces
//      -> Constants
//      -> Multiple Interfaces Implementing within the same class

// Part 1: Partial Implementation in Interfaces using default methods

interface PartialInterface {
    void partialMethod();
    
    default void commonMethod() {
        System.out.println("This is a common method implementation.");
    }
}

class PartialImplementation implements PartialInterface {
    
    public void partialMethod() {
        System.out.println("Partial method implementation.");
    }
}

public class part1 {
    public static void main(String[] args) {
        PartialImplementation obj = new PartialImplementation();
        obj.partialMethod();
        obj.commonMethod();
    }
}
