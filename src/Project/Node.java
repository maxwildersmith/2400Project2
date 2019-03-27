package Project;

public class Node<T> {
    T data;
    Node<T> left, right;

    public Node(Node left, Node right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(T data){
        left=null;
        right=null;
        this.data=data;
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

    public boolean isLeaf(){
        return left==right&&left==null;
    }

    public boolean hasLeftChild(){
        return left!=null;
    }

    public boolean hasRightChild(){
        return right!=null;
    }

    public Node<T> copy(){
        Node<T> out = new Node<T>(data);
        if(left!=null)
            out.setLeft(left.copy());
        if(right!=null)
            out.setRight(right.copy());
        return out;
    }
//    public void copy(Node<T> source){
//        left=source.getLeft()
//    }
}
