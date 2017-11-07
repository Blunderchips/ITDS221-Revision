package basic;

import utilities.Utils;

/**
 * LinkedList. Created on 07 Nov 2017 12:35:15 PM by Matthew Van der Bijl.
 *
 * @author Matthew Van der Bijl
 * @sinse 07 Nov 2017
 */
public class LinkedList {

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i : Utils.getRandomArrayOfInts(10)) {
            list.insert(new Node(i));
        }

        System.out.println(list);
        System.out.println("Is empty: " + list.isEmpty());
        System.out.println("Size: " + list.getSize());
    }

    private Node head;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void insert(Node node) {
        if (this.isEmpty()) {
            this.head = node;
        } else {
            this.insert(node, head);
        }
    }

    public void insert(Node node, Node parent) {
        if (parent.getChild() == null) {
            parent.setChild(node);
        } else {
            this.insert(node, parent.getChild());
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" + head.toString() + "}";
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    public int getSize(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.getChild());
        }
    }

    public int getSize() {
        return getSize(head);
    }
}

class Node {

    private Object data;
    private Node child;

    public Node(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", child=" + child + '}';
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getChild() {
        return this.child;
    }

    public void setChild(Node child) {
        this.child = child;
    }
}
