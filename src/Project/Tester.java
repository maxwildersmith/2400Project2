package Project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Tester {
    public static void main(String[] args) {
        System.out.println("CS 2400  -  Project #2\nProfessor Damavandi\nSubmission by Maximum Wilder-Smith\n\n");
        System.out.println("\nBeginning Task 1....");
        task1();

        System.out.println("\n\nBeginning Task 2....");
        task2();

    }

    /**
     * Runs the required code for Task 2, heaps
     */
    private static void task2() {
        boolean running=true;
        runLoop:
        while (running) {
            System.out.println("\nSelect data entry mode:");
            Integer[][] data = null;
            boolean done = false;
            while (!done) {
                System.out.println("1 - Random data");
                System.out.print("2 - User input\n3 - Exit\nInput number: ");
                Scanner in = new Scanner(System.in);
                try {
                    switch (in.nextInt()) {
                        case 1:
                            data = new Integer[5][];
                            for (int i = 0; i < data.length; i++) {
                                Integer[] tmp = new Integer[18];
                                for (int j = 0; j < tmp.length; j++)
                                    tmp[j] = (int) (Math.random() * 999) + 1;
                                data[i] = removeDuplicates(tmp);
                            }
                            break;
                        case 2:
                            System.out.print("Type numbers with spaces (duplicates will be removed): ");
                            in = new Scanner(System.in);
                            data = new Integer[1][];
                            String[] tmp = in.nextLine().trim().split(" ");
                            data[0] = new Integer[tmp.length];
                            for (int i = 0; i < tmp.length; i++)
                                data[0][i] = Integer.parseInt(tmp[i]);
                            break;
                        case 3:
                            running = false;
                            System.out.println("\n\nHave a nice day!");
                            break runLoop;
                    }
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.println("Enter integers only!");
                }
            }

            assert data != null;
            MaxHeap<Integer>[] optima = new MaxHeap[data.length];
            MaxHeap<Integer>[] seq = new MaxHeap[data.length];
            for (int i = 0; i < data.length; i++) {
                optima[i] = new MaxHeap<>(data[i]);
                seq[i] = new MaxHeap<>();
                for (int j = 0; j < data[i].length; j++)
                    seq[i].add(data[i][j]);
            }

            int optimaAverage = 0, seqAverage = 0;
            System.out.println("Using optimal method: ");
            for (MaxHeap h : optima) {
                System.out.println(h.levelOrder());
                optimaAverage += h.getSwaps();
            }
            System.out.println("Using sequential: ");
            for (MaxHeap h : seq) {
                System.out.println(h.levelOrder());
                seqAverage += h.getSwaps();
            }

            System.out.println("Optimal method average swaps: " + (1.*optimaAverage / data.length) + "\nSequential method swaps: " + (1.*seqAverage / data.length));
        }
    }

    /**
     * Runs the code required for Task 1, BST
     */
    private static void task1(){
        Scanner in = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        /*
         * Some tester values
         * 26 34 19 12 40 51 29 44 77 60 84 11 9 41 36 22 16 15
         * 26 34 19 12 11 9 22 16 15
         */
        boolean running = true;
        reading:
        while(running){
            in=new Scanner(System.in);
            System.out.println("Please enter values:");
            String[] inputs=in.nextLine().trim().split(" ");

            try {
                for (String s : inputs)
                    if(bst.add(Integer.parseInt(s))!=null){
                        bst.clear();
                        System.out.print("Duplication is not allowed!");
                        continue reading;
                    }
                running=false;
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
            try{
                char input = in.next().trim().toLowerCase().charAt(0);


                switch (input){
                    case 'a':
                        System.out.print("Please enter a value to add: ");
                        int val=in.nextInt();
                        if(bst.add(val)!=null)
                            throw new IllegalStateException(val+" already exists! ");
                        System.out.println("In-order: "+bst.inorder());
                        break;
                    case 'r':
                        System.out.print("Please enter a value to remove: ");
                        int target=in.nextInt();
                        if(bst.contains(target)) {
                            bst.remove(target);
                            System.out.println("In-order: " + bst.inorder());
                        } else
                            System.out.println(target+" doesn't exist!");
                        break;
                    case 'e':
                        System.out.println("Exit!");
                        running=false;
                        break;
                    case 'i':
                        System.out.println(bst.inorder());
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage()+" Duplication values are not allowed.");
            } catch (NumberFormatException e) {
                System.out.println("Only enter integer values! ");
            } catch (StringIndexOutOfBoundsException ignored){

            }
        }
    }

    /**
     * A helper method to remove duplicates easily from Integer arrays.
     * @param data The integer array to check.
     * @return An Integer array without duplicated values.
     */
    private static Integer[] removeDuplicates(Integer[] data){
        ArrayList<Integer> tmp = new ArrayList<>();
        for(Integer i:data)
            if(!tmp.contains(i))
                tmp.add(i);
        return tmp.toArray(new Integer[0]);
    }
}
