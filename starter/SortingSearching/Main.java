import java.util.Random;
import java.util.function.Function;
/**
 * 
 * Runs test cases for Searching.linearSearch, and Searching.binarySearch
 * Displays pass/fail status and total score.
 * 
 * @author Eli Shattuck
 * @version 10/16/25
 */

public class Main {
    private static int numPassed = 0;
    private static int totalTests = 0;
    private static Random rng = new Random();
    public static void main(String[] args) {
        System.out.println("Running tests...\n");
        testLinear();
        testBinary();
        System.out.println("Passed " + numPassed + "/" + totalTests);
    }
    private static void testLinear() {
        System.out.println("Testing linearSearch for correctness");
        assertTrue(1, Searching.linearSearch(new int[]{1, 2, 3}, 2), "2 in [1, 2, 3]?");
        assertTrue(2, Searching.linearSearch(new int[]{12, 6, 7, 3}, 7), "7 in [12, 6, 7, 3]?");
        assertFalse(3, Searching.linearSearch(new int[]{1, 2, 3}, -4), "-4 in [1, 2, 3]?");
        assertFalse(4, Searching.linearSearch(new int[]{12, 6, 7, 3}, 67), "67 in [12, 6, 7, 3]?");
        System.out.println();
    }
    private static void testBinary() {
        System.out.println("Testing binarySearch for correctness");
        assertTrue(1, Searching.binarySearch(new int[]{1, 2, 3}, 2), "2 in [1, 2, 3]?");
        assertTrue(2, Searching.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 5), "5 in [1, 2, 3, 4, 5, 6]?");
        assertFalse(3, Searching.binarySearch(new int[]{1, 2, 3}, -4), "-4 in [1, 2, 3]?");
        assertFalse(4, Searching.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 0), "0 in [1, 2, 3, 4, 5, 6]?");
        System.out.println();
    }
    private static int[] randomSorted(int n) {
        int[] rs = new int[n];
        rs[0] = rng.nextInt(10);
        for(int i = 1; i < n; i++) rs[i] = rs[0] + rng.nextInt(10);
        return rs;
    }
    private static void assertEqual(int testNum, int actual, int expected, String expression) {
        totalTests++;
        if (actual == expected) {
            System.out.println("test " + testNum + " passed");
            numPassed++;
        } else {
            System.out.println("test " + testNum + " failed " + expression + " == " + actual + " (expected " + expected + ")");
        }
    }
    private static void assertTrue(int testNum, boolean actual, String expression) {
        totalTests++;
        if (actual) {
            System.out.println("test " + testNum + " passed");
            numPassed++;
        } else {
            System.out.println("test " + testNum + " failed " + expression + " == false (expected true)");
        }
    }
    private static void assertFalse(int testNum, boolean actual, String expression) {
        totalTests++;
        if (!actual) {
            System.out.println("test " + testNum + " passed");
            numPassed++;
        } else {
            System.out.println("test " + testNum + " failed " + expression + " == true (expected false)");
        }
    }
}