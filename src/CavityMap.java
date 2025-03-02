import java.util.List;
import java.util.ArrayList;

public class CavityMap {

    public static List<String> cavityMap(List<String> grid) {
        int n = grid.size();
        List<String> result = new ArrayList<>(grid);

        for (int i = 1; i < n - 1; i++) {
            char[] row = result.get(i).toCharArray();
            for (int j = 1; j < n - 1; j++) {
                char current = grid.get(i).charAt(j);
                if (isCavity(grid, i, j, current)) {
                    row[j] = 'X';
                }
            }
            result.set(i, new String(row));
        }

        return result;
    }

    private static boolean isCavity(List<String> grid, int i, int j, char current) {
        return current > grid.get(i - 1).charAt(j) && // Top
               current > grid.get(i + 1).charAt(j) && // Bottom
               current > grid.get(i).charAt(j - 1) && // Left
               current > grid.get(i).charAt(j + 1);   // Right
    }

    public static void main(String[] args) {
        List<String> grid = List.of("989", "191", "111");
        List<String> result = cavityMap(grid);
        result.forEach(System.out::println);
    }
}
