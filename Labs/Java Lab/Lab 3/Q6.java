// Implementation of Constructor Overloading

public class Q6 {
    private int number;

    public Q6() {
        this.number = 0;
    }

    public Q6(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Q6 q6_1 = new Q6();
        q6_1.printNumber();
        Q6 q6_2 = new Q6(10);
        q6_2.printNumber();
    }

    public void printNumber() {
        System.out.println(this.number);
    }
}