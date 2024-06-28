// Class Method of one class using object of other class.

public class Q9 {
    private int number;

    public void increment(int number) {
        this.number += number;
    }

    public void printNumber() {
        System.out.println(number);
    }

    public void incrementObj(Q9 obj, int number) {
        obj.increment(number);
    }

    public static void main(String[] args) {
        Q9 q9 = new Q9();
        Q9 q9_inc = new Q9();
        q9.printNumber();
        q9_inc.incrementObj(q9, 3);
        q9.printNumber();
    }
}