import java.util.*;

public class BombermanGame {
    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) return grid; // Initial state remains

        int rows = grid.size(), cols = grid.get(0).length();
        char[][] initial = new char[rows][cols];

        // Convert List<String> to char[][]
        for (int i = 0; i < rows; i++) {
            initial[i] = grid.get(i).toCharArray();
        }

        // If n is even, return a full grid of bombs
        if (n % 2 == 0) {
           // return filledGrid(rows, cols);
        	return toList(fillGrid(rows, cols));
        }

        // Get two explosion patterns
        char[][] firstExplosion = explode(initial, rows, cols);
        char[][] secondExplosion = explode(firstExplosion, rows, cols);

        // Return appropriate grid based on the repeating cycle
        return n % 4 == 3 ? toList(firstExplosion) : toList(secondExplosion);
    }


    private static char[][] explode(char[][] grid, int rows, int cols) {
    	
        char[][] newGrid = fillGrid(rows,cols);

        for (int r = 0; r < rows; r++) {
        	System.out.print("actual rows="+ new String(grid[r]));
            for (int c = 0; c < cols; c++) {
            	
                if (grid[r][c] == 'O') {
                	
                    newGrid[r][c] = '.';
                    if (r > 0) newGrid[r - 1][c] = '.';
                    if (r < rows - 1) newGrid[r + 1][c] = '.';
                    if (c > 0) newGrid[r][c - 1] = '.';
                    if (c < cols - 1) newGrid[r][c + 1] = '.';
                }
               // System.out.print(newGrid[r][c]);
            }
            System.out.println();
        }
        return newGrid;
    }
    
    private static char[][] fillGrid( int r,int c){
    	char[][] newGrid = new char[r][c];
        for (char[] row : newGrid) Arrays.fill(row, 'O');
        return newGrid;
    }

    private static List<String> toList(char[][] grid) {
        List<String> result = new ArrayList<>();
        for (char[] row : grid) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList(
            ".......",
            "...O...",
            "....O..",
            ".......",
            "OO.....",
            "OO....."
        );
        int n = 3;
        List<String> result = bomberMan(n, grid);
       // result.forEach(System.out::println);
    }
}
