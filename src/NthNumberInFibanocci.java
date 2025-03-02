
public class NthNumberInFibanocci {
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1)
            return n;

        // Create an array to store Fibonacci numbers
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        System.out.println(fib[0]+"\n"+ fib[1]);
        // Calculate Fibonacci numbers using dynamic programming
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.println(fib[i]);
        }

        return fib[n-1];
    }

    public static void main(String[] args) {
        int n = 5; // Change this to calculate a different Fibonacci number
        System.out.println("Fibonacci number at position " + 5 + " is: " + fibonacci(n));
    }
}