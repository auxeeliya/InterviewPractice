import java.util.Scanner;

public class TimeInWords {

    private static final String[] HOURS = {
        "twelve", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten", "eleven", "twelve"
    };

    private static final String[] MINUTES = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
        "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", 
        "sixteen", "seventeen", "eighteen", "nineteen", "twenty", 
        "twenty-one", "twenty-two", "twenty-three", "twenty-four", 
        "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", 
        "twenty-nine", "half"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter hour (0-12): ");
        int h = scanner.nextInt();
        System.out.print("Enter minutes (0-59): ");
        int m = scanner.nextInt();

        System.out.println(convertTimeToWords(h, m));
    }

    private static String convertTimeToWords(int h, int m) {
        if (m == 0) {
            return HOURS[h] + " o' clock";
        }

        if (m <= 30) {
            String minuteWord = (m == 15 || m == 30) ? MINUTES[m] : MINUTES[m] + (m == 1 ? " minute" : " minutes");
            return minuteWord + " past " + HOURS[h];
        } else {
            int remainingMinutes = 60 - m;
            String minuteWord = (remainingMinutes == 15) ? MINUTES[remainingMinutes] : MINUTES[remainingMinutes] + (remainingMinutes == 1 ? " minute" : " minutes");
            return minuteWord + " to " + HOURS[(h % 12) + 1];
        }
    }
}
