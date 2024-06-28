// Implementation of Static Methods, variables and constants.

public class Q3 {
    public static int count = 0;
    public int number;
    final int pi;

    {
        pi = 3;
    }

    public static int getCount() {
        return count;
    }

    public Q3() {
        Q3.count++;
    }

    public static void main(String[] args) {
        System.out.println("Total Objects: " + Q3.getCount());
        Q3 q3 = new Q3();
        System.out.println("Total Objects: " + Q3.getCount());
    }
}