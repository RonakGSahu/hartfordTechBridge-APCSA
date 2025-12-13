import java.util.Scanner;

public class Checkerboard
{
    public static void printCheckerBoard(int rows, int cols) 
    {
        // your code goes here!
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("rows = ");
        int rows = scan.nextInt();
        
        System.out.println("cols = ");
        int cols = scan.nextInt();
        
        printCheckerBoard(rows, cols);
    }
}