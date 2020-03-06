package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;
/**
 * LinkedList Class.
 *
 * @author Jay Rim
 * @version 2020
 */
public class LinkedList {
    private int size;
    private Node head;
    /**
     * Constructor of linked list class.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    /**
     * Prepends the given parameter data to the start of the node.
     *
     * @param data given parameter object to prepend
     */
    public void prepend(Object data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        size++;
        if (head.getNext() == null) {
            head = newNode;
        }
    }
    /**
     * Appends new data to the end of the node.
     *
     * @param data given parameter object to append
     */
    public void append(Object data) {
        Node newNode = new Node(data);
        if (this.size == 0) {
            prepend(data);
        } else if (head == null) {
            head = newNode;
        } else {
            Node iterator = head;
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
    Node getNodeAtIndex(int index) {
        Node nodeAtIndex = head;
        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.getNext();
        }
        return nodeAtIndex;
    }
    /**
     * Adds a object to a specific index of the LinkedList.
     *
     * @param data object to be added
     * @param index index in integer that specifies the position in linked list
     * @throws IndexOutOfBoundsException throws error if index is out of bound
     */
    public void add(Object data, int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            prepend(data);
        } else {
            Node firstNode = getNodeAtIndex(index - 1);
            Node secondNode = firstNode.getNext();
            Node newNode = new Node(data);
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
     * @throws IndexOutOfBoundsException throws error if index is out of bound
     */
    public Object get(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = getNodeAtIndex(index);
        return temp.getData();
    }
    /**
     * Counts the number of Object data in the linked list when it is equal to
     * the one that is  provided as parameter.
     *
     * @param o Object to count in the linked list
     * @return number of counts in int.
     * @throws IllegalArgumentException throws error message when object is
     *                                  null and unable to proceed
     * @throws EmptyListException       throws error when list to check is empty
     */
    public int count(Object o) throws EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException();
        } else if (size() == 0) {
            throw new EmptyListException("EMPTY LIST\n");
        }
        Node iterator = head;
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
     * Removes a node from LinkedList.
     *
     * @param index index from LinkedList to be removed
     * @return object that was removed
     * @throws IndexOutOfBoundsException throws error if index is out of bound
     */
    public Object remove(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node dataToRemove = null;
        Node temp = head;
        if (index == 0) {
            head = temp.getNext();
            Object dataToReturn = temp.getData();
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
        LinkedList that = (LinkedList) o;
        return size == that.size
                && Objects.equals(head, that.head);
    }
    /**
     * Returns a hash code value for LinkedList.
     *
     * @return a hash code value for LinkedList
     */
    @Override
    public int hashCode() {
        return Objects.hash(size, head);
    }
    /**
     * String representation of LinkedList.
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node temp = head;
        StringBuilder str = new StringBuilder("[");
        while (temp.getNext() != null) {
            str.append(temp.getData()).append(" , ");
            temp = temp.getNext();
        }
        str.append(temp.getData());
        return str + "]";
    }
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.prepend(1);
//        list.prepend(2);
//        System.out.println(list);
//        list.add(3, 1);
//        System.out.println(list);
//        list.append(4);
//        System.out.println(list);
//        Object Igot = list.get(3);
//        System.out.println(Igot);
//        Object Igot2 = list.get(4); outofIndexError
//        list.remove(0);
//        System.out.println(list);
//        int size = list.size();
//        System.out.println("size is = " + size);
//        list.remove(1);
//        System.out.println(list);
//        int size1 = list.size();
//        System.out.println("size is = " + size1);
//        list.prepend(2);
//        System.out.println(list);
//        System.out.println(list);
//        int size2 = list.size();
//        System.out.println("size is = " + size2);
//        list.remove(2);
//        int size3 = list.size();
//        System.out.println("size is = " + size3);
//        list.clear();
//        System.out.println(list);
//        int size4 = list.size();
//        System.out.println("size is = " + size4);
    }
}

