package edu.grinnell.csc207.genericslab;

public class LinkedList<T> {
    private class Node<T>{
        private T value;
        private Node<T> next;

        private Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }
    }

    public Node<T> first;

    public LinkedList(){
        this.first = null;
        //first = new Node<T>(value, null);
    }

    public void add(T value){
        Node<T> cur = first;
        if(cur == null){
            first = new Node<T>(value, null);
        } else{
            while(cur.next != null){
                cur = cur.next;
            }

            cur.next = new Node<T>(value, null);
        }
    }

    public T get (int index){
        Node<T> cur = first;
        if (cur == null){
            throw new IndexOutOfBoundsException();
        } else if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        else {
            for (int i = 0; i < index; i++){
                if (cur.next == null){
                    throw new IndexOutOfBoundsException();
                }
                cur = cur.next;
            }
            return cur.value;
        }
    }

    public T remove(int index){
        Node<T> cur = first;
        T value;
        if (cur == null){
            throw new IndexOutOfBoundsException();
        } else if (index < 0){
            throw new IndexOutOfBoundsException();
        } else if (index == 0){
            value = first.value;
            first = first.next;
            return value;
        } 
        else {
            for(int i = 0; i < index -1; i++){
                if(cur.next == null){
                    throw new IndexOutOfBoundsException();
                }

                cur = cur.next;
            }

            if(cur.next != null){
                value = cur.next.value;
                cur.next = cur.next.next;
            } else {
                throw new IndexOutOfBoundsException();
            }

            return value;
        }
    }

    public int size(){
        int counter = 0;
        Node<T> cur = first;

        while (cur != null){
            counter++;
            cur = cur.next;
        }

        return counter;
    }
}
