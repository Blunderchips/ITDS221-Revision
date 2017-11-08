package basic;

import java.util.Arrays;
import utilities.Utils;

/**
 * Queue. Created on 07 Nov 2017 12:20:54 PM by siD.
 *
 * @author Matthew Van der Bijl
 * @sinse 07 Nov 2017
 */
public class Queue {

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        Queue q = new Queue(10);

        for (int i : Utils.getRandomArrayOfInts(q.getMaxSize())) {
            q.enqueue(i);
        }

        System.out.println(q);
        System.out.println("Peak: " + q.peak() + "\n");
        System.out.println("Is full: " + q.isFull());
        System.out.println("Is empty: " + q.isEmpty());
        System.out.println("");

        while (!q.isEmpty()) {
            System.out.println("Dequeue: " + q.dequeue());
        }
        System.out.println("\nIs full: " + q.isFull());
        System.out.println("Is empty: " + q.isEmpty());
    }

    private int size;
    private Object[] data;

    private int front;
    private int rear;

    public Queue(int size) {
        this.size = 0;
        this.data = new Object[size];

        this.front = 0;
        this.rear = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void enqueue(Object i) {
        this.size++;
        this.front = (front + 1) % data.length;
        this.data[front] = i;
    }

    public Object dequeue() {
        this.size--;
        this.rear = (rear + 1) % data.length;
        return data[rear];
    }

    public Object peak() {
        return data[Math.max(rear, 0)];
    }

    @Override
    public String toString() {
        return "Queue{" + "size=" + size + ", data=" + Arrays.toString(data)
                + ", front=" + front + ", rear=" + rear + '}';
    }

    public int getMaxSize() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return data.length == size;
    }
}
