package linkedList;

import java.util.Iterator;


public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;



    public static void main(String[] args) {
            DoublyLinkedList<Integer> doublyLinkedList =
                    new DoublyLinkedList<>();
            doublyLinkedList.addFirst(12);
            doublyLinkedList.addFirst(14);
            doublyLinkedList.printList();
            System.out.println(doublyLinkedList.getSize());
            doublyLinkedList.clear();
            doublyLinkedList.printList();
            doublyLinkedList.addLast(12);
            doublyLinkedList.addLast(14);
            doublyLinkedList.addLast(34);
            doublyLinkedList.printList();
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

    //returns size of the linked list
    public int getSize(){
        return size;
    }

    //returns whether the linked list is Empty or not
    public boolean isEmpty(){
        return this.getSize() == 0;
    }

    public void addFirst(T element){
        if(this.isEmpty()){
            head = new Node<>(element);
        }else{
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        this.size += 1;
    }

    // adds to the last of the list
    public void addLast(T element){
        if (this.isEmpty()){
            addFirst(element);
        }
        else{
            Node<T> traverse = head;
            //traverse till the last element
            while(traverse.next != null){
                traverse = traverse.next;
            }
            Node<T> newNode = new Node<>(element);
            traverse.next = newNode;
            newNode.prev = traverse;
            newNode.next = null;
        }
        this.size += 1;
    }

    public void printList(){
        if(this.isEmpty()){
            System.out.println("List is Empty");
        }
        else{
            Node<T> traverse = head;
            while(traverse.next != null){
                System.out.print(traverse.data);
                System.out.print("<->");
                traverse = traverse.next;
            }
            System.out.println(traverse.data);
        }
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
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
