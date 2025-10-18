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
        testSpeed();
        System.out.println("Passed " + numPassed + "/" + totalTests);
    }
    private static void testLinear() {
        System.out.println("Testing linearSearch for correctness");
        assertTrue(1, Searching.linearSearch(new int[]{1, 2, 3}, 2).isFound(), "2 in [1, 2, 3]?");
        assertTrue(2, Searching.linearSearch(new int[]{12, 6, 7, 3}, 7).isFound(), "7 in [12, 6, 7, 3]?");
        assertFalse(3, Searching.linearSearch(new int[]{1, 2, 3}, -4).isFound(), "-4 in [1, 2, 3]?");
        assertFalse(4, Searching.linearSearch(new int[]{12, 6, 7, 3}, 67).isFound(), "67 in [12, 6, 7, 3]?");
        System.out.println();
    }
    private static void testBinary() {
        System.out.println("Testing binarySearch for correctness");
        assertTrue(1, Searching.binarySearch(new int[]{1, 2, 3}, 2).isFound(), "2 in [1, 2, 3]?");
        assertTrue(2, Searching.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 5).isFound(), "5 in [1, 2, 3, 4, 5, 6]?");
        assertFalse(3, Searching.binarySearch(new int[]{1, 2, 3}, -4).isFound(), "-4 in [1, 2, 3]?");
        assertFalse(4, Searching.binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 0).isFound(), "0 in [1, 2, 3, 4, 5, 6]?");
        System.out.println();
    }
    private static void testSpeed() {
        System.out.println("Testing average speed of linear vs. binary search, over 100,000 trials");
        Random rand = new Random();
        int trials = 100_000;
        
        System.out.printf("%12s | %23s | %6s |  %7s | %6s%n", "Array Size", "Linear Comparisons", "% Error", "Time(ms)", "Passed?");
        System.out.println("-------------+-------------------------+---------+-----------+---------");

        for (int n = 10; n <= 1_000_000; n *= 10) {
            int[] nums = randomSorted(n);

            long totalLinear = 0;

            long startTime = System.nanoTime();
            for (int t = 0; t < trials; t++) {
                int target = nums[rand.nextInt(n)];
                totalLinear += Searching.linearSearch(nums, target).getComparisons();
            }
            long endTime = System.nanoTime();
            double avgMS = (endTime - startTime) / 1_000_000.0 / trials;
            
            double avgLinear = (double) totalLinear / trials;

            double expLinear = n * 0.5;
            
            double errLinear = 100*Math.abs(avgLinear-expLinear) / expLinear;
            boolean passed = errLinear < 20;
            
            totalTests++;
            if(passed) numPassed++;
            
            System.out.printf("%12d | %10.2f (%10.2f) | %6.2f%% | %5.5fms | %5b%n", n, avgLinear, expLinear, errLinear, avgMS, passed);
        }
        System.out.printf("%n%12s | %23s | %6s |  %7s | %6s%n", "Array Size", "Binary Comparisons", "% Error", "Time(ms)", "Passed?");
        System.out.println("-------------+-------------------------+---------+-----------+---------");

        for (int n = 10; n <= 1_000_000; n *= 10) {
            int[] nums = randomSorted(n);

            long totalLinear = 0;

            long startTime = System.nanoTime();
            for (int t = 0; t < trials; t++) {
                int target = nums[rand.nextInt(n)];
                totalLinear += Searching.binarySearch(nums, target).getComparisons();
            }
            long endTime = System.nanoTime();
            double avgMS = (endTime - startTime) / 1_000_000.0 / trials;
            
            double avgBinary = (double) totalLinear / trials;

            double expBinary = Math.log(n) / Math.log(2) - 1;
            
            double errBinary = 100*Math.abs(avgBinary-expBinary) / expBinary;
            boolean passed = errBinary < 20;
            
            totalTests++;
            if(passed) numPassed++;
            
            System.out.printf("%12d | %10.2f (%10.2f) | %6.2f%% | %5.5fms | %5b%n", n, avgBinary, expBinary, errBinary, avgMS, passed);
        }
    }
    private static int[] randomSorted(int n) {
        Random rand = new Random(42);
        int[] nums = new int[n];
        nums[0] = rand.nextInt(10);
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i-1] + rand.nextInt(5);
        }
        return nums;
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