public class Q5 {
    public class Parent {
    }

    public class Child extends Parent {
    }

    public void run() {
        Child child[] = new Child[5];
        Parent parent[] = child;
        // Uncomment this to see the error
        parent[0] = new Parent();
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        q5.run();
    }
}