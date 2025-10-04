package edu.grinnell.csc207.genericslab;

import java.util.Arrays;

/**
 * An array-based implementation of a list.
 */
public class ArrayList<T>{

    private static final int INITIAL_SIZE = 8;
    private T[] data;
    private int sz;

    /**
     * Constructs a new, empty array list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = (T[])new Object[INITIAL_SIZE];
        this.sz = 0;
    }

    private void ensureCapacity() {
        if (sz == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        ensureCapacity();
        data[sz++] = value;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        } else {
            T ret = data[index];
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            sz -= 1;
            return ret;
        }
    }

    public void intersperese(T sep){
        @SuppressWarnings("unchecked")
        T[] copyOfData = (T[]) new Object[sz];
        copyOfData = Arrays.copyOf(data, data.length);
        //Double the size to ensure we can add elements
        data = Arrays.copyOf(data, data.length * 2);

        for(int i =0; i<sz*2 -2; i+=2){
            data[i] = copyOfData[i/2];
            data[i+1] = sep;
        }
        

        data[sz*2 - 2] = copyOfData[sz-1];
        sz = (sz*2) - 1;
    }

    /**
     * This method cannot be implemented because we don't know if the type T is 
     * int. If T is String type, it cannot have a maximum value.
     * @return UnsupportedOperationException()
     */
    public T maximum(){
        throw new UnsupportedOperationException();
    }

    /**
     * String toString(): returns a string representation of the list in the form: [x1, x2, ..., xk]
     *   where x1, x2, ..., xk are the elements of the list.
     */
    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        if(sz < 1){
            buf.append("]");
        } else {
            buf.append(data[0]);
            for(int i = 1; i < sz; i++){
                buf.append(", ");
                buf.append(data[i]);
            }

            buf.append("]");
        }

        return buf.toString();
    }

    /**
     * This method cannot be implemented because there is no way to "sort" the strings if type T is String.
     */
    public void insertionSort(){
        throw new UnsupportedOperationException();
    }
}
