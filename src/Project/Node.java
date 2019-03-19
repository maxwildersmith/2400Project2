package Project;

public class Node<T> {
    Node<T> left, right;
    T data;

    public Node(Node left, Node right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
