import java.util.Arrays;
import java.util.stream.IntStream;

public class FlatLandSpaceStations {

    public static int flatlandSpaceStations(int n, int[] spaceStations) {
        if (spaceStations.length == n) {
            return 0; // All cities have space stations
        }

        Arrays.sort(spaceStations);

        // Find the maximum gap between consecutive stations
        int maxDistanceBetweenStations = IntStream.range(1, spaceStations.length)
                .map(i -> (spaceStations[i] - spaceStations[i - 1]) / 2)
                .max()
                .orElse(0);

        // Distance from the first city to the first space station
        int startDistance = spaceStations[0];

        // Distance from the last space station to the last city
        int endDistance = (n-1) - spaceStations[spaceStations.length - 1];

        // Return the maximum of all calculated distances
        return Math.max(maxDistanceBetweenStations, Math.max(startDistance, endDistance));
    }

    public static void main(String[] args) {
        int n = 20;
        int[] spaceStations = {13,1,11,10,6};

        int result = flatlandSpaceStations(n, spaceStations);
        System.out.println("Maximum distance to nearest space station: " + result);
    }
}
