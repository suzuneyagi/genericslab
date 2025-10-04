package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrayListTests {
    @Test
    public void emptyListTest() {
        ArrayList<Integer> l = new ArrayList<>();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10Nums() {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listAddNegNums() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(-3);
        l.add(-10);
        l.add(-22);
        assertEquals(-3, l.get(0));
        assertEquals(-10, l.get(1));
        assertEquals(-22, l.get(2));
    }

    @Test
    public void listGetSeveral() {
        ArrayList<Integer> l = new ArrayList<>();
        int[] elements = new int[] {3, 8, 7, 2, 6, 5, 0};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetOOB() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(2);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(8);
        l.add(7);
        l.add(1);
        l.add(9);
        
        assertEquals(7, l.remove(2));
        assertEquals(8, l.get(1));
        assertEquals(1, l.get(2));
        
        assertEquals(5, l.remove(0));
        assertEquals(8, l.get(0));

        assertEquals(9, l.remove(2));
        assertEquals(1, l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(8);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }

    @Test
    public void intersperseNonEmpty(){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(6);
        assertEquals(2, l.size());
        l.intersperese(-1);
        assertEquals(3, l.size());
        assertEquals(5, l.get(0));
        assertEquals(-1, l.get(1));
        assertEquals(6, l.get(2));
    }

    @Test
    public void intersperseOneEl(){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(5);
        l.intersperese(-1);
        assertEquals(5, l.get(0));
        assertEquals(1, l.size());
    }

    @Test
    public void toStringEmpty(){
        ArrayList<Integer> l = new ArrayList<>();
        assertEquals("[]", l.toString());
    }

    @Test
    public void toStringFull(){
        ArrayList<String> l = new ArrayList<>();
        l.add("Hi");
        l.add("Hello");
        l.add("Bye");
        assertEquals("[Hi, Hello, Bye]", l.toString());
    }
}
