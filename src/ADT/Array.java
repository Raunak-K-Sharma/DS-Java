package ADT;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
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

    // adds a new elements to dynamic array
    public void add(T element){
        //Time to resize
        if(this.len + 1 >= this.capacity){
            if(this.capacity == 0){
                this.capacity = 1;
            }else{
                //double the size
                this.capacity *= 2;
            }

            T[] newArr = (T[]) new Object[this.capacity];
            //copy the elements from previous array to this double sized array
            for( int i = 0; i < this.len; i ++){
                newArr[i] = arr[i];
            }
            //array will have extra nulls padded
            arr = newArr;

        }

        arr[this.len + 1] = element;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
