// Part 1: Use Object class objects to create a generic-like class

public class Q1 {
    public static void main(String[] args) {
        GenericObjClass intObj = new GenericObjClass(10);
        GenericObjClass doubleObj = new GenericObjClass(10.20);
        GenericObjClass strObj = new GenericObjClass("Zeeshan Chowdhary");

        System.out.println(intObj.get());
        System.out.println(doubleObj.get());
        System.out.println(strObj.get());

    }
}

// use object class to create a generice like class
class GenericObjClass {
    public Object num;

    public GenericObjClass(Object num) {
        this.num = num;
    }

    public Object get() {
        return this.num;
    }
}
