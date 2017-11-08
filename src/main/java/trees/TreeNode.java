package trees;

/**
 * TreeNode. Created on 08 Nov 2017 4:53:50 PM by Matthew Van der Bijl.
 *
 * @author Matthew Van der Bijl
 * @sinse 08 Nov 2017
 */
public class TreeNode implements Comparable<TreeNode> {

    private int data;
    private TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(TreeNode other) {
        return Integer.compare(this.getData(), other.getData());
    }

    public void visit() {
        System.out.println(data);
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}
