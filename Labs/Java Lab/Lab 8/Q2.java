/* Part 2: Create -> generic class
                  -> Interface
                  -> Methods */

// Generic Class
// This class has a type parameter 'T' which allows us to create instances with different types.

public class Q2 {
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);

        GenericClass<Integer> intObj = new GenericClass<Integer>(10);
        GenericClass<Double> doubleObj = new GenericClass<Double>(10.10);
        GenericClass<String> charObj = new GenericClass<String>("char");
        System.out.println(intObj.get());
        System.out.println(doubleObj.get());
        System.out.println(charObj.get());


// Part 4: Use Generic class as regular objects (raw types)

        GenericClass rawObj1 = new GenericClass("Hi, Zeeshan Chowdhary!");
        System.out.println(rawObj1.get());
    }

// Part 3: Generic Method in a Non - Generic class.

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}

// generic interface
interface GenericInterface<T> {
    public T get();
}

// generic class
class GenericClass<T> implements GenericInterface<T> {
    T num1;

    public GenericClass(T num1) {
        this.num1 = num1;
    }

    public T get() {
        return this.num1;
    }

}