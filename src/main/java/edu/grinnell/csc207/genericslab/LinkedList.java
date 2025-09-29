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
}
