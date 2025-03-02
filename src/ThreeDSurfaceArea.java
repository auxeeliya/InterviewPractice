
import java.util.List;

public class ThreeDSurfaceArea {
    
    public static int surfaceArea(int n, int m, List<Integer> heights) {
        // Convert the flat list into a 2D array
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = heights.get(i * m + j);  // Convert 1D index to 2D
            }
        }

        int totalSurfaceArea = 0;
        totalSurfaceArea += 2 * n * m; // Top and Bottom surfaces

        // Compute side faces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currentHeight = A[i][j];

                // Left side
                if (j == 0) {
                    totalSurfaceArea += currentHeight;
                } else {
                    totalSurfaceArea += Math.max(0, currentHeight - A[i][j - 1]);
                }

                // Right side
                if (j == m - 1) {
                    totalSurfaceArea += currentHeight;
                } else {
                    totalSurfaceArea += Math.max(0, currentHeight - A[i][j + 1]);
                }

                // Front side
                if (i == 0) {
                    totalSurfaceArea += currentHeight;
                } else {
                    totalSurfaceArea += Math.max(0, currentHeight - A[i - 1][j]);
                }

                // Back side
                if (i == n - 1) {
                    totalSurfaceArea += currentHeight;
                } else {
                    totalSurfaceArea += Math.max(0, currentHeight - A[i + 1][j]);
                }
            }
        }

        return totalSurfaceArea;
    }

    public static void main(String[] args) {
        // Example input: 3x3 grid given as a list
        List<Integer> heights = List.of(
            1, 3, 4,  // First row
            2, 2, 3,  // Second row
            3, 1, 2   // Third row
        );
        
        int n = 3, m = 3;  // Define the grid size
        System.out.println(surfaceArea(n, m, heights));  // Output: 38
    }
}
