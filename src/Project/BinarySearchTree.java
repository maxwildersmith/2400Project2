package Project;

import jdk.dynalink.NamedOperation;

@SuppressWarnings({"WeakerAccess", "unused"})
public class BinarySearchTree<T extends Comparable<T>> implements SearchTreeInterface<T> {
    Node<T> root;

    /**
     * Creates a new BST with a particular node as the root.
     * @param root The root node to use
     */
    public BinarySearchTree(Node<T> root){
        this.root=root;
    }

    /**
     * The default constructor for the BST that creates an empty BST.
     */
    public BinarySearchTree(){
        this(null);
    }

    /**
     * Prints out the preorder traversal of the tree rooted at the root node
     * @return The preorder String.
     */
    public String preorder(){
        return preorder(root).trim();
    }

    /**
     * Private recursive method to print a tree in preorder traversal rooted at node.
     * @param node The root node for the tree.
     * @return The String for the preorder traversal based at node.
     */
    private String preorder(Node<T> node){
        if(node==null)
            return "";
        return " "+node.getData()+preorder(node.getLeft())+preorder(node.getRight());
    }

    /**
     * Gets a postorder traversal of the tree.
     * @return The String for the postorder traversal.
     */
    public String postorder(){
        return postorder(root).trim();
    }

    /**
     * Private recursive method to print a tree in postorder traversal rooted at node.
     * @param node The root node for the tree.
     * @return The String for the postorder traversal based at node.
     */
    private String postorder(Node<T> node){
        if(node==null)
            return "";
        return postorder(node.getLeft())+postorder(node.getRight())+node.getData()+" ";
    }

    /**
     * Gets a inorder traversal of the tree.
     * @return The String for the inorder traversal.
     */
    public String inorder(){
        return inorder(root).trim().replace("  "," ");
    }

    /**
     * Private recursive method to print a tree in inorder traversal rooted at node.
     * @param node The root node for the tree.
     * @return The String for the inorder traversal based at node.
     */
    private String inorder(Node<T> node){
        if(node==null)
            return "";
        return inorder(node.getLeft())+" "+node.getData()+" "+inorder(node.getRight());
    }

    /**
     * Checks whether the BST contains a certain entry.
     * @param entry The entry to search for
     * @return True if the BST contains the entry, false if not
     */
    public boolean contains(T entry){
        return contains(entry, root);
    }

    /**
     * Recursively checks for a given entry in the tree rooted at start.
     * @param entry The entry to look for.
     * @param start The starting node of the tree to look in.
     * @return True if the entry is in the given tree, false otherwise.
     */
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

    /**
     * Method to add an entry to the BST
     * @param entry The entry to add to the BST
     * @return Null if the entry was added properly, otherwise it returns the the node already in the tree.
     */
    public Node<T> add(T entry) {
        Node<T> result=null;
        if(isEmpty())
            root= new Node<>(entry);
        else
            result = add(root,entry);
        return result;
    }

    /**
     * The private recursive method to add a new node to the BST.
     * @param start The node to begin the search at
     * @param entry The entry to add to the BST
     * @return null the new entry was added, or the node if the entry already exists.
     */
    private Node<T> add(Node<T> start, T entry){
        if(start==null)
            return null;

        if(entry.compareTo(start.getData())<0)
            if(start.hasLeftChild())
                return add(start.getLeft(),entry);
            else
                start.setLeft(new Node<>(entry));
        else if (entry.compareTo(start.getData())>0)
            if(start.hasRightChild())
                return add(start.getRight(),entry);
            else
                start.setRight(new Node<>(entry));
        else
            return start;
        return null;
    }

    public boolean isEmpty() {
        return root==null;
    }

    /**
     * Gets the number of nodes in the BST.
     * @return the number of nodes in the BST.
     */
    public int getNumberOfNodes(){
        return getNumberOfNodes(root);
    }

    /**
     * Gets the number of nodes under a certain root node recursively.
     * @param start The root node to start looking under.
     * @return The number of nodes under the root node.
     */
    private int getNumberOfNodes(Node<T> start){
        if(start==null)
            return 0;
        return 1+getNumberOfNodes(start.getRight())+getNumberOfNodes(start.getLeft());
    }

    /**
     * Removes a certain node from the BST.
     * @param target entry to remove
     * @return Null if it isn't in the tree.
     */
    public Node<T> remove(T target) {
        Node<T> result = remove(target,root);
        if(result!=null)
            root=result;
        return result;
    }

    /**
     * Recursively removes a target node from the tree rooted at start.
     * @param target The entry to remove.
     * @param start The root node for the tree to search under.
     * @return The node removed or null if the node wasn't in the tree.
     */
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

//    public Node<T> removeMin() {
//        return remove(findMin());
//    }
//
//    private T removeMin(Node<T> start){
//        if(start.getLeft()==null) {
//            T tmp = start.getData();
//            start=start.getRight();
//            return tmp;
//        }
//        return removeMin(start.getLeft());
//    }
//
//    public Node<T> removeMax() {
//        return remove(findMax());
//    }
//
//    private T removeMax(Node<T> start){
//        if(start.getRight()==null) {
//            T tmp = start.getData();
//            start=start.getLeft();
//            return tmp;
//        }
//        return removeMin(start.getRight());
//    }
//
//    public T findMax() {
//        return findMax(root);
//    }
//
//    private T findMax(Node<T> top){
//        if(top.getRight()==null)
//            return top.getData();
//        return findMax(top.getRight());
//    }
//
//    public T findMin() {
//        return findMin(root);
//    }

    public T getRootData() {
        return root.getData();
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
