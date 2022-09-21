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

    // Priority Queue construction O(nlogn)
    public PriorityQueue(Collection<T> elements){
        this(elements.size());
        for (T element : elements){
            add(element);
        }
    }

    // returns true/false depending upon whether Priority queue is
    // Empty
    public boolean isEmpty(){
        return this.heapSize == 0;
    }

    // returns size of the Priority queue
    public int size(){
        return heapSize;
    }
    // clears the whole priority Queue
    public void clear(){
        for (int i = 0; i < heapSize; i++) {
            heap.set(i,null);
        }
        heapSize = 0;
        positionMap.clear();
    }

    /*Returns the value of the element with the lowest priority in
    the priority queue. If the priority queue is Empty null is
    returned O(1)
    * */
    public T peek(){
        if(this.isEmpty())
            return null;
        return heap.get(0);
    }

    // removes the root element O(logn)
    public T poll(){
        return removeAt(0);
    }

    //check if the element is in the heap O(1)
    public boolean contains(T element){
        if (element == null)
            return false;
        return positionMap.containsKey(element);

        /**
         * Linear Scan to check contains
         *  for (int i = 0; i < heapSize; i++) {
     *             if(heap.get(i) == element)
     *                 return true;
     *         }
     *         return false;
         */
    }

    private T removeAt(int indexToRemove) {
        return null;
    }

    // add an element to the priority Queue, the element should not
    // be null
    private void add(T element) {
        if (element == null) throw new IllegalArgumentException();
        if(this.heapSize < this.heapCapacity){
            this.heap.set(heapSize, element);
        }else{
            this.heap.add(element);
            this.heapCapacity += 1;
        }
        mapAdd(element,this.heapSize);
        bubbleUp(this.heapSize);
        
        this.heapSize += 1;
    }

    // compares two index values i <= j
    // assumses i,j are valid indices
    public boolean isLesser(int i , int j){
        T nodeOne = this.heap.get(i);
        T nodeTwo = this.heap.get(j);

        return nodeOne.compareTo(nodeTwo) <= 0 ;
    }

    private void bubbleUp(int heapSize) {
    }

    private void bubbleDown(int position) {
    }

    private void mapAdd(T element, int i) {
    }
}
