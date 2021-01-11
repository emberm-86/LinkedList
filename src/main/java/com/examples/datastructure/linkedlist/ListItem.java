package com.examples.datastructure.linkedlist;

/**
 * ListItem: list element definition.
 *
 * @author Matyas Ember
 */
public class ListItem<T extends Comparable<T>> {

    public T data;

    private ListItem<T> next;

    private ListItem<T> prev;

    public ListItem<T> getPrev() {
        return prev;
    }

    public void setPrev(ListItem<T> prev) {
        this.prev = prev;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    public ListItem(T data) {
        super();
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}