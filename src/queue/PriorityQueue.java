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

    // contructions of a heap via heapify process
}
