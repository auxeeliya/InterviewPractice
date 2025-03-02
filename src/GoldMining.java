import java.util.*;

public class GoldMining {
    public static int minTransportCost(int n, int k, List<List<Integer>> mines) {
        // Convert to a mutable list and sort by position
        mines = new ArrayList<>(mines);
        mines.sort(Comparator.comparingInt(a -> a.get(0)));

        // Step 1: Compute total gold weight
        int totalGold = mines.stream().mapToInt(m -> m.get(1)).sum();
        int goldPerGroup = totalGold / k;

        // Step 2: Find pickup locations (weighted medians)
        List<Integer> pickupLocations = new ArrayList<>();
        int cumulativeGold = 0;
        int groupGold = 0;
        int groupIndex = 0;

        for (List<Integer> mine : mines) {
            groupGold += mine.get(1);

            // When this group reaches at least half its weight, set median
            if (groupGold >= goldPerGroup / 2) {
                pickupLocations.add(mine.get(0)); // Choose weighted median
                groupGold = 0;  // Reset for next group
                groupIndex++;

                if (groupIndex == k) break; // Stop if all k locations are assigned
            }
        }

        // Step 3: Compute total transport cost
        int totalCost = 0;
        int medianIndex = 0;
        cumulativeGold = 0;

        for (List<Integer> mine : mines) {
            totalCost += Math.abs(mine.get(0) - pickupLocations.get(medianIndex)) * mine.get(1);
            cumulativeGold += mine.get(1);

            // Move to next median if group is fully assigned
            if (medianIndex < k - 1 && cumulativeGold >= (medianIndex + 1) * goldPerGroup) {
                medianIndex++;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int n = 6, k = 2;
        List<List<Integer>> mines = List.of(
            List.of(10, 15),
            List.of(12, 17),
            List.of(16, 18),
            List.of(18, 13),
            List.of(30, 10),
            List.of(32, 1)
        );

        int result = minTransportCost(n, k, mines);
        System.out.println(result); // Expected output: 182
    }
}
