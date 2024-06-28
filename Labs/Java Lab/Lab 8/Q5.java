//Part 5: Collections;
//         -> List ADT
//          -> Linked List ADT
//          -> Array List ADT
//          -> Stack ADT
//          -> Queue ADT

import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        // List ADT
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("hello" + i);
        }
        list.add("hello 6");
        list.add("hello 7");
        System.out.println("List: " + list);

        // LinkedList ADT
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i * 10);
        }
        linkedList.add(20);
        linkedList.add(100);
        System.out.println("LinkedList: " + linkedList);

        // ArrayList ADT
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(3.14);
        arrayList.add(2.71);
        arrayList.add(1.618);
        System.out.println("Second elem" + arrayList.get(2));
        System.out.println("ArrayList: " + arrayList);

        // Stack ADT
        // Stack<String> stack = new Stack<>();
        // for (int i = 0; i < 5; i++) {
        // stack.push("Element" + i);
        // }
        // stack.pop(); // lifo
        // System.out.println("Stack: " + stack);

        // Queue ADT
        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(100);
        // queue.add(200);
        // queue.add(300);
        // queue.remove(); // fifo
        // System.out.println("Queue: " + queue);

        // implement queue using class
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("queue size: " + queue.size());

        System.out.println("Top element: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println("removed element: " + queue.remove());
        }

        System.out.println("queue is empty: " + queue.isEmpty());

        // implement stack using deque
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.size());

        System.out.println("Top element: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}

class MyStack<T> {
    public Deque<T> stack;

    public MyStack() {
        stack = new ArrayDeque<>();
    }

    public void push(T element) {
        stack.push(element);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

}

class MyQueue<T> {
    public Queue<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void add(T element) {
        queue.add(element);
    }

    public T remove() {
        return queue.remove();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

}