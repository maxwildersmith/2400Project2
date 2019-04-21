package Project;

import java.util.Arrays;

@SuppressWarnings({"unchecked", "StringConcatenationInLoop", "WeakerAccess", "unused", "ManualArrayCopy"})
public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T>{
    private T[] data;
    private int index, swapTotal;
    private boolean init;
    private static final int DEFAULT_SIZE=10, MAX_CAPACITY=10000;

    /**
     * Constructor to create a new Max heap of a given size.
     * @param size The starting size for the data array
     */
    public MaxHeap(int size){
        checkCapacity(size);
        data=(T[])(new Comparable[size<DEFAULT_SIZE?DEFAULT_SIZE:size]);
        init=true;
        index=0;
    }

    /**
     * Creates a heap using the optimal data adding method and a certain size.
     * @param size Size of the data array
     * @param startData Data to create with
     */
    public MaxHeap(int size, T[] startData){
        if(size<=startData.length+1)
            size=startData.length*2;
        checkCapacity(size);
        data=(T[])(new Comparable[size<DEFAULT_SIZE?DEFAULT_SIZE:size]);
        init=true;
        index=startData.length;

        for(int i=0; i<startData.length;i++)
            data[i+1]=startData[i];


        for(int i=index/2;i>0;i--)
            swapTotal+=reheap(i);
    }


    /**
     * Creates a new heap with default size and no data.
     */
    public MaxHeap(){
        this(DEFAULT_SIZE);
    }

    /**
     * Creates a new heap with default size and custom data added optimally.
     * @param startData Data to add
     */
    public MaxHeap(T[] startData){
        this(DEFAULT_SIZE, startData);
    }

    /**
     * Reheaps the heap, meaning it resorts a smaller heap at a given root.
     * @param i Root index to start at
     * @return The number of swaps used in the reheap process.
     */
    private int reheap(int i) {
        int swaps=0;
        boolean heaped=false;
        T check=data[i];
        int leftChild=2*i;

        while(!heaped&&leftChild<=index){
            int rightChild=leftChild+1, larger=leftChild;
            if(rightChild<=index&&data[rightChild].compareTo(data[leftChild])>0)
                larger=rightChild;
            if(check.compareTo(data[larger])<0){
                data[i]=data[larger];
                i=larger;
                leftChild=2*i;
                swaps++;
            } else
                heaped=true;
        }
        data[i]=check;
        return swaps;
    }


    /**
     * Checks the capacity and throws an error if the new array is too large, or resizes the data array if need be.
     * @param newCap New capacity to check with
     */
    private void checkCapacity(int newCap){
        if(newCap>MAX_CAPACITY)
            throw new IllegalStateException("New Capacity too large!");
        if(data!=null&&newCap>=data.length)
            data = Arrays.copyOf(data,data.length*2);
    }

    /**
     * Adds a new entry to the MaxHeap.
     *
     * @param entry Entry to add
     */
    public void add(T entry) {
        int swaps=0;
        int newIndex=index+1, parent=newIndex/2;
        checkCapacity(newIndex);

        while (parent>0&&entry.compareTo(data[parent])>0){
            data[newIndex] = data[parent];
            newIndex = parent;
            parent = newIndex/2;
            swaps++;
        }
        data[newIndex] = entry;
        index++;
        swapTotal+=swaps;
    }

    /**
     * Method to get the swap count when created.
     * @return The total swap count.
     */
    public int getSwaps(){
        return swapTotal;
    }

    /**
     * Remove the highest value from the heap.
     *
     * @return The maximum value
     */
    public T removeMax() {
        if(isEmpty())
            return null;
        T output=data[1];
        data[1]=data[index--];
        reheap(1);
        return output;
    }

    /**
     * Checks if the heap contains a certain entry.
     * @param entry The entry to search for
     * @return True if there the entry is in the heap;
     */
    public boolean contains(T entry){
        for(T t:data)
            if(t.compareTo(entry)==0)
                return true;
            return false;
    }

    /**
     * Gets the highest value.
     *
     * @return The maximum value in the heap, null if empty
     */
    public T getMax() {
        if(init&&!isEmpty())
            return data[1];
        return null;
    }

    /**
     * Checks whether the heap is empty or not.
     *
     * @return True if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return index<1;
    }

    /**
     * Gets the size of the heap.
     *
     * @return The size of the heap
     */
    public int getSize() {
        return index;
    }

    /**
     * Removes everything from the heap.
     */
    public void clear() {
        data = (T[])(new Comparable[DEFAULT_SIZE]);
        index=0;
    }

    /**
     * Used to get the level order tree traversal of the heap.
     * @return A String of the level order tree traversal.
     */
    public String levelOrder(){
        String out="";
        for(int i=1;i<=index;i++)
            out+=data[i]+", ";
        return out.substring(0,out.length()-2);
    }
}
