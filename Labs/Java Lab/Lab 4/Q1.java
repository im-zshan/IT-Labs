// CONSTRUCTORS -> Superclass in Subclass
// Object Cloning using Super

public class Q1 {
    public class Parent {
        int x;

        Parent(int x) {
            System.out.println("Parent Constructor");
            this.x = x;
        }

        public void printX() {
            System.out.println(x);
        }
    }

    public class Child extends Parent {
        Child() {
            super(10);
            System.out.println("Child");
        }
    }

    public void run() {
        Parent parent = new Parent(5);
        Child child = new Child();
        parent.printX();
        child.printX();
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        q1.run();
    }
}