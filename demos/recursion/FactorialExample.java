public class FactorialExample {
    public static int factorial(int n) {
        // Base case: if n is 0, return 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: n! = n * (n - 1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(n + "! = " + factorial(n));
    }
}