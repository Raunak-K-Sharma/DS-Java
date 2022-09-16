package linkedList;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    public static void main(String[] args) {
            SingleLinkedList<Integer> testList = new SingleLinkedList<>();
            //check add last
            testList.addLast(1);
            testList.add(3);
            //prints list
            testList.printList();
            //check add first
            testList.addFirst(34);
            testList.printList();
            //check empty
            testList.clear();
            testList.printList();
            // add at a particular position
            testList.addAtPosition(12,2);
            System.out.println(testList.isEmpty());
            testList.addAtPosition(12,1);
            testList.addAtPosition(24,2);
            testList.addAtPosition(34,2);
            testList.addAtPosition(84,2);
            testList.printList();
            //remove First
            System.out.println(testList.removeFirst());
            testList.printList();
            // remove last
            System.out.println(testList.removeLast());
            testList.printList();
            // add to check remove at position
            testList.add(13);
            testList.add(23);
            testList.add(14);
            testList.printList();
    }

    public SingleLinkedList(){

    }

    //clear the entire linked list
    public void clear(){
        Node<T> traverse = head;
        while(traverse != null){
            Node<T> next = traverse.next;
            traverse.next = null;
            traverse.data = null;
            traverse = next;
        }

        head = null;
        size = 0;

    }

    //returns size of linked list
    public int size() {
        return this.size;
    }

    //checks whether linked list is empty?
    public boolean isEmpty(){
        return this.size() == 0;
    }

    //adds element to linked list
    public void add(T element){
       this.addLast(element);
    }

    // adds an element to start of linked list
    public void addFirst(T element){
        if(this.isEmpty()){
            head = new Node<>(element);
        }else{
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        }
        this.size += 1;
    }

    //add element to last of linked list
    public void addLast(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
        } else {
            Node<T> traverse = head;
            while (traverse.next != null) {
                traverse = traverse.next;
            }
            traverse.next = new Node<>(element);
        }
        this.size += 1;
    }

    public void printList(){

        if(isEmpty()){
            System.out.println("List is Empty");
        }
        else{
            Node<T> traverse = head;
            while(traverse.next != null){
                System.out.print(traverse.data);
                System.out.print("->");
                traverse = traverse.next;
            }
            System.out.println(traverse.data);
        }
    }

    public void addAtPosition(T element, int position)
    {
        int indexToInsert = position - 1;
        if(indexToInsert > this.size()){
            System.out.println("position not present in list");
        }
        else if (indexToInsert == this.size()){
            addLast(element);
        }else{
            int countIndex = 0;
            Node<T> traverse = head;
            while(traverse != null){

                if(countIndex == indexToInsert){
                    Node<T> newNode = new Node<>(element);
                    newNode.next = traverse.next;
                    traverse.next = newNode;
                    this.size += 1;
                    break;
                }
                traverse = traverse.next;
                countIndex += 1;
            }

        }
    }

    public T removeFirst(){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return null;
        }else{
            Node<T> removedNode = head;
            head = head.next;
            this.size -= 1;
            removedNode.next = null;
            return removedNode.data;
        }

    }
    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Empty List");
            return null;
        } else {
            Node<T> traverse = head;
            while (traverse.next.next!= null) {
                traverse = traverse.next;
            }
            Node<T> removedNode = traverse.next;
            traverse.next = null;
            this.size += 1;
            return removedNode.data;

        }

    }

    public T removeFromPosition(int position){
        int indexToRemove = position -1;

        if (isEmpty()){
            System.out.println("List is Empty");
            return null;
        } else if (indexToRemove > this.size()) {
            System.out.println("Position out of Range");
            return null;
        }else  if(indexToRemove == this.size()){
            return removeLast();
        } else if (indexToRemove == 0) {
            return removeFirst();
        }
        else{
            int countIndex = 0;
            Node<T> traverse = head;
            Node<T> prev= head;
            Node<T> removedNode = null;
            while(traverse.next != null){

                if(countIndex == indexToRemove){
                    removedNode = traverse;
                    prev.next = traverse.next;
                    traverse.next = null;
                    this.size -= 1;
                    break;
                }
                prev = traverse;
                traverse = traverse.next;
                countIndex += 1;
            }
            return removedNode != null ? removedNode.data : null;
        }
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
