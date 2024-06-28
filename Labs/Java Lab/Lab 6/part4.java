// Part 4: Implement the Nested Interfaces

interface OuterInterface {
    void outerMethod();

    interface InnerInterface {
        void innerMethod();
    }
}

class OuterClass implements OuterInterface.InnerInterface {
    public void innerMethod() {
        System.out.println("Inner method is implemented!");
    }
}

public class part4 {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        outerObj.innerMethod();
    }
}
