import java.util.Scanner;

public class Checkerboard
{
    public static void printCheckerBoard(int rows, int cols) 
    {
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(r % 2 != c % 2) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
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