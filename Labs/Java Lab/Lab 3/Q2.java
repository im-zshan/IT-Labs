// Implementation of java code using accessor method to mutate the state of an objects.

public class Q2 {
    private int[] array;

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        int[] arr = q2.getArray();
        q2.printArray();
        arr[9] = 0;
        q2.printArray();
    }

    public Q2() {
        this.array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}