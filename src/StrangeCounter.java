import java.util.Scanner;

public class StrangeCounter {
    public static long strangeCounter(long t) {
        long v = 3; // First cycle value
        long startTime = 1; // Start time of each cycle
        
        // Find the cycle in which 't' falls
        while (t >= startTime + v) {
            startTime += v;
            v *= 2; // Next cycle starts at double value
        }

        // Calculate the value at time 't'
        return v - (t - startTime);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        System.out.println(strangeCounter(t));
        scanner.close();
    }
}
