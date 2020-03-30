package ca.bcit.comp2522.assignments.a4;

import java.util.Arrays;

/**
 * <p>ArraySet is a resizeable-array implementation of the Set interface. It
 * contains a set of elements in no particular order that excludes duplicates or
 * nulls.</p>
 *
 * <p>Elements may be added to, removed from, and searched for in the ArraySet. As
 * elements are added to the ArraySet its capacity is resized automatically.</p>
 *
 * <p>ArraySet contains a SetIterator that permits access to the elements in the
 * ArraySet one at a time.</p>
 *
 * @param <E> Different element types in ArraySet.
 * @author Jay Rim A01174716
 * @version 2020
 * @invariant The ArraySet never contains duplicate elements.
 * @invariant The ArraySet never contains nulls.
 */

public class ArraySet<E> implements Set<E>, MyIterable<E> {
    /**
     * The integer to use to double the size of the array.
     */
    public static final int DOUBLE_CAPACITY_SIZE = 2;
    /**
     * The initial capacity of the ArraySet.
     */
    public static final int INITIAL_CAPACITY = 10;
    /**
     * The capacity of the ArraySet.
     */
    private int capacity;
    /**
     * The number of elements contained in the ArraySet.
     */
    private int elementCount;
    /**
     * The array buffer that stores the elements of the ArraySet.
     */
    private E[] collection;
    /**
     * Constructs a new empty ArraySet of default initial capacity 10.
     *
     * @pre true
     * @post size() = 0.
     */
    public ArraySet() {
        this.elementCount = 0;
        this.capacity = INITIAL_CAPACITY;
        this.collection = (E[]) new Object[capacity];
    }
    /**
     * Adds the specified element to the ArraySet if it is not already present.
     *
     * @param element The element to be added to the set.
     * @return true if the ArraySet did not already contain the specified
     * element, else false.
     * @pre true
     * @post IF ( element != null AND NOT @pre.contains(element) ) THEN
     * contains(element) ELSE the ArraySet is not changed
     */
    public boolean add(final E element) {
        if (element == null) {
            return false;
        }
        if (contains(element)) {
            return false;
        }
        if (this.elementCount == this.capacity) {
            resize();
        }
        this.collection[elementCount++] = element;
        return true;
    }
    /**
     * Removes the specified element from the ArraySet if it exists.
     *
     * @param element The element to be removed, if present.
     * @return true if element was removed from the ArraySet, else false.
     * @pre true
     * @post IF @pre.contains(element) THEN NOT contains(element) ELSE the
     * ArraySet is not changed
     */
    public boolean remove(final E element) {
        if (element == null) {
            return false;
        }
        if (!contains(element)) {
            return false;
        } else {
            SetIterator<E> removeIt = iterator();
            while (removeIt.hasNext()) {
                E currentElement = removeIt.next();
                if (currentElement.equals(element)) {
                    this.collection[removeIt.iteratorIndex - 1] = this.collection[elementCount - 1];
                    this.collection[elementCount - 1] = null;
                    elementCount--;
                }
            }
            return true;
        }
    }
    /**
     * Removes all elements from the ArraySet. The ArraySet will be empty after
     * this call returns.
     *
     * @pre true
     * @post size() = 0
     */
    public void clear() {
        this.elementCount = 0;
        Arrays.fill(collection, null);
    }
    /**
     * Returns true if this ArraySet contains the specified element.
     *
     * @param element The element to be checked for containment.
     * @return true if element is in the ArraySet, and false otherwise.
     * @pre true
     * @post true
     */
    public boolean contains(final E element) {
        if (element == null) {
            return false;
        }
        SetIterator<E> containsIt = iterator();
        while (containsIt.hasNext()) {
            E currentElement = containsIt.next();
            if (currentElement.equals(element)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the number of elements in the ArraySet (its cardinality).
     *
     * @return The number of elements in the ArraySet.
     * @pre true
     * @post true
     */
    public int size() {
        return this.elementCount;
    }
    /**
     * Doubles the size of the ArraySet.
     *
     * @pre true
     * @post the capacity of the ArraySet is doubled.
     */
    private void resize() {
        this.capacity = this.capacity * DOUBLE_CAPACITY_SIZE;
        this.collection = (E[]) Arrays.copyOf(toArray(), capacity);
//        this.collection = (E[]) Arrays.copyOf(toArray(), capacity * DOUBLE_CAPACITY_SIZE);
    }
    /**
     * Creates and returns an array containing the elements of the ArraySet.
     *
     * @return an unordered array containing the elements of the ArraySet.
     * @pre true
     * @post true
     */
    public Object[] toArray() {
        Object[] objectsToNewArray = new Object[size()];
        if (size() >= 0) {
            System.arraycopy(collection, 0, objectsToNewArray, 0, size());
        }
        return objectsToNewArray;
    }
    /**
     * Returns an iterator over the elements in this ArraySet. The elements are
     * returned in no particular order.
     *
     * @return an iterator for the ArraySet of elements that points to the first
     * element in the ArraySet.
     * @pre true
     * @post true
     */
    public SetIterator<E> iterator() {
        return new SetIterator<>();
    }
    /**
     * SetIterator provides a means for iterating over the elements of an
     * ArraySet.
     */
    private class SetIterator<E> implements MyIterator<E> {
        private int iteratorIndex;
        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements, false otherwise.
         * @pre true
         * @post true
         */
        public boolean hasNext() {
            return elementCount > iteratorIndex;
        }
        /**
         * Returns the next element in the iteration and advances to point to
         * the next.
         *
         * @return the element pointed to by the SetIterator when the method is
         * called.
         * @pre @pre.hasNext()
         * @post SetIterator points to the next element in the ArraySet.
         */
        public E next() {
            if (hasNext()) {
                return (E) collection[iteratorIndex++];
            }
            return null;
        }
    }
}
