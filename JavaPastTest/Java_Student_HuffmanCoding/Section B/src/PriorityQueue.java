import java.util.Arrays;

public class PriorityQueue<E extends Comparable<E>> implements PriorityQueueInterface<E>{

	public E[] items;    //a heap of HuffmanTrees
	private final static int max_size = 256;
	private int size;    //number of HuffManTrees in the heap.


    public PriorityQueue( ) {
        // constructor which creates an empty heap
		items = (E[]) new Comparable[max_size];
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}

	public E getMin(){
		E root = null;
		if (!isEmpty()) root = items[0];
		return root;
	}
	
	public void add(E newEntry) throws PriorityQueueException{
	// post: Adds a new entry to the priority queue according to 
        // the priority value.
	    if (newEntry == null) {
	        return;
        }
	    items[size++] = newEntry;

	    int index = size - 1;
	    int parent = (index - 1) / 2;
		while (items[index].compareTo(items[parent]) < 0) {
			E temp = items[index];
			items[index] = items[parent];
			items[parent] = temp;
			index = parent;
			parent = (index - 1) / 2;
		}
	}
 				
 	public E removeMin(){
	// post: Removes the minimum valued item from the PriorityQueue
		E root = null;
		if (!isEmpty()){
			root = items[0];
			items[0] = items[size-1];
			size--;
			heapRebuild(0);
		}
		return root;
	}
	
	private void heapRebuild(int root){
	    // Rebuild heap to keep it ordered
		int left = 2*root+1;
		int right = 2*root+2;
		int smaller;

		if (left >= size && right >= size) {return;}
		else if (right >= size) {smaller = left;}
		else {smaller = items[left].compareTo(items[right]) < 0 ? left : right;}

        if (items[root].compareTo(items[smaller]) > 0) {
			E temp = items[root];
			items[root] = items[smaller];
			items[smaller] = temp;
			heapRebuild(smaller);
		}
	}

	@Override
	public String toString() {
		return "Heap(" + Arrays.toString(Arrays.copyOfRange(items, 0, size)) + ")";
	}
}
