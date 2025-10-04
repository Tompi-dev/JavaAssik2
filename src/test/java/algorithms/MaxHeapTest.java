package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    @Test
    void testInsertAndExtract() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(10, tracker);

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);

        assertEquals(10, heap.extractMax());
        assertEquals(5, heap.extractMax());
        assertEquals(3, heap.extractMax());
    }

    @Test
    void testExtractFromEmptyHeap() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);

        assertThrows(IllegalStateException.class, heap::extractMax);
    }

    @Test
    void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);

        heap.insert(42);
        assertEquals(42, heap.extractMax());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testIncreaseKey() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        heap.increaseKey(2, 30); // increase "5" to "30"
        assertEquals(30, heap.extractMax());
    }

    @Test
    void testIncreaseKeyInvalid() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);

        heap.insert(10);
        assertThrows(IllegalArgumentException.class, () -> heap.increaseKey(0, 5));
    }

    @Test
    void testDuplicates() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);

        heap.insert(7);
        heap.insert(7);
        heap.insert(7);

        assertEquals(7, heap.extractMax());
        assertEquals(7, heap.extractMax());
        assertEquals(7, heap.extractMax());
    }

    @Test
    void testDynamicResizing() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(2, tracker); // starts small


        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);

        assertEquals(4, heap.extractMax());
        assertEquals(3, heap.extractMax());
        assertEquals(2, heap.extractMax());
        assertEquals(1, heap.extractMax());
    }
}
