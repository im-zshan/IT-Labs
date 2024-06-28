// Implementation of Method Overloading

public class Q5 {
    public void printTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public void printTimes(String str) {
        printTimes(str, 2);
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        q5.printTimes("Assalalikum", 3);
        q5.printTimes("Duniya");
    }
}