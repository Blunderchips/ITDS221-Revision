package trees;

import basic.Queue;
import utilities.Utils;

/**
 * Binary Search Tree. Created on 08 Nov 2017 4:53:13 PM by Matthew Van der
 * Bijl.
 *
 * @author Matthew Van der Bijl
 * @sinse 08 Nov 2017
 */
public class BST {

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        BST tree = new BST();

        for (int i : Utils.getRandomArrayOfInts(10)) {
            tree.insert(new TreeNode(i));
        }

        System.out.println("Size: " + tree.getSize());
        System.out.println("Height: " + tree.getHeight());

        System.out.println("\nPreorder:");
        tree.preorder();

        System.out.println("\nInorder:");
        tree.inorder();

        System.out.println("\nPostorder:");
        tree.postorder();

        System.out.println("\nLevel order:");
        tree.levelorder();
    }

    /**
     * The root of the tree.
     */
    private TreeNode root;

    public BST() {
        this(null);
    }

    /**
     * @param root the root of the tree
     */
    public BST(TreeNode root) {
        this.root = root;
    }

    private void insert(TreeNode node, TreeNode parent) {
        if (parent.getData() < node.getData()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                this.insert(node, parent.getLeft());
            }
        } else if (parent.getData() > node.getData()) {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                this.insert(node, parent.getRight());
            }
        }
    }

    public void insert(TreeNode node) {
        if (this.isEmpty()) {
            this.root = node;
        } else {
            this.insert(node, root);
        }
    }

    private int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.getLeft()) + getSize(node.getRight());
        }
    }

    /**
     * @return the size of the tree
     */
    public int getSize() {
        return getSize(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            // NLR
            node.visit();
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    /**
     * Node, left, right.
     */
    public void preorder() {
        this.preorder(root);
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            // LNR
            inorder(node.getLeft());
            node.visit();
            inorder(node.getRight());
        }
    }

    /**
     * Left, Node, Right.
     */
    public void inorder() {
        this.inorder(root);
    }

    private void postorder(TreeNode node) {
        if (node != null) {
            // LRN
            postorder(node.getLeft());
            postorder(node.getRight());
            node.visit();
        }
    }

    /**
     * Left, Right, Node.
     */
    public void postorder() {
        this.postorder(root);
    }

    public void levelorder() {
        Queue q = new Queue(getSize());
        q.enqueue(root);

        while (!q.isEmpty()) {
            TreeNode node = (TreeNode) q.dequeue();
          
//            System.out.println(node);
            node.visit();

            if (node.getLeft() != null) {
                q.enqueue(node.getLeft());
            }
            if (node.getRight() != null) {
                q.enqueue(node.getRight());
            }
        }
    }

    /**
     * @return the root of the tree
     */
    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * @param root the new root of the tree
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return super.toString() + "{" + root + "}";
    }

    public boolean isEmpty() {
        return this.root == null;
    }
}
