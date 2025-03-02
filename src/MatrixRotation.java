import java.util.*;
import java.util.stream.Collectors;

public class MatrixRotation {
    public static void MatrixRotation(List<List<Integer>> matrix, int r) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int layers = Math.min(rows, cols) / 2; // Number of rings in the matrix

        List<List<Integer>> rotatedMatrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            rotatedMatrix.add(new ArrayList<>(Collections.nCopies(cols, 0)));
        }

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = extractLayer(matrix, layer, rows, cols);
            List<Integer> rotatedElements = rotateLayer(elements, r);
            placeLayer(rotatedMatrix, rotatedElements, layer, rows, cols);
        }

        // Print the rotated matrix
        for (List<Integer> row : rotatedMatrix) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    private static List<Integer> extractLayer(List<List<Integer>> matrix, int layer, int rows, int cols) {
        List<Integer> layerElements = new ArrayList<>();

        // Top row (left to right)
        for (int i = layer; i < cols - layer; i++) layerElements.add(matrix.get(layer).get(i));
        // Right column (top to bottom)
        for (int i = layer + 1; i < rows - layer; i++) layerElements.add(matrix.get(i).get(cols - layer - 1));
        // Bottom row (right to left)
        for (int i = cols - layer - 2; i >= layer; i--) layerElements.add(matrix.get(rows - layer - 1).get(i));
        // Left column (bottom to top)
        for (int i = rows - layer - 2; i > layer; i--) layerElements.add(matrix.get(i).get(layer));

        return layerElements;
    }

    private static List<Integer> rotateLayer(List<Integer> layerElements, int r) {
        int n = layerElements.size();
        int rotations = r % n; // Avoid unnecessary full rotations
        Collections.rotate(layerElements, -rotations); // Left rotation
        return layerElements;
    }

    private static void placeLayer(List<List<Integer>> matrix, List<Integer> rotatedElements, int layer, int rows, int cols) {
        int index = 0;

        // Top row (left to right)
        for (int i = layer; i < cols - layer; i++) matrix.get(layer).set(i, rotatedElements.get(index++));
        // Right column (top to bottom)
        for (int i = layer + 1; i < rows - layer; i++) matrix.get(i).set(cols - layer - 1, rotatedElements.get(index++));
        // Bottom row (right to left)
        for (int i = cols - layer - 2; i >= layer; i--) matrix.get(rows - layer - 1).set(i, rotatedElements.get(index++));
        // Left column (bottom to top)
        for (int i = rows - layer - 2; i > layer; i--) matrix.get(i).set(layer, rotatedElements.get(index++));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int r = scanner.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }

        MatrixRotation(matrix, r);
        scanner.close();
    }
}
