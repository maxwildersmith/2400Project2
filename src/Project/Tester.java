package Project;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        task1();
    }

    public static void task1(){
        Scanner in = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();


        /**
         * 26 34 19 12 40 51 29 44 77 60 84 11 9 41 36 22 16 15
         * 26 34 19 12 11 9 22 16 15
         */
        boolean running = true;
        while(running){
            System.out.println("Please enter values:");
            String[] inputs=in.nextLine().trim().split(" ");
            running=false;

            try {
                for (String s : inputs)
                    bst.add(Integer.parseInt(s));
            } catch (IllegalStateException e) {
                System.out.print("Duplication values are not allowed! ");
            } catch (NumberFormatException e) {
                System.out.print("Only enter integer values! ");
            }
        }

        System.out.println("Pre-order: "+bst.preorder());
        System.out.println("In-order: "+bst.inorder());
        System.out.println("Pre-order: "+bst.postorder());
        System.out.println("Main Menu\nA: Add a value\nR: Remove a value\nE: Exit the program");

        running=true;
        while(running){
            System.out.print("What command would you like to run? ");

            char input = in.nextLine().trim().toLowerCase().charAt(0);

            try{
                switch (input){
                    case 'a':
                        System.out.print("Please enter a value to add: ");
                        bst.add(in.nextInt());
                        System.out.print("In-order: "+bst.inorder());
                        break;
                    case 'r':
                        System.out.print("Please enter a value to remove: ");
                        bst.remove(in.nextInt());
                        System.out.println("In-order: "+bst.inorder());
                        break;
                    case 'e':
                        System.out.println("Exit!");
                        running=false;
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage()+" Duplication values are not allowed.");
            } catch (NumberFormatException e) {
                System.out.println("Only enter integer values! ");
            }
        }
    }
}
