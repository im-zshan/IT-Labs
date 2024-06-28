// Implementation of Method parameter passing (Object, Primitive Type)

public class Q4 {
    public void printTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        q4.printTimes("Hello! Zeeshan", 5);
    }
}