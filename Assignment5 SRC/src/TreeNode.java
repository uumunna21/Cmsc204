// TODO: Auto-generated Javadoc
/**
 * A generic TreeNode class used to construct binary trees.
 * Each TreeNode contains data and references to left and right child nodes.
 * 
 * @param <T> The type of data stored in the node.
 */
public class TreeNode<T> {
    
    /** The data. */
    protected T data;
    
    /** The left. */
    protected TreeNode<T> left;
    
    /** The right. */
    protected TreeNode<T> right;

    /**
     * Constructor - creates a new TreeNode with given data and null children.
     * @param data the data to be stored in the node
     */
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Copy constructor - creates a new TreeNode by copying another node.
     * @param node the TreeNode to copy
     */
    public TreeNode(TreeNode<T> node) {
        this.data = node.data;
        this.left = node.left;
        this.right = node.right;
    }

    /**
     * Returns the data stored in the node.
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data stored in the node.
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the left child of the node.
     * @return the left child
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Sets the left child of the node.
     * @param left the left child to set
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Returns the right child of the node.
     * @return the right child
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Sets the right child of the node.
     * @param right the right child to set
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
