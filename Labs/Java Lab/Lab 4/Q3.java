// Final class and Methods

public class Q3 {
    public class A {
        final public void hello() {
            System.out.println("Hello from A");
        }
    }

    final public class B extends A {
        // Uncomment this to see the error
        // public void hello() {
        //     System.out.println("Hello from B");
        // }
    }

    // Uncomment this to see the error
    // public class C extends B {
    // }

    public void run() {
        A a = new A();
        a.hello();
        B b = new B();
        b.hello();
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        q3.run();
    }
}