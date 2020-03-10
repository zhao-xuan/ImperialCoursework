/**
 * This class implements a min-heap abstract data type (as described by the
 * generic interface IMinHeap<T extends Comparable<T>>) using a fixed array of
 * size MinHeap.MAXIMUM_HEAP_SIZE.
 */
public class MinHeap<T extends Comparable<T>> implements IMinHeap<T> {
    private int MAXIMUM_HEAP_SIZE;
    private T[] heap;
    private int size;

    public MinHeap(int MAXIMUM_HEAP_SIZE) {
        this.MAXIMUM_HEAP_SIZE = MAXIMUM_HEAP_SIZE;
        this.heap = (T[]) new Comparable[MAXIMUM_HEAP_SIZE];
        size = 0;
    }

    public MinHeap() {
        this(52);
    }

    @Override
    public void add(T element) throws HeapException {
        if (size == MAXIMUM_HEAP_SIZE) {
            throw new HeapException("Reached Maximum Heap Size!");
        }
        heap[size++] = element;
        int index = size - 1;
        int parent = (index - 1) / 2;
        while (heap[index].compareTo(heap[parent]) < 0) {
            T temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    @Override
    public T removeMin() {
        if (size == 0) {
            throw new HeapException("The size is 0!");
        }
        T min = heap[0];
        size--;
        heap[0] = heap[size];
        rebuildHeap(0);
        return min;
    }

    private void rebuildHeap(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left >= size && right >= size) {
            return;
        } else if (right >= size) {
            T temp = heap[index];
            heap[index] = heap[left];
            heap[left] = temp;
            rebuildHeap(left);
        } else {
            int smaller = heap[left].compareTo(heap[right]) < 0 ? left : right;
            T temp = heap[index];
            heap[index] = heap[smaller];
            heap[smaller] = temp;
            rebuildHeap(smaller);
        }
    }

    @Override
    public T getMin() {
        return heap[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}