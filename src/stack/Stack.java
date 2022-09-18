package stack;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

    public static void main(String[] args) {
        
    }

    private LinkedList<T> stackBaseList = new LinkedList<>();

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
    private void push(T firstElement) {
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
