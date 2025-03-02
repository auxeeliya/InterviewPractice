import java.util.stream.Stream;

// FIBANOCCI USING JAVA STREAMS
//public class Fibonacci {
//    public static void main(String[] args) {
//        int n = 10; // Number of terms in the Fibonacci series
//        System.out.println("Fibonacci Series:");
//        printFibonacciSeries(n);
//    }
//
//    public static void printFibonacciSeries(int n) {
//        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
//                .limit(n)
//                .map(fib -> fib[0])
//                .forEach(System.out::println);
//    }
//}

public class Fibonacci{
	public static void fibonacciSeries(int n) {
		int firstTerm = 0;
		int secondTerm = 1;
		System.out.println(firstTerm);
		System.out.println(secondTerm);
		
		for(int i=2;i<n;i++) {
			int nextTerm=firstTerm+secondTerm;
			System.out.println(nextTerm);
			firstTerm=secondTerm;
			secondTerm=nextTerm;
		}
				
	}
	public static void main(String args[]) {
		int n=20;
		System.out.println("Fibonacci series");
		fibonacciSeries(n);
				
	}
}
