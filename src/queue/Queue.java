package queue;

import java.util.Iterator;
import java.util.LinkedList;

// implementing a Queue using a linked list
public class Queue<T> implements Iterable<T> {

    private final LinkedList<T> linkedListBasedQueue = new LinkedList<>();

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        //checks for basic working queue
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        Queue<Integer> queueOne = new Queue<>(12);
        //checks for basic working queue
        System.out.println(queueOne.size());
        System.out.println(queueOne.isEmpty());

    }

    // normal constructor
    public Queue () {

    }

    //parametrized constructor
    public Queue( T firstElement) {
        enqueue(firstElement);
    }

    //returns size of the queue
    public int size(){
        return linkedListBasedQueue.size();
    }

    //returns whether queue is empty or not
    public boolean isEmpty(){
        return this.size() == 0;
    }

    // adds the lement to the last of the queue
    public void enqueue(T element) {
        linkedListBasedQueue.addLast(element);
    }

    //removes the element from start of the queue
    public T dequeue(T element){
       return linkedListBasedQueue.removeFirst();
    }

    // peeks the fromt of the queue
    public T peek(){
        return linkedListBasedQueue.peek();
    }

    @Override
    public Iterator<T> iterator() {
        return linkedListBasedQueue.iterator();
    }
}
