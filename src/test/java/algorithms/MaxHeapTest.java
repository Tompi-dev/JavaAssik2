package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    @Test
    void testInsertAndExtract() {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(5);
        heap.insert(10);
        heap.insert(3);

        assertEquals(10, heap.extractMax());
        assertEquals(5, heap.extractMax());
        assertEquals(3, heap.extractMax());
    }

    @Test
    void testExtractFromEmptyHeap() {
        MaxHeap heap = new MaxHeap(5);
        assertThrows(IllegalStateException.class, heap::extractMax);
    }

    @Test
    void testSingleElement() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(42);
        assertEquals(42, heap.extractMax());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testIncreaseKey() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        heap.increaseKey(2, 30); // increase "5" to "30"
        assertEquals(30, heap.extractMax());
    }

    @Test
    void testIncreaseKeyInvalid() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        assertThrows(IllegalArgumentException.class, () -> heap.increaseKey(0, 5));
    }

    @Test
    void testDuplicates() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(7);
        heap.insert(7);
        heap.insert(7);

        assertEquals(7, heap.extractMax());
        assertEquals(7, heap.extractMax());
        assertEquals(7, heap.extractMax());
    }

    @Test
    void testInsertBeyondCapacity() {
        MaxHeap heap = new MaxHeap(2);
        heap.insert(1);
        heap.insert(2);
        assertThrows(IllegalStateException.class, () -> heap.insert(3));
    }
}
