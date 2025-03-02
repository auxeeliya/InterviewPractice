import java.util.*;

public class GiftingGroups {
    public static int countGiftingGroups(List<String> relations) {
        int n = relations.size();
        if (n == 0) return 0;

        // Convert input List<String> to adjacency matrix
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String row = relations.get(i);
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j) - '0';
            }
        }

        boolean[] visited = new boolean[n];
        int groups = 0;

        // Traverse all nodes
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Start DFS for unvisited node
                dfs(matrix, visited, i);
                groups++; // Found a new group
            }
        }

        return groups;
    }

    private static void dfs(int[][] matrix, boolean[] visited, int person) {
        visited[person] = true;
        for (int other = 0; other < matrix.length; other++) {
            if (matrix[person][other] == 1 && !visited[other]) {
                dfs(matrix, visited, other);
            }
        }
    }

    public static void main(String[] args) {
        List<String> relations = Arrays.asList(
                "1100",
                "1110",
                "0110",
                "0001"
        );

        int result = countGiftingGroups(relations);
        System.out.println(result); // Output: 2
    }
}
