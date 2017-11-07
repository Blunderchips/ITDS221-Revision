package basic;

import java.util.Arrays;
import utilities.Utils;

/**
 * Stack. Created on 07 Nov 2017 12:08:37 PM by siD.
 *
 * @author Matthew Van der Bijl
 * @sinse 07 Nov 2017
 */
public class Stack {

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        Stack stack = new Stack(10);

        for (int i : Utils.getRandomArrayOfInts(stack.getMaxSize())) {
            stack.push(i);
        }

        System.out.println(stack);
        System.out.println("Peak: " + stack.peak() + "\n");
        System.out.println("Is full: " + stack.isFull());
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("");

        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }
        System.out.println("\nIs full: " + stack.isFull());
        System.out.println("Is empty: " + stack.isEmpty());
    }

    private int size;
    private int[] data;

    public Stack(int size) {
        this.size = 0;
        this.data = new int[size];
    }

    public void push(int i) {
        this.data[size++] = i;
    }

    public int pop() {
        return data[--size];
    }

    public int peak() {
        return data[size - 1];
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Stack{" + "size=" + size + ", data=" + Arrays.toString(data) + '}';
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return data.length == size;
    }

    public int getMaxSize() {
        return data.length;
    }
}
