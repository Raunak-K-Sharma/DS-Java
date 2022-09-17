package linkedList;

import java.util.Iterator;


public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;



    public static void main(String[] args) {

    }

    //Empty the doublu linked list
    public void clear(){
        Node<T> traverse = head;
        while(traverse != null){
            Node<T> nextNode = traverse.next;
            traverse.prev = traverse.next = null;
            traverse.data = null;
            traverse = nextNode;
        }
        head = tail = null;
        size = 0;

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
