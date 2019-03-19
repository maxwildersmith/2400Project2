package Project;

public class BinarySearchTree<T> implements TreeInterface {
    Node<T> root;
    int numberOfNodes;

    public BinarySearchTree(Node<T> root){
        this.root=root;
        numberOfNodes=0;
    }

    public String preorder(Node<T> node){
        if(node==null)
            return "";
        return node.data+", "+preorder(node.getLeft())+", "+preorder(node.getRight());
    }

    public String postorder(Node<T> node){
        if(node==null)
            return "";
        return postorder(node.getLeft())+", "+postorder(node.getRight())+", "+node.getData();
    }

    public String inorder(Node<T> node){
        if(node==null)
            return "";
        return inorder(node.getLeft())+", "+node.getData()+", "+inorder(node.getRight());
    }
}
