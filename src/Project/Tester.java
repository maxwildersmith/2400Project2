package Project;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        task1();
    }

    public static void task1(){
        Scanner in = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        boolean running = true;
        while(running){
            System.out.println("Please enter values:");
            String[] inputs=in.nextLine().trim().split(" ");
            try {
                for (String s : inputs)
                    bst.add(Integer.parseInt(s));
                System.out.println(bst.inorder());
                System.out.println(bst.postorder());
                bst.removeMax();
                System.out.println(bst.preorder());
                System.out.println(bst.getNumberOfNodes());
                System.out.println(bst.findMax());
                running=false;
            } catch (IllegalStateException e) {
                System.out.print("Duplication values are not allowed! ");
            } catch (NumberFormatException e) {
                System.out.print("Only enter integer values! ");
            }
            bst.clear();
        }
    }
}
