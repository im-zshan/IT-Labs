import java.util.EmptyStackException;
import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> { // Stack i.e. (LIFO) where the last element added to the stack is the first one to be removed.
    private List<T> stack;     // Using a generic type `T` that allows the stack to hold elements of any type.

    public GenericStack() {
        stack = new ArrayList<>(); // Internal ArrayList named 'Stack'
    }

    public void push(T element) { // Push Method: Adds an element to the top of the stack
        stack.add(element);
    }

    public T pop() { // Pop Method: Removes and returns the element from the top of the stack.
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() { // Peak Method: Returns the element from the top of the stack without removing it.
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() { // isEmpty Method: Checks if the stack is empty and returns `true` if it is.
        return stack.isEmpty();
    }

    public int size() { // size Method: Returns the number of elements in the stack.
        return stack.size();
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>(); // stack is created to hold integer values.

        stack.push(10); // Elements `10`, `20`, and `30` are then pushed onto the stack using the `push` method. 
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // `peek` retrieves the top element (30) without removing it and prints it.

        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement); // 'pop` removes and returns the top element (30) from the stack.

        System.out.println("Size of stack: " + stack.size()); // `size` retrieves the number of elements in the stack (2) and prints it.

        System.out.println("Is stack empty? " + stack.isEmpty()); // `isEmpty` checks if the stack is empty (false) and prints the result.
    }
}
