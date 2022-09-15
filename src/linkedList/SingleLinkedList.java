package linkedList;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;
    public static void main(String[] args) {

    }

    public SingleLinkedList(){

    }

    //clear the entire linked list
    public void clear(){

    }

    public static void addNode(Object element){

    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

class Node<T> {
    public T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}
