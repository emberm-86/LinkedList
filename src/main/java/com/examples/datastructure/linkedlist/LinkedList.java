package com.examples.datastructure.linkedlist;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Generic linked list operations:
 * <p>
 * Some basic operations from java.util.LinkedList
 * <p>
 * add
 * addFirst
 * addLast
 * clear
 * contains
 * get
 * getFirst
 * getLast
 * indexOf
 * isEmpty
 * lastIndexOf
 * remove
 * removeFirst
 * removeFirstOccurrence
 * removeLast
 * removeLastOccurrence
 * size
 * <p>
 * Bonus operations:
 * reverse
 * moveLastToFront
 *
 * @author Matyas Ember
 */

public class LinkedList<T extends Comparable<T>> {

    private ListItem<T> header = null;

    public boolean add(T value) {
        ListItem<T> item = new ListItem<>(value);

        if (header == null) {
            header = item;
            return true;
        }

        ListItem<T> act = header;

        while (act.getNext() != null) {
            act = act.getNext();
        }

        act.setNext(item);
        item.setPrev(act);

        return true;
    }

    public void addFirst(T value) {
        ListItem<T> item = new ListItem<>(value);
        item.setNext(header);
        header = item;
    }

    public void addLast(T value) {
        add(value);
    }

    public void clear() {
        while (header != null) {
            removeFirst();
        }
    }

    public boolean contains(T value) {
        ListItem<T> act = header;

        while (act != null && !act.getData().equals(value)) {
            act = act.getNext();
        }

        return act != null;
    }

    public T get(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int i = 0;

        ListItem<T> act = header;

        while (act != null && i < index) {
            act = act.getNext();

            if (act != null) {
                i++;
            }
        }

        if (index > i) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return act != null ? act.getData() : null;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size() - 1);
    }

    public int indexOf(T value) {
        ListItem<T> act = header;

        int i = 0;

        while (act != null && !act.getData().equals(value)) {
            act = act.getNext();
            i++;
        }

        return act != null ? i : -1;
    }

    public boolean isEmpty() {
        return header == null;
    }

    public int lastIndexOf(T value) {
        ListItem<T> act = header;

        if (act == null) {
            return -1;
        }

        int i = 0;

        while (act.getNext() != null) {
            act = act.getNext();
            i++;
        }

        while (act != null && !act.getData().equals(value)) {
            act = act.getPrev();
            i--;
        }

        return act != null ? i : -1;
    }


    public T remove(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int i = 0;

        ListItem<T> act = header;

        while (act != null && i < index) {
            act = act.getNext();
            i++;
        }

        if (index - 1 > i) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (act == null) {
            return null;
        }

        linkOutListItem(act);

        return act.getData();
    }

    public void removeFirst() {
        if (header == null) {
            return;
        }

        ListItem<T> next = header.getNext();

        if (next != null) {
            next.setPrev(null);
        }

        header.setNext(null);
        header = next;
    }

    public boolean removeFirstOccurrence(T value) {
        ListItem<T> act = header;

        while (act != null && !act.getData().equals(value)) {
            act = act.getNext();
        }

        if (act == null) {
            return false;
        }

        linkOutListItem(act);

        return true;
    }

    public void removeLast() {
        if (header == null) {
            return;
        }

        ListItem<T> act = header;

        while (act.getNext() != null) {
            act = act.getNext();
        }

        ListItem<T> prev = act.getPrev();

        if (prev != null) {
            prev.setNext(null);
        } else {
            header = null;
        }

        act.setPrev(null);
    }

    public boolean removeLastOccurrence(T value) {
        ListItem<T> act = header;

        if (act == null) {
            return false;
        }

        while (act.getNext() != null) {
            act = act.getNext();
        }

        while (act != null && !act.getData().equals(value)) {
            act = act.getPrev();
        }

        if (act == null) {
            return false;
        }

        linkOutListItem(act);

        return true;
    }

    private void linkOutListItem(ListItem<T> item) {
        if (item == null) {
            return;
        }

        ListItem<T> prev = item.getPrev();
        ListItem<T> next = item.getNext();

        if (prev != null) {
            prev.setNext(next);
        } else {
            header = next;
        }

        if (next != null) {
            next.setPrev(prev);
        }

        item.setPrev(null);
        item.setNext(null);
    }

    public int size() {
        int i = 0;

        ListItem<T> act = header;

        while (act != null) {
            act = act.getNext();
            i++;
        }

        return i;
    }

    public void moveLastToFront() {
        if (header == null || header.getNext() == null) {
            return;
        }

        ListItem<T> act = header;

        while (act.getNext() != null) {
            act = act.getNext();
        }

        act.getPrev().setNext(null);
        act.setPrev(null);
        act.setNext(header);

        header.setPrev(act);
        header = act;
    }

    public void reverse() {
        if (header == null) {
            return;
        }

        ListItem<T> next = header.getNext();
        header.setNext(header.getPrev());
        header.setPrev(next);

        if (next != null) {
            header = next;
            reverse();
        }
    }

    public void print() {
        System.out.println();

        ListItem<T> act = header;

        while (act != null) {
            System.out.print(act.getData() + " ");
            act = act.getNext();
        }
    }

    public void printWithMethodCall(Runnable method) {
        method.run();
        print();
    }

    public void printWithMethodCall(Consumer<T> method, T value) {
        method.accept(value);
        print();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        IntStream.rangeClosed(1, 15).forEach(linkedList::add);
        System.out.print(linkedList.size());
        linkedList.print();

        linkedList.printWithMethodCall(linkedList::reverse);

        linkedList.printWithMethodCall(linkedList::moveLastToFront);

        linkedList.removeFirstOccurrence(1);
        linkedList.removeFirstOccurrence(15);
        linkedList.printWithMethodCall(linkedList::removeFirstOccurrence, 10);

        linkedList.printWithMethodCall(linkedList::addFirst, 16);

        linkedList.printWithMethodCall(linkedList::removeFirst);

        linkedList.printWithMethodCall(linkedList::removeLast);

        System.out.print(" \n" + linkedList.get(10));
        System.out.print(" \n" + linkedList.getFirst());
        System.out.print(" \n" + linkedList.getLast());

        linkedList.addFirst(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.print();

        linkedList.removeFirstOccurrence(2);
        linkedList.removeFirstOccurrence(2);
        linkedList.removeLastOccurrence(2);
        linkedList.print();

        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.print();

        linkedList.printWithMethodCall(linkedList::reverse);

        linkedList.remove(5);
        linkedList.print();

        System.out.print(" \n" + linkedList.indexOf(2));

        System.out.print(" \n" + linkedList.lastIndexOf(14));
    }
}