package ca.bcit.comp2522.labs.lab06;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * LinkedListGenerics Test
 *
 * @author Jay Rim
 * @version 2020
 */
public class LinkedListGenericsTest<E> {
    private LinkedListGenerics<String> emptyStrList = new LinkedListGenerics<>();
    private LinkedListGenerics<Integer> emptyIntList = new LinkedListGenerics<>();

    private LinkedListGenerics<String> strList = new LinkedListGenerics<>();
    private LinkedListGenerics<Integer> intList = new LinkedListGenerics<>();

    @Before
    public void initiateTestLists() {
        strList.append("B");
        intList.append(1);
    }

    @Test
    public void testPrependIntToIntList() {
        emptyIntList.prepend(1);
        assertEquals((Integer) 1, emptyIntList.get(0));
    }

    @Test
    public void testPrependStringToStrList() {
        strList.prepend("A");
        assertEquals("B", strList.get(1));
    }

    @Test
    public void testAddIntToEmptyIntList() throws IndexOutOfBoundsException {
        emptyIntList.add(2, 0);
        assertEquals((Integer) 2, emptyIntList.get(0));
    }

    @Test
    public void testAddStrToEmptyStrList() throws IndexOutOfBoundsException {
        emptyStrList.add("C", 0);
        assertEquals("C", emptyStrList.get(0));
    }


    @Test
    public void testStrListSize() {
        assertEquals(1, strList.size());
    }



    @Test
    public void testClearEmptyStrList() {
        emptyStrList.clear();
        assertEquals(0, emptyStrList.size());
    }

    @Test
    public void testIntegerFromStrList() {
        assertEquals("B", strList.get(0));
    }

    @Test
    public void testIndexOutOfErrorFromGetMethod() {
        try {
            emptyIntList.get(0);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Test
    public void testGetErrorEmptyStrList() {
        try {
            emptyStrList.get(1);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Test
    public void testAddIntToNegativeIndexToIntList() throws IndexOutOfBoundsException {
        try {
            intList.add(56789, -1);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Test
    public void testClearStrList() {
        emptyIntList.clear();
        assertEquals(0, emptyIntList.size());
    }

    @Test
    public void testClearIntList() {
        intList.clear();
        assertEquals(0, intList.size());
    }

}
