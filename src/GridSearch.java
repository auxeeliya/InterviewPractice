import java.util.List;

public class GridSearch {

    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();         // Rows of large grid
        int C = G.get(0).length(); // Columns of large grid
        int r = P.size();         // Rows of pattern
        int c = P.get(0).length(); // Columns of pattern

        // Loop over all possible starting points
        for (int i = 0; i < R - r; i++) {
            for (int j = 0; j < C - c; j++) {

                // Check if pattern matches starting at G[i][j]
                if (isPatternFound(G, P, i, j)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static boolean isPatternFound(List<String> G, List<String> P, int rowStart, int colStart) {
        for (int i = 0; i < P.size(); i++) {
            // Extract substring of the large grid row and compare it with the pattern row
            if (!G.get(rowStart + i).substring(colStart, colStart + P.get(i).length())
                    .equals(P.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> G = List.of(
		/*
		 * "7283455864", "6731158619", "8988242643", "3830589324", "2229505813",
		 * "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"
		 */
        		"1234" ,
        		"4321" ,
        		"9999" ,
        		"9999"
        );

        List<String> P = List.of(
		/*
		 * "9505", "3845", "3530"
		 */
        		"12","21"
        );

        System.out.println(gridSearch(G, P)); // Expected output: YES
    }
}
