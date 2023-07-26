package Project2AB;

public interface ExtrinsicMinPQ {
    /*
     * Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null.
     */
    void add(int item);

    /* Returns true if the PQ contains the given item. */
    boolean contains(int item);

    /*
     * Returns the minimum item. Throws NoSuchElementException if the PQ is empty.
     */
    int getSmallest();

    /*
     * Removes and returns the minimum item. Throws NoSuchElementException if the PQ
     * is empty.
     */
    int removeSmallest();

    /* Returns the number of items in the PQ. */
    int size();

    /*
     * Changes the priority of the given item. Throws NoSuchElementException if the
     * item
     * doesn't exist.
     */
    void changePriority(int item, int newItem);
}
