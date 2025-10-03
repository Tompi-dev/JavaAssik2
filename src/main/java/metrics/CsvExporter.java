package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class CsvExporter {
    private final String fileName;

    public CsvExporter(String fileName) {
        this.fileName = fileName;
    }

    // Write header row (e.g. "N,Comparisons,Swaps,TimeMs")
    public void writeHeader(String... headers) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.append(String.join(",", headers));
            writer.append("\n");
        } catch (IOException e) {
            System.err.println("Error writing CSV header: " + e.getMessage());
        }
    }

    // Append one row of results
    public void appendRow(String... values) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(String.join(",", values));
            writer.append("\n");
        } catch (IOException e) {
            System.err.println("Error writing CSV row: " + e.getMessage());
        }
    }
}
