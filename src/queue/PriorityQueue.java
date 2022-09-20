package queue;

import java.util.*;

public class PriorityQueue<T extends Comparable<T>>{

    // The number of elements currently inside heap
    private int heapSize = 0;

    // Internal Capacity of Heap
    private int heapCapacity = 0;

    //A dynamic list to keep track of items in the heap
    private List<T> heap = null;

    /*
    * This Map keeps track of alll the possible values (index
    * value) a node can be found in the heap.Having this mapping
    * let us all implement removal in O(logn) time with some extra
    * space and minor overhead
    * */
    private Map<T, TreeSet<Integer>> positionMap = new HashMap<>();

    // constructs a Priority Queue with an initial Capacity 1
    public PriorityQueue(){
        this(1);
    }

    //constructs a priority Queue with given HeapCapacity
    public PriorityQueue(int heapCapacity){
        heap = new ArrayList<>(heapCapacity);
    }

    // contructions of a heap via heapify process ,
    // Time Complexity O(n)
    public PriorityQueue(T[] elements){
        heapSize = heapCapacity = elements.length;
        heap = new ArrayList<>(heapCapacity);

        //Place all elements in Heap
        for(int i = 0; i < heapSize ; i++){
            mapAdd(elements[i],i);
            heap.add(elements[i]);
        }

        //Heapify process
        for (int i = Math.max(0,(heapSize/2 )-1); i >= 0; i--){
            bubbleDown(i);
        }

    }

    private void bubbleDown(int position) {
    }

    private void mapAdd(T element, int i) {
    }
}
