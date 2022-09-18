package stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        // checking the base functions
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());

        Stack<Integer> stackOne = new Stack<>(12);
        // checking the base functions
        System.out.println(stackOne.getSize());
        System.out.println(stackOne.isEmpty());

        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());


        
    }

    private final LinkedList<T> stackBaseList = new LinkedList<>();

    //creates an empty stack
    public Stack(){

    }
    
    //creates a stack with firstElement
    public Stack(T firstElement){
        push(firstElement);
    }

    //returns the size of stack
    public int getSize(){
        return stackBaseList.size();
    }

    //checks whether the list is Empty
    public boolean isEmpty(){
        return this.getSize() == 0;
    }
    //push an element to the stack
    public void push(T element) {
        stackBaseList.addLast(element);
    }

    //pops an element from the stack
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stackBaseList.removeLast();
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stackBaseList.peekLast();
    }


    @Override
    public Iterator<T> iterator() {
        return stackBaseList.iterator();
    }
}
