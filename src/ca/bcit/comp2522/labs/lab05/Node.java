package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;
/**
 * Node class.
 *
 * @author Jay Rim
 * @version 2020
 */
public class Node {
    private Object data;
    private Node next;
    /**
     * Constructs a new node using object as data.
     *
     * @param object given parameter of object to use as data when constructing a node.
     */
    public Node(final Object object) {
        this.data = object;
        this.next = null;
    }
    /**
     * Gets data from node.
     *
     * @return data got from node
     */
    public Object getData() {
        return data;
    }
    /**
     * Sets data as given parameter.
     * @param data new data to be set
     */
    public void setData(Object data) {
        this.data = data;
    }
    /**
     * Gets next node from node.
     *
     * @return next from node
     */
    public Node getNext() {
        return next;
    }
    /**
     * Sets next as given parameter.
     * @param next new next to be set
     */
    public void setNext(Node next) {
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
        Node node = (Node) o;
        return Objects.equals(data, node.data)
                &&
                Objects.equals(next, node.next);
    }
    /**
     * Returns a hash code value for Node.
     *
     * @return a hash code value for Node
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
        return "Node{"
                + "data="
                + data
                + ", next="
                + next
                +
                '}';
    }
}
