import java.util.*;

public class EmaSuperComputer {
    
    public static int twoPluses(List<String> grid) {
        int rows = grid.size(), cols = grid.get(0).length();
        List<Plus> pluses = new ArrayList<>();

        // Find all valid pluses
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid.get(r).charAt(c) == 'G') {
                	
                    int maxSize = findMaxPlusSize(grid, r, c, rows, cols);
                    for (int size = 0; size <= maxSize; size++) {
                        pluses.add(new Plus(r, c, size));
                    }
                }
            }
        }

        // Find max product of two non-overlapping pluses
        int maxProduct = 0;
        for (int i = 0; i < pluses.size(); i++) {
            for (int j = i + 1; j < pluses.size(); j++) {
                Plus p1 = pluses.get(i), p2 = pluses.get(j);
                if (!p1.overlaps(p2)) {
                    maxProduct = Math.max(maxProduct, p1.area() * p2.area());
                }
            }
        }

        return maxProduct;
    }

    // Find max possible plus size at (r, c)
    private static int findMaxPlusSize(List<String> grid, int r, int c, int rows, int cols) {
        int size = 0;
        while (r - size >= 0 && r + size < rows && c - size >= 0 && c + size < cols &&
               grid.get(r - size).charAt(c) == 'G' &&
               grid.get(r + size).charAt(c) == 'G' &&
               grid.get(r).charAt(c - size) == 'G' &&
               grid.get(r).charAt(c + size) == 'G') {
            size++;
        }
        //System.out.print("size="+size);
        return size-1;
    }
    
    // Helper class to store plus details
    static class Plus {
        int r, c, size;
        
        Plus(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }

        int area() {
            return 1 + size * 4;
        }

        // Check if this plus overlaps with another
        boolean overlaps(Plus other) {
            Set<String> thisCells = occupiedCells();
            Set<String> otherCells = other.occupiedCells();
            for (String cell : thisCells) {
                if (otherCells.contains(cell)) return true;
            }
            return false;
        }

        // Get all occupied cells by this plus
        Set<String> occupiedCells() {
            Set<String> cells = new HashSet<>();
            for (int i = 0; i < size; i++) {
                cells.add((r - i) + "," + c);
                cells.add((r + i) + "," + c);
                cells.add(r + "," + (c - i));
                cells.add(r + "," + (c + i));
            }
            return cells;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        List<String> grid = List.of(
            "GGGGGG",
            "GBBBGB",
            "GGGGGG",
            "GGBBGB",
            "GGGGGG"
        );
        List<String> grid2 = List.of(
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "BGBBGB"
            );

        System.out.println(twoPluses(grid2)); // Expected output: 25
    }
}
