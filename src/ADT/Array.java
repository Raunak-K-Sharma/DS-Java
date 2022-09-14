package ADT;

import java.util.Arrays;
import java.util.Iterator;

public class Array<T>  implements Iterable<T> {

    private T [] arr;
    private int len = 0; //length user thinks array is
    private int capacity = 0; //length actually array is

    public Array(){
        this(16);
    }

    public Array (int capacity) {
        if(capacity < 0){
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        this.capacity = capacity;
        this.arr = (T []) new Object[capacity];
    }

    public int size(){
        return this.len;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public T get(int index){
        return arr[index];
    }

    public void set(int index, T element){
        arr[index] = element;
    }

    public void clear(){
        Arrays.fill(arr, null);
        this.len = 0;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
