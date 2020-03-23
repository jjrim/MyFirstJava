package ca.bcit.comp2522.labs.lab06;

import java.util.Objects;


/**
 * LinkedListGenerics Class.
 *
 * @author Jay Rim
 * @version 2020
 * @param <E> different types of data types
 */
public class LinkedListGenerics<E> {

    private NodeGenerics<E> head;
    private int size;

    /**
     * Constructor of linked list class.
     */
    public LinkedListGenerics() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Prepends the given parameter data to the start of the node.
     *
     * @param data given parameter object to prepend
     */
    public void prepend(E data) {
        NodeGenerics<E> newNode = new NodeGenerics<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
        if (head.getNext() == null) {
            newNode.setNext(head);
        }
    }

    /**
     * Appends new data to the end of the node.
     *
     * @param data given parameter object to append
     */
    public void append(E data) {
        NodeGenerics<E> newNode = new NodeGenerics<>(data);
        if (this.size == 0) {
            prepend(data);
        } else if (head == null) {
            head = newNode;
        } else {
            NodeGenerics<E> iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
            size++;
        }
    }

    /**
     * Gets a node from a specified index.
     *
     * @param index index in integer that specifies the position in linked list
     * @return Node of the index of linked list
     */
    NodeGenerics<E> getNodeAtIndex(int index) {
        NodeGenerics<E> nodeAtIndex = head;
        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.getNext();
        }
        return nodeAtIndex;
    }

    /**
     * Adds a object to a specific index of the LinkedList.
     *
     * @param data  object to be added
     * @param index index in integer that specifies the position in linked list
     */
    public void add(E data, int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            prepend(data);
        } else {
            NodeGenerics<E> firstNode = getNodeAtIndex(index - 1);
            NodeGenerics<E> secondNode = firstNode.getNext();
            NodeGenerics<E> newNode = new NodeGenerics<>(data);
            firstNode.setNext(newNode);
            newNode.setNext(secondNode);
            size++;
            if (newNode.getNext() == null) {
                head = newNode;
            }
        }
    }

    /**
     * Get the current size of the linked list.
     *
     * @return size of linked list as integer
     */
    public int size() {
        return size;
    }

    /**
     * Clears the current linked list.
     * Makes size 0 as well.
     */
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    /**
     * gets a object from index.
     *
     * @param index index from LinkedList to be removed
     * @return object that was removed
     */
    public E get(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        NodeGenerics<E> temp = getNodeAtIndex(index);
        return temp.getData();
    }

    /**
     * Counts the number of Object data in the linked list when it is equal to
     * the one that is  provided as parameter.
     *
     * @param o Object to count in the linked list
     * @return number of counts in int.
     * @throws EmptyListException when size is zero
     */
    public int count(E o) throws EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException();
        } else if (size() == 0) {
            throw new EmptyListException("empty list\n");
        }
        NodeGenerics<E> iterator = head;
        int count = 0;
        while (iterator != null) {
            if (iterator.getData().equals(o)) {
                count++;
            }
            iterator = iterator.getNext();
        }
        return count;
    }

    /**
     * Removes a nodeGenerics from LinkedList.
     *
     * @param index index from LinkedList to be removed
     * @return object that was removed
     */
    public E remove(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        NodeGenerics<E> dataToRemove = null;

        NodeGenerics<E> temp = head;
        if (index == 0) {
            head = temp.getNext();
            E dataToReturn = temp.getData();
            size--;
            return dataToReturn;
        } else {
            size--;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            dataToRemove = temp.getNext();
            temp.setNext(dataToRemove.getNext());
        }
        return dataToRemove.getData();
    }

    /**
     * Represents NodeGenerics inner class.
     */
    private static final class NodeGenerics<E> {
        private E data;
        private NodeGenerics<E> next;

        /**
         * Constructs a new NodeGenerics using object as data.
         *
         * @param data E as given parameter of object to use as data when constructing a node.
         */
        private NodeGenerics(final E data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Gets data from node.
         *
         * @return data got from node
         */
        public E getData() {
            return data;
        }

        /**
         * Sets data as given parameter.
         *
         * @param data new data to be set
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Gets next node from node.
         *
         * @return next from node
         */
        public NodeGenerics<E> getNext() {
            return next;
        }

        /**
         * Sets next as given parameter.
         *
         * @param next new next to be set
         */
        public void setNext(NodeGenerics<E> next) {
            this.next = next;
        }

        /**
         * Returns true if the specified obj is same as Node object.
         *
         * @param o the reference object to be compared
         * @return true if object is same as the o argument, else false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NodeGenerics<?> that = (NodeGenerics<?>) o;
            return Objects.equals(data, that.data)
                    && Objects.equals(next, that.next);
        }

        /**
         * Returns a hash code value for NodeGenerics.
         *
         * @return a hash code value for NodeGenerics
         */
        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }


        /**
         * String representation of Node.
         *
         * @return toString a String representation
         */
        @Override
        public String toString() {
            return "NodeGenerics{"
                    +
                    "data=" + data
                    +
                    ", next=" + next
                    +
                    '}';
        }

    }

    /**
     * Returns true if the specified obj is same as LinkedList object.
     *
     * @param o the reference object to be compared
     * @return true if object is same as the o argument, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedListGenerics<?> that = (LinkedListGenerics<?>) o;
        return size == that.size
                &&
                Objects.equals(head, that.head);
    }

    /**
     * Returns a hash code value for LinkedListGenerics.
     *
     * @return a hash code value for LinkedListGenerics
     */
    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    /**
     * String representation of LinkedListGenerics.
     *
     * @return toString a String representation
     */




}
