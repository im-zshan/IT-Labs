// Part 2: Making two Interfaces and Implementing Default, Static and Private Methods

interface Interface1 {
    default void defaultMethod() {
        System.out.println("Interface1 is default method");
    }

    static void staticMethod() {
        System.out.println("Interface1 is static method");
    }
}

interface Interface2 {
    default void defaultMethod() {
        System.out.println("Interface2 is default method");
    }

    static void staticMethod() {
        System.out.println("Interface2 is static method");
    }
}

class MyClass implements Interface1, Interface2 {
    
    public void defaultMethod() {
        Interface1.super.defaultMethod(); // Here we are Calling default method from Interface1
        Interface2.super.defaultMethod(); // Here we are Calling default method from Interfa
}

public class part2 {
    public static void main(String[] args) {
        MyClass myObj = new MyClass();
        myObj.defaultMethod();
        myObj.defaultMethod();
        
        Interface1.staticMethod();
        Interface2.staticMethod();
    }
}
}