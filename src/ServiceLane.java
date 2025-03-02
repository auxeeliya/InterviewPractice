import java.util.*;
import java.util.stream.*;

public class ServiceLane {

    public static List<Integer> getServiceLaneWidths(int n, List<Integer> width, List<List<Integer>> cases) {
        // Result list to store the minimum widths for each test case
        return cases.stream()
                .map(segment -> {
                    int start = segment.get(0);
                    int end = segment.get(1);
                    // Find the minimum width in the specified segment
                    return IntStream.rangeClosed(start, end)
                            .map(width::get)
                            .min()
                            .orElse(3); // Default maximum width for truck if empty (edge case)
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int n = 8;
        List<Integer> width = List.of(2, 3, 1, 2, 3, 2, 3, 3);
        List<List<Integer>> cases = List.of(
            List.of(0, 3),
            List.of(4, 6),
            List.of(6, 7),
            List.of(3, 5),
            List.of(0, 7)
        );

        List<Integer> result = getServiceLaneWidths(n, width, cases);
        result.forEach(System.out::println);
    }
}
