package linkedList;

import java.util.Iterator;


public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;



    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList =
                new DoublyLinkedList<>();
        // adding at first
        doublyLinkedList.addFirst(12);
        doublyLinkedList.addFirst(14);
        doublyLinkedList.printList();
        doublyLinkedList.clear();
        System.out.println(doublyLinkedList.getSize());
        doublyLinkedList.printList();
        // adding at last
        doublyLinkedList.addLast(12);
        doublyLinkedList.addLast(14);
        doublyLinkedList.addLast(34);
        doublyLinkedList.printList();

        // testing add at different positions
        doublyLinkedList.addAtPosition(23,2);
        // adding at start
        doublyLinkedList.addAtPosition(45,1);
        //adding just preious last
        doublyLinkedList.addAtPosition(67, doublyLinkedList.getSize());
        //adding at last
        doublyLinkedList.addAtPosition(88,
                doublyLinkedList.getSize() + 1);
        doublyLinkedList.printList();

        //check for removal from list
        System.out.println(doublyLinkedList.removeFirst());
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
            this.size += 1;
        }
    }

    public void addAtPosition(T element, int position){
        int indexToInsert = position - 1;
        if(indexToInsert > this.getSize()){
            System.out.println("Position not present in list");
        } else if (indexToInsert == this.getSize() ) {
            addLast(element);
        } else if (indexToInsert == 0) {
            addFirst(element);
        } else{
            int countIndex = 0;
            Node<T> traverse = head;
            while(traverse != null){
                if(countIndex == indexToInsert){
                    Node<T> newNode = new Node<>(element);
                    newNode.next = traverse;
                    traverse.prev.next = newNode;
                    traverse.prev = newNode;
                    newNode.prev = traverse.prev;
                    this.size += 1;
                    break;
                }
                traverse = traverse.next;
                countIndex += 1;
            }
        }
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

    //removes from start of the list
    public T removeFirst(){
        if (this.isEmpty()){
            System.out.println("List Is Empty");
            return null;
        }
        Node<T> removedNode = head;
        head  = head.next;
        head.prev = null;
        removedNode.next = null;
        return removedNode.data;
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
