import java.util.Scanner;

public class HalloweenSale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        int initialPrice = scanner.nextInt(); // p
        int discount = scanner.nextInt();    // d
        int minPrice = scanner.nextInt();    // m
        int budget = scanner.nextInt();      // s

        scanner.close();

        int gameCount = calculateGames(initialPrice, discount, minPrice, budget);
        System.out.println("Total games you can buy: " + gameCount);
    }

    private static int calculateGames(int initialPrice, int discount, int minPrice, int budget) {
        int gameCount = 0;
        int currentPrice = initialPrice;

        while (budget >= currentPrice) {
            budget -= currentPrice;
            gameCount++;
            currentPrice = Math.max(minPrice, currentPrice - discount);  // Ensure price doesn't go below minPrice
        }

        return gameCount;
    }
}
