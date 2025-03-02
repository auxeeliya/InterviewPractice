import java.util.Scanner;

//In this problem, you will build an application which calculates the checksum of a data set. The input comes in the form of a table. For each row in the table, determine the difference between the largest value and the smallest value; the checksum is the sum of all those differences.
//
//Example¶
//Input table:
//
//5 1 9 5
//7 5 3
//2 4 6 8
//The first row's largest and smallest values are 9 and 1. The difference is 8.
//The second row's largest and smallest values are 7 and 3. The difference is 4.
//The third row's largest and smallest values are 8 and 2. This row's difference is 6.
//In this example, the checksum would be 8 + 4 + 6 = 18



public class CalculateCheckSum {
	    
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
       // int inputArr[][]={{5,1,9,5},{7,5,3},{2,4,6,8}};
        int checkSum=0;
      System.out.println("Enter No of rows: ");
      int NumOfRows = s.nextInt();
       for(int i=0;i<NumOfRows;i++){
    	   System.out.println("Enter No of Columns for Row :" + (i+1));
    	   int NumOfColumns = s.nextInt();
            int smallest=Integer.MAX_VALUE;
            int largest=Integer.MIN_VALUE;
            for(int j=0;j<NumOfColumns;j++){
            	System.out.println("Enter values for Row : " + (i+1));
            	int val = s.nextInt();
                if(val <smallest)
                    smallest=val;
                if(val >largest)
                    largest=val;
            }
            checkSum=checkSum+(largest-smallest);
        }
        System.out.println("CheckSum ="+ checkSum);
    }
}

