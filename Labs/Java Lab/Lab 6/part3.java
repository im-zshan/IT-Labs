// Part 3: Implement the Dynamic Method Dispatch in Interfaces

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

public class part3 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();

        circle.draw();     // Dynamic method dispatch
        rectangle.draw();  // Dynamic method dispatch
        triangle.draw();   // Dynamic method dispatch
    }
}