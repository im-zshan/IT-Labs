// Implement Dynamic method binding (Polymorphism)

public class Q2 {
    public class Parent {
        public void hello() {
            System.out.println("Hello from Parent");
        }
    }

    public class Child extends Parent {
        public void hello() {
            System.out.println("Hello from Child");
        }
    }

    public void run() {
        Parent parent = new Parent();
        Child child = new Child();
        parent.hello();
        child.hello();
        parent = child;
        parent.hello();
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        q2.run();
    }
}