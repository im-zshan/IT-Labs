// Show class level access privilage of private members.

public class Q8 {
    private int number;

    public static void main(String[] args) {
        Q8 q8 = new Q8();
        q8.setNumber(10);
        Q8 q8_new = new Q8();
        q8_new.clone(q8);
        q8_new.printNumber();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void printNumber() {
        System.out.println(this.number);
    }

    public void clone(Q8 q8) {
        this.number = q8.number;
    }
}