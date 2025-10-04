import pandas as pd
import matplotlib.pyplot as plt
import os


os.makedirs("docs/performance-plots", exist_ok=True)


df = pd.read_csv("docs/performance-plots/maxheap_results.csv")


plt.style.use("seaborn-v0_8-whitegrid")


plt.figure(figsize=(7, 5))
plt.plot(df["N"], df["TimeMs"], marker="o", color="blue")
plt.xlabel("Input Size (N)")
plt.ylabel("Execution Time (ms)")
plt.title("Time vs Input Size")
plt.grid(True)
plt.tight_layout()
plt.savefig("docs/performance-plots/time_vs_n.png")
plt.close()


plt.figure(figsize=(7, 5))
plt.plot(df["N"], df["Comparisons"], marker="o", color="orange")
plt.xlabel("Input Size (N)")
plt.ylabel("Number of Comparisons")
plt.title("Comparisons vs Input Size")
plt.grid(True)
plt.tight_layout()
plt.savefig("docs/performance-plots/comparisons_vs_n.png")
plt.close()


plt.figure(figsize=(7, 5))
plt.plot(df["N"], df["Swaps"], marker="o", color="green")
plt.xlabel("Input Size (N)")
plt.ylabel("Number of Swaps")
plt.title("Swaps vs Input Size")
plt.grid(True)
plt.tight_layout()
plt.savefig("docs/performance-plots/swaps_vs_n.png")
plt.close()


plt.figure(figsize=(8, 6))
plt.plot(df["N"], df["TimeMs"], marker="o", label="Time (ms)")
plt.plot(df["N"], df["Comparisons"], marker="s", label="Comparisons")
plt.plot(df["N"], df["Swaps"], marker="^", label="Swaps")
plt.yscale("log")
plt.xlabel("Input Size (N)")
plt.ylabel("Operations / Time (log scale)")
plt.title("Combined Performance Metrics (Log Scale)")
plt.legend()
plt.grid(True, which="both", linestyle="--", linewidth=0.7)
plt.tight_layout()
plt.savefig("docs/performance-plots/performance_combined_log.png")
plt.close()

print("All plots generated successfully in docs/performance-plots/")
