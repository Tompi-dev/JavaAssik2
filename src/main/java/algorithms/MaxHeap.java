package algorithms;

import metrics.PerformanceTracker;

public class MaxHeap {
    private int[] heap;
    private int size;
    private PerformanceTracker tracker;

    public MaxHeap(int capacity, PerformanceTracker tracker) {
        this.heap = new int[capacity];
        this.size = 0;
        this.tracker = tracker;
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDownOptimized(0);
        return max;
    }

    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        if (newValue < heap[index]) {
            throw new IllegalArgumentException("New value must be >= current value");
        }
        heap[index] = newValue;
        heapifyUp(index);
    }

    // 🔹 Optimized heapifyDown (fewer swaps)
    private void heapifyDownOptimized(int index) {
        int temp = heap[index];
        int child;

        while ((child = leftChild(index)) < size) {
            tracker.incComparisons(); // child comparison
            if (child + 1 < size) {
                tracker.incComparisons();
                if (heap[child + 1] > heap[child]) {
                    child++;
                }
            }

            tracker.incComparisons();
            if (heap[child] > temp) {
                tracker.incArrayAccesses(2);
                heap[index] = heap[child]; // move child up instead of swap
                index = child;
            } else {
                break;
            }
        }

        heap[index] = temp;
        tracker.incArrayAccesses(1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            tracker.incComparisons();
            int parentIndex = (index - 1) / 2;
            tracker.incArrayAccesses(2);
            if (heap[parentIndex] < heap[index]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else break;
        }
    }

    private void swap(int i, int j) {
        tracker.incSwaps();
        tracker.incArrayAccesses(2);
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 🔹 Dynamic resizing
    private void ensureCapacity() {
        if (size >= heap.length) {
            int newCapacity = heap.length * 2;
            int[] newHeap = new int[newCapacity];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
            System.out.println("Resized heap to " + newCapacity);
        }
    }

    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
