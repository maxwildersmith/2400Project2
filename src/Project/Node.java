package Project;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Node<T> {
    private T data;
    private Node<T> left, right;

    /**
     * Constructs a new Node with a left and right child as well as a data value.
     * @param left The left child node
     * @param right The right child node
     * @param data The data value for the node
     */
    public Node(Node<T> left, Node<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    /**
     * Constructs a node with no children, and only a data value.
     * @param data The data value for the node
     */
    public Node(T data){
        left=null;
        right=null;
        this.data=data;
    }

    /**
     * Gets the left child node of this node.
     * @return The left child node.
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Sets the left child node.
     * @param left The node to set as left child.
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Gets the right child node of this node.
     * @return The right child node.
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Sets the right child node.
     * @param right The node to set as right child.
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Returns the data of this node.
     * @return The data of this node.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data value for this node.
     * @param data The value to set data as.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Checks whether this node is lead node, ie. has children.
     * @return True if the node has no children, false otherwise.
     */
    public boolean isLeaf(){
        return left==right&&left==null;
    }

    /**
     * Checks whether the node has a left child.
     * @return True if there is a left child.
     */
    public boolean hasLeftChild(){
        return left!=null;
    }

    /**
     * Checks whether the node has right child.
     * @return True if there is right child.
     */
    public boolean hasRightChild(){
        return right!=null;
    }
}
