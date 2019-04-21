package Project;

@SuppressWarnings("unused")
public interface MaxHeapInterface<T> {
    /**
     * Adds a new entry to the MaxHeap.
     * @param entry Entry to add
     */
    void add(T entry);

    /**
     * Remove the highest value from the heap.
     * @return The maximum value
     */
    T removeMax();

    /**
     * Gets the highest value.
     * @return The maximum value in the heap
     */
    T getMax();

    /**
     * Checks whether the heap is empty or not.
     * @return True if the heap is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the size of the heap.
     * @return The size of the heap
     */
    int getSize();

    /**
     * Removes everything from the heap.
     */
    void clear();
}
