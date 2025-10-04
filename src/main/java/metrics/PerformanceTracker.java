package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;

<<<<<<< HEAD

=======
    // Incrementers
>>>>>>> feature/metrics
    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incArrayAccesses(int count) { arrayAccesses += count; }

<<<<<<< HEAD

=======
    // Getters
>>>>>>> feature/metrics
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

<<<<<<< HEAD

=======
    // Reset stats
>>>>>>> feature/metrics
    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }

<<<<<<< HEAD

=======
    // Summary string
>>>>>>> feature/metrics
    public String report() {
        return "Comparisons=" + comparisons +
                ", Swaps=" + swaps +
                ", ArrayAccesses=" + arrayAccesses;
    }
}
