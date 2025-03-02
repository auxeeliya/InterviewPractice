import java.util.*;
import java.util.stream.Collectors;

public class AmazonTransLogs {
    public static List<Integer> findCustomersWithMinTransactions(List<String> logs, int threshold) {
        // Step 1: Count transactions per user
        Map<Integer, Integer> transactionCount = new HashMap<>();

        for (String log : logs) {
            String[] parts = log.split(" ");
            int sender = Integer.parseInt(parts[0]);
            int receiver = Integer.parseInt(parts[1]);

            // Count sender transaction
            transactionCount.put(sender, transactionCount.getOrDefault(sender, 0) + 1);
            // Count receiver transaction if it's different from sender
            if (sender != receiver) {
                transactionCount.put(receiver, transactionCount.getOrDefault(receiver, 0) + 1);
            }
        }

        // Step 2: Find minimum transaction count that is ≥ threshold
        Optional<Integer> minTransactionCount = transactionCount.values().stream()
                .filter(count -> count >= threshold) // Keep only users meeting threshold
                .min(Integer::compare);

        if (!minTransactionCount.isPresent()) {
            return new ArrayList<>(); // No users met threshold
        }

        int minCount = minTransactionCount.get();

        // Step 3: Filter customers with minCount transactions and sort
        return transactionCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= threshold)
                .map(Map.Entry::getKey)
                .sorted() // Sort in ascending order
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "1 2 100",
                "2 3 200",
                "3 3 300",  // Self-transaction (counts as 1)
                "4 1 150",
                "5 6 400",
                "6 5 500",
                "7 7 50"    // Self-transaction (counts as 1)
        );

        int threshold = 2;
        List<Integer> result = findCustomersWithMinTransactions(logs, threshold);
        System.out.println(result); // Output: [1, 2, 5, 6]
    }
}
