public class PowExample {

    public static int pow(int x, int n) {
        int product = 1;
        for(int i = 0; i < n; i++) {
            product *= x;
        }
        return product;
    }

    public static void main(String[] args) {
        int x = 5;
        int n = 2;
        System.out.println(x + "^" + n + " = " + pow(x,n));
    }
}