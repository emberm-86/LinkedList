package com.examples.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Test class.
 *
 * @author Matyas Ember
 */
public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void init() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        linkedList.add(1);

        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));


        linkedList.add(2);

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
    }

    @Test
    public void testAddFirst() {
        linkedList.addFirst(2);

        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(2, (int) linkedList.get(0));


        linkedList.addFirst(1);

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
    }

    @Test
    public void testSize() {
        linkedList.add(1);

        Assert.assertEquals(1, linkedList.size());


        linkedList.add(2);

        Assert.assertEquals(2, linkedList.size());

        IntStream.rangeClosed(3, 4).forEach(linkedList::add);

        Assert.assertEquals(4, linkedList.size());
    }

    @Test
    public void testClear() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        Assert.assertEquals(4, linkedList.size());


        linkedList.clear();

        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testContains() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(2));
        Assert.assertTrue(linkedList.contains(3));
        Assert.assertTrue(linkedList.contains(4));
        Assert.assertFalse(linkedList.contains(-1));
        Assert.assertFalse(linkedList.contains(5));
    }

    @Test
    public void testGet() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
        Assert.assertEquals(3, (int) linkedList.get(2));
        Assert.assertEquals(4, (int) linkedList.get(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetExceptionLessThanZeroIndex() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        linkedList.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetExceptionGreaterThanMaxIndex() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        linkedList.get(5);
    }

    @Test
    public void testGetFirst() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        Assert.assertEquals(1, (int) linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        Assert.assertEquals(4, (int) linkedList.getLast());
    }

    @Test
    public void testIndexOf() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);
        linkedList.add(4);
        linkedList.add(2);

        Assert.assertEquals(0, linkedList.indexOf(1));
        Assert.assertEquals(1, linkedList.indexOf(2));
        Assert.assertEquals(2, linkedList.indexOf(3));
        Assert.assertEquals(3, linkedList.indexOf(4));
        Assert.assertEquals(-1, linkedList.indexOf(5));
    }

    @Test
    public void testLastIndexOf() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);
        linkedList.add(4);
        linkedList.add(2);

        Assert.assertEquals(5, linkedList.lastIndexOf(2));
        Assert.assertEquals(4, linkedList.lastIndexOf(4));
        Assert.assertEquals(2, linkedList.lastIndexOf(3));
        Assert.assertEquals(0, linkedList.lastIndexOf(1));
        Assert.assertEquals(-1, linkedList.lastIndexOf(5));
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testRemove() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);


        Assert.assertEquals(1, (int) linkedList.remove(0));

        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(2, (int) linkedList.get(0));
        Assert.assertEquals(3, (int) linkedList.get(1));
        Assert.assertEquals(4, (int) linkedList.get(2));


        Assert.assertEquals(3, (int) linkedList.remove(1));

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(2, (int) linkedList.get(0));
        Assert.assertEquals(4, (int) linkedList.get(1));


        Assert.assertEquals(4, (int) linkedList.remove(1));

        Assert.assertEquals(1, linkedList.size());


        Assert.assertEquals(2, (int) linkedList.remove(0));

        Assert.assertEquals(0, linkedList.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveExceptionLessThanZeroIndex() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        linkedList.remove(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveExceptionGreaterThanMaxIndex() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        linkedList.remove(-5);
    }

    @Test
    public void testRemoveFirst() {
        IntStream.rangeClosed(1, 2).forEach(linkedList::add);


        linkedList.removeFirst();

        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(2, (int) linkedList.get(0));


        linkedList.removeFirst();

        Assert.assertEquals(0, linkedList.size());


        linkedList.removeFirst();
    }

    @Test
    public void testRemoveLast() {
        IntStream.rangeClosed(1, 2).forEach(linkedList::add);


        linkedList.removeLast();

        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));


        linkedList.removeLast();

        Assert.assertEquals(0, linkedList.size());


        linkedList.removeLast();
    }

    @Test
    public void testRemoveFirstOccurrence() {
        IntStream.rangeClosed(1, 2).forEach(linkedList::add);
        IntStream.rangeClosed(2, 3).forEach(linkedList::add);
        linkedList.add(2);


        boolean resultIsContained = linkedList.removeFirstOccurrence(2);

        Assert.assertTrue(resultIsContained);
        Assert.assertEquals(4, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
        Assert.assertEquals(3, (int) linkedList.get(2));
        Assert.assertEquals(2, (int) linkedList.get(3));


        linkedList.removeFirstOccurrence(2);

        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(3, (int) linkedList.get(1));
        Assert.assertEquals(2, (int) linkedList.get(2));


        linkedList.removeFirstOccurrence(2);

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(3, (int) linkedList.get(1));


        boolean resultIsNotContained = linkedList.removeFirstOccurrence(2);

        Assert.assertFalse(resultIsNotContained);
    }

    @Test
    public void testRemoveLastOccurrence() {
        IntStream.rangeClosed(1, 2).forEach(linkedList::add);
        IntStream.rangeClosed(2, 3).forEach(linkedList::add);
        linkedList.add(2);


        boolean resultIsContained = linkedList.removeLastOccurrence(2);

        Assert.assertTrue(resultIsContained);
        Assert.assertEquals(4, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
        Assert.assertEquals(2, (int) linkedList.get(2));
        Assert.assertEquals(3, (int) linkedList.get(3));


        linkedList.removeLastOccurrence(2);

        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
        Assert.assertEquals(3, (int) linkedList.get(2));


        linkedList.removeLastOccurrence(2);

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(3, (int) linkedList.get(1));


        boolean resultIsNotContained = linkedList.removeLastOccurrence(2);

        Assert.assertFalse(resultIsNotContained);
    }

    @Test
    public void testReverseEvenElementNum() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        linkedList.reverse();

        Assert.assertEquals(4, linkedList.size());
        Assert.assertEquals(4, (int) linkedList.get(0));
        Assert.assertEquals(3, (int) linkedList.get(1));
        Assert.assertEquals(2, (int) linkedList.get(2));
        Assert.assertEquals(1, (int) linkedList.get(3));
    }

    @Test
    public void testReverseOddElementNum() {
        IntStream.rangeClosed(1, 3).forEach(linkedList::add);

        linkedList.reverse();

        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(3, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
        Assert.assertEquals(1, (int) linkedList.get(2));
    }

    @Test
    public void testReverseOneElement() {
        linkedList.add(1);

        linkedList.reverse();

        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
    }

    @Test
    public void testReverseEmpty() {
        linkedList.reverse();

        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void moveLastToFrontEvenElementNum() {
        IntStream.rangeClosed(1, 4).forEach(linkedList::add);

        linkedList.moveLastToFront();

        Assert.assertEquals(4, linkedList.size());
        Assert.assertEquals(4, (int) linkedList.get(0));
        Assert.assertEquals(1, (int) linkedList.get(1));
        Assert.assertEquals(2, (int) linkedList.get(2));
        Assert.assertEquals(3, (int) linkedList.get(3));
    }

    @Test
    public void moveLastToFrontOddElementNum() {
        IntStream.rangeClosed(1, 3).forEach(linkedList::add);

        linkedList.moveLastToFront();

        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(3, (int) linkedList.get(0));
        Assert.assertEquals(1, (int) linkedList.get(1));
        Assert.assertEquals(2, (int) linkedList.get(2));
    }

    @Test
    public void moveLastToFrontOneElement() {
        linkedList.add(1);

        linkedList.moveLastToFront();

        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(1, (int) linkedList.get(0));
    }

    @Test
    public void moveLastToFrontEmpty() {
        linkedList.moveLastToFront();

        Assert.assertEquals(0, linkedList.size());
    }
}
