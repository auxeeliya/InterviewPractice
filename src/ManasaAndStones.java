import java.util.HashSet;
import java.util.Set;

public class ManasaAndStones {

    public static Set<Integer> stones(int n, int a, int b) {
        Set<Integer> possibleStones = new HashSet<>();

        // Iterate through all possible combinations of steps
        for (int i = 0; i < n; i++) {
            int stonePosition = i * a + (n - 1 - i) * b;
            possibleStones.add(stonePosition);
        }

        return possibleStones;
    }

    public static void main(String[] args) {
        int n = 999, a = 1, b = 2;
        Set<Integer> result = stones(n, a, b);
        
        // Print the distinct possible positions in ascending order
        result.stream().sorted().forEach(stone -> System.out.print(stone + " "));
    }
}

