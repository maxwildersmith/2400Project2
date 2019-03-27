package Project;

public interface TreeInterface<T> {
    public void add(T entry);
    public T remove(T target);
    public void removeAll (T target);
    public T removeMin();
    public T removeMax();
    public T findMax();
    public T findMin();
}
