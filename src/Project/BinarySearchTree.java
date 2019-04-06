package Project;

public class BinarySearchTree<T extends Comparable<T>> implements TreeInterface<T> {
    Node<T> root;

    public BinarySearchTree(Node<T> root){
        this.root=root;
    }

    public BinarySearchTree(){
        this(null);
    }

    public String preorder(){
        return preorder(root).trim();
    }

    private String preorder(Node<T> node){
        if(node==null)
            return "";
        return " "+node.getData()+preorder(node.getLeft())+preorder(node.getRight());
    }

    public String postorder(){
        return postorder(root).trim();
    }

    private String postorder(Node<T> node){
        if(node==null)
            return "";
        return postorder(node.getLeft())+postorder(node.getRight())+node.getData()+" ";
    }

    public String inorder(){
        return inorder(root).trim().replace("  "," ");
    }

    private String inorder(Node<T> node){
        if(node==null)
            return "";
        return inorder(node.getLeft())+" "+node.getData()+" "+inorder(node.getRight());
    }

    public boolean contains(T entry){
        return contains(entry, root);
    }

    private boolean contains(T entry, Node<T> start){
        if(start==null)
            return false;
        if(entry.equals(start.getData()))
            return true;
        else if(entry.compareTo(start.getData())>0)
            return contains(entry,start.getRight());
        else if (entry.compareTo(start.getData())<0)
            return contains(entry,start.getLeft());
        return false;
    }

    public void add(T entry) {
        root = add(root, entry);
    }

    public Node<T> add(Node<T> start, T entry){
        if(start==null)
            return new Node<T>(entry);
        if(entry.compareTo(start.getData())>0)
            start.setRight(add(start.right,entry));
        else if (entry.compareTo(start.getData())<0)
            start.setLeft(add(start.left,entry));
        else
            throw new IllegalStateException(entry+" already exists!");
        return start;
    }

    /**
     *
     * @return
     */
    public int getNumberOfNodes(){
        return getNumberOfNodes(root);
    }

    private int getNumberOfNodes(Node<T> start){
        if(start==null)
            return 0;
        return 1+getNumberOfNodes(start.getRight())+getNumberOfNodes(start.getLeft());
    }


    public T remove(T target) {
        return remove(target,root).getData();
    }

    private Node<T> remove(T target, Node<T> start){
        if(start==null)
            return null;
        else if(target.compareTo(start.getData())>0)
            start.setRight(remove(target,start.getRight()));
        else if (target.compareTo(start.getData())<0)
            start.setLeft(remove(target,start.getLeft()));
        else{
            if(!start.hasLeftChild())
                return start.getRight();
            else if (!start.hasRightChild())
                return start.getLeft();

            start.setData(findMin(start.getRight()));
            start.setRight(remove(start.getData(),start.getRight()));
        }
        return start;
    }

    public void removeAll(T target) {

    }

    public T removeMin() {
        return remove(findMin());
    }

    private T removeMin(Node<T> start){
        if(start.getLeft()==null) {
            T tmp = start.getData();
            start=start.getRight();
            return tmp;
        }
        return removeMin(start.getLeft());
    }

    public T removeMax() {
        return remove(findMax());
    }

    private T removeMax(Node<T> start){
        if(start.getRight()==null) {
            T tmp = start.getData();
            start=start.getLeft();
            return tmp;
        }
        return removeMin(start.getRight());
    }

    public T findMax() {
        return findMax(root);
    }

    private T findMax(Node<T> top){
        if(top.getRight()==null)
            return top.getData();
        return findMax(top.getRight());
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMin(Node<T> top){
        if(top.getLeft()==null)
            return top.getData();
        return findMin(top.getLeft());
    }

    public void clear(){
        root=null;
    }
}
