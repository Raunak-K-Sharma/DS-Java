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

        // check for removal from last
        System.out.println(doublyLinkedList.removeLast());
        doublyLinkedList.printList();
        System.out.println(doublyLinkedList.removeFromPosition(2));
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
            head = tail = new Node<>(element);
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
            /* this will take O(n) time
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
            */
            // we will use tail pointer to add to last to do it in
            // O(1)
            Node<T> newNode = new Node<>(element);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
                    newNode.prev = traverse.prev;
                    traverse.prev = newNode;
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
        T data = removedNode.data;
        this.size -= 1;
        // grabage collection
        removedNode.next = null;
        removedNode.prev = null;
        removedNode.data = null;
        return data;
    }

    public T removeLast(){
        if (this.isEmpty()){
            System.out.println("List Is Empty");
            return null;
        }
        Node<T> removedNode = tail;
        tail = tail.prev;
        tail.next = null;
        T data = removedNode.data;
        this.size -= 1;
        return data;
    }

    public T removeFromPosition(int position){
        int indexToRemove = position -1;
        if(indexToRemove > this.size){
            System.out.println("position out of range");
            return null;
        } else if (indexToRemove == this.size) {
            return removeLast();
        } else if (indexToRemove == 0) {
            return removeFirst();
        }else{
               int countIndex = 0;
               Node<T> traverse = head;
               Node<T> removedNode = null;
               while(traverse != null){
                   if(countIndex == indexToRemove){
                       removedNode = traverse;
                       traverse.next.prev = traverse.prev;
                       traverse.prev.next = traverse.next;
                       traverse.next = traverse.prev = null;
                       break;
                   }
                   traverse = traverse.next;
                   countIndex += 1;
               }
            T data = removedNode != null ? removedNode.data : null;
            this.size -= 1;
            // garbage cleaning

            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> traverse = head;
            @Override
            public boolean hasNext() {
                return traverse != null;
            }

            @Override
            public T next() {
                T data = traverse.data;
                traverse = traverse.next;
                return data;
            }
        };
    }

    //internal node class to form a doubly linked list Node
    private static class Node<T> {
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
