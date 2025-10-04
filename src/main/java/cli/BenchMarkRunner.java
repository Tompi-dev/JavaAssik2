package cli;

import algorithms.MaxHeap;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {

        int[] sizes;
        if (args.length > 0) {
            sizes = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                sizes[i] = Integer.parseInt(args[i]);
            }
        } else {
            sizes = new int[]{100, 1_000, 10_000, 100_000};
        }

        CsvExporter exporter = new CsvExporter("docs/performance-plots/maxheap_results.csv");
        exporter.writeHeader("N", "Comparisons", "Swaps", "ArrayAccesses", "TimeMs");

        for (int n : sizes) {
            runBenchmark(n, exporter);
        }

        System.out.println(" Benchmark finished. Results saved to docs/performance-plots/maxheap_results.csv");
    }

    private static void runBenchmark(int n, CsvExporter exporter) {
        Random rand = new Random();
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(n, tracker); // constructor with tracker

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(n * 10);
        }

        long start = System.currentTimeMillis();


        for (int value : data) {
            heap.insert(value);
        }


        while (!heap.isEmpty()) {
            heap.extractMax();
        }

        long end = System.currentTimeMillis();
        long elapsed = end - start;

        exporter.appendRow(
                String.valueOf(n),
                String.valueOf(tracker.getComparisons()),
                String.valueOf(tracker.getSwaps()),
                String.valueOf(tracker.getArrayAccesses()),
                String.valueOf(elapsed)
        );
    }
}
