package linkedList;

import java.util.Iterator;


public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> head = null;
    private Node<T> tail = null;



    public static void main(String[] args) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    //internal node class to form a doubly linked list Node
    private class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data){
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
