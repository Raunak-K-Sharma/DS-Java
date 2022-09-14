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
            if (this.len >= 0) System.arraycopy(arr, 0, newArr, 0, this.len);
            //array will have extra nulls padded
            arr = newArr;

        }

        arr[this.len + 1] = element;
    }

    // Removes the element present at particular index
    public T removeAt(int removeIndex){
        if(removeIndex >= this.len || removeIndex < 0){
            throw new IndexOutOfBoundsException();
        }
        T removedElementData = arr[removeIndex];
        T[] newArr = (T[]) new Object[this.len-1];
        for(int i = 0, j= 0; i < len ; i++,j++ ){
            //skip over the removedItem index
            if(i == removeIndex){
                j -= 1;
            }else{
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        this.len -= 1;
        this.capacity = this.len;
        return removedElementData;

    }

    public boolean remove(Object element){
        for (int i = 0; i < this.len; i++){
            if(arr[i].equals(element)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
