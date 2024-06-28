//   Write Programs of Object Class:
//   1. use getclass()
//   2. use equals()
//   3. use hashcode()
//   4. use tostring()

//   Explore the in-built packages. Also create and import packages.

import java.lang.*;

class Check {
    private String s;
    private int a;
    static int Classes = 0;
    private int hash;

    Check() {
    }

    Check(String s, int a) {
        this.s = s;
        this.a = a;
        Classes++;
        this.hash = Classes;
    }

    void setA(int a) {
        this.a = a;
    }

    void setS(String s) {
        this.s = s;
    }

    int getA() {
        return this.a;
    }

    String getS() {
        return this.s;
    }

    public boolean equals(Object t) {
        if ((t.getClass() != this.getClass()) || t == null) {
            return false;
        }
        Check t1 = (Check) t;
        return t1.getA() == this.a && t1.getS() == this.s && t1.hashCode() == this.hashCode();
    }

    public int hashCode() {
        return hash;
    }

    public String toString() {
        return "a = " + this.a + ", s = " + this.s;
    }
}

public class MyClass1 {
    public static void main(String args[]) {

        // // getClass Method
        // Object obj = new String("Ashish");
        // System.out.println("Class of Object obj is : " + obj.getClass());

        // // Equal Method
        // // obj1
        // Object obj1 = new String("xyz");
        // // obj2
        // Object obj2 = new String("abc");

        // System.out.println("Objects are equal:" + obj1.equals(obj1));

        // // toString Method
        // System.out.println(obj1);
        // System.out.println(obj1.toString());

        // // hashCode Method
        // System.out.println(obj1.hashCode());
        // System.out.println(obj2.hashCode());

        Object obj = new String("Ashish");
        System.out.println(obj.getClass());

        Object obj1 = new Check("Karan", 19);
        Check t = new Check("Karan", 20);

        System.out.println(obj1.getClass());

        System.out.println(t.equals(obj1));

        System.out.println(obj1.hashCode());
        System.out.println(t.hashCode());

        System.out.println(t.toString());

    }
}