import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaprekarNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = scanner.nextInt();
        int upperBound = scanner.nextInt();
        scanner.close();

        List<Integer> kaprekarNumbers = getModifiedKaprekarNumbers(lowerBound, upperBound);

        if (kaprekarNumbers.isEmpty()) {
            System.out.println("invalid range");
        } else {
            kaprekarNumbers.forEach(number -> System.out.print(number + " "));
        }
    }

    private static List<Integer> getModifiedKaprekarNumbers(int lowerBound, int upperBound) {
        List<Integer> kaprekarNumbers = new ArrayList<>();

        for (int num = lowerBound; num <= upperBound; num++) {
            if (isModifiedKaprekar(num)) {
                kaprekarNumbers.add(num);
            }
        }

        return kaprekarNumbers;
    }

    private static boolean isModifiedKaprekar(int num) {
        if (num == 0) return false;

        long square = (long) num * num;
        String squareStr = String.valueOf(square);
        int d = String.valueOf(num).length();

        // Ensure the right part has exactly d digits
       // int rightStartIndex = Math.max(0, squareStr.length() - d);
       // String rightPart = squareStr.substring(rightStartIndex);
       // String leftPart = squareStr.substring(0, rightStartIndex);
        int leftSize=squareStr.length()- d;
        String leftpart=squareStr.substring(0,leftSize);
        String rightpart=squareStr.substring(leftSize);
        

        int left = leftpart.isEmpty() ? 0 : Integer.parseInt(leftpart);
        int right = Integer.parseInt(rightpart);

        return left + right == num;
    }
}
