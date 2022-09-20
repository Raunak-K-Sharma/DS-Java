package queue;

import java.util.List;

public class PriorityQueue<T extends Comparable<T>>{

    // The number of elements currently inside heap
    private int heapSize = 0;

    // Internal Capacity of Heap
    private int heapCapacity = 0;

    //A dynamic list to keep track of items in the heap
    private List<T> heap = null;


}
