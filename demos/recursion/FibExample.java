public class FibExample {

    public static int fibonacci(int n) {
        // Base cases: F(1) = 1 and F(2) = 1
        if (n == 1 || n == 2) {
            return 1;
        }
        // Recursive case: F(n) = F(n - 1) + F(n - 2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("F(" + n + ") = " + fibonacci(n));
    }
}