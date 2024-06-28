// // Abstract class and Methods

// public class Q4 {
//     abstract public class A {
//         abstract public void hello();
//     }

//     final public class B extends A {
//         public void hello() {
//             System.out.println("Hello from B");
//         }
//     }

//     public void run() {
//         // Uncomment this to see the error
//         // A a = new A();
//         // a.hello();
//         B b = new B();
//         b.hello();
//     }

//     public static void main(String[] args) {
//         Q4 q4 = new Q4();
//         q4.run();
//     }
// }

// Here without creating inner class, directly Implementing

public class Q4 {
    public static void main(String[] args) {
        Square sq = new Square(10, 20);
        System.out.println(sq.getArea());
    }
}

abstract class Figure {
    int area;

    abstract int getArea();
}

class Square extends Figure {
    int length;
    int breadth;

    public Square(int len, int breadth) {
        this.length = len;
        this.breadth = breadth;
    }

    int getArea() {
        return this.length * this.breadth;
    }
}