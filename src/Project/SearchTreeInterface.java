package Project;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface SearchTreeInterface<T> {
    /**
     * Trys to add an entry to the tree if it isn't already present. If the entry is present, return that entry.
     * @param entry The entry to add to the BST
     * @return null if added successfully, the preexisting entry if it exists.
     */
    Node<T> add(T entry);

    /**
     * Removes a given entry from the tree, and returns the entry returns null if it can't find it.
     * @param target entry to remove
     * @return The object removed, or null if the object isn't present
     */
    Node<T> remove(T target);

    /**
     * Returns the top node's data.
     * @return the root node's data value.
     */
    T getRootData();

    /**
     * Returns whether the tree is empty or not.
     * @return true if the tree is empty, false if not.
     */
    boolean isEmpty();

    /**
     * Clears the data in the tree.
     */
    void clear();
}
