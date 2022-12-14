package ADT;

import java.util.Arrays;
import java.util.Iterator;


public class DynamicArray {
    public static void main(String[] args) {
        Array<Integer> dynamicArray = new Array<>();
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.size());
        dynamicArray.set(2,44);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.get(2));
        System.out.println(dynamicArray.isEmpty());
        dynamicArray.clear();
        System.out.println(dynamicArray);
        dynamicArray.add(14);
        System.out.println(dynamicArray);
        dynamicArray.add(15);
        dynamicArray.add(19);
        dynamicArray.add(1);
        dynamicArray.add(15);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.remove(15));
        System.out.println(dynamicArray);
        dynamicArray.add(23);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.removeAt(1));
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.contains(34));

    }

}
@SuppressWarnings("unchecked")
class Array<T>  implements Iterable<T> {

    private T [] arr;
    private int len = 0; //length user thinks array is
    private int capacity; //length actually array is

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
        this.len += 1;
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

        arr[this.len] = element;
        this.len += 1;
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
                T result = removeAt(i);
                System.out.println(result);
                return true;
            }
        }
        return false;
    }

    public int getIndexOf(Object element){
        for (int i = 0; i < this.len; i++) {
            if(arr[i].equals(element))
                return i;
        }
        return -1;
    }

    public boolean contains(Object element){
        return getIndexOf(element) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                ", len=" + len +
                ", capacity=" + capacity +
                '}';
    }
}
