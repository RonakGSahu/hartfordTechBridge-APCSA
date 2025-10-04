
/**
 * Simple Practice with loops.
 * 
 * Runs test cases for Q1 through Q4.
 * Displays pass/fail status and total score.
 * 
 * @author Eli Shattuck
 * @version 10/3/25
 */

public class Main {
    private static int numPassed = 0;
    
    public static void main(String[] args) {
        System.out.println("Running tests...\n");
        testQ1();
        testQ2();
        testQ3();
        testQ4();
        System.out.println("Passed " + numPassed + "/12");
    }
    private static void testQ1() {
        System.out.println("Q1");
        assertEqual(1, Q1.sum(new int[]{1, 2, 3}), 6, "sum([1, 2, 3])");
        assertEqual(2, Q1.sum(new int[]{10, -5, 15}), 20, "sum([10, -5, 15])");
        assertEqual(3, Q1.sum(new int[]{}), 0, "sum([])");
        System.out.println();
    }
    private static void testQ2() {
        System.out.println("Q2");
        assertEqual(1, Q2.max(new int[]{3, 7, 2, 9}), 9, "max([3, 7, 2, 9])");
        assertEqual(2, Q2.max(new int[]{-10, -20, -3}), -3, "max([-10, -20, -3])");
        assertEqual(3, Q2.max(new int[]{5}), 5, "max([5])");
        System.out.println();
    }
    private static void testQ3() {
        System.out.println("Q3");
        assertEqual(1, Q3.countEvens(new int[]{1, 2, 4, 5, 6}), 3, "countEvens([1, 2, 4, 5, 6])");
        assertEqual(2, Q3.countEvens(new int[]{1, 3, 5, 7}), 0, "countEvens([1, 3, 5, 7])");
        assertEqual(3, Q3.countEvens(new int[]{}), 0, "countEvens([])");
        System.out.println();
    }
    private static void testQ4() {
        System.out.println("Q4");
        assertTrue(1, Q4.contains(new int[]{1, 2, 3, 4}, 3), "contains([1, 2, 3, 4], 3)");
        assertFalse(2, Q4.contains(new int[]{1, 2, 3, 4}, 5), "contains([1, 2, 3, 4], 5)");
        assertFalse(3, Q4.contains(new int[]{}, 1), "contains([], 1)");
        System.out.println();
    }
    private static void assertEqual(int testNum, int actual, int expected, String expression) {
        if (actual == expected) {
            System.out.println("test " + testNum + " passed");
            numPassed++;
        } else {
            System.out.println("test " + testNum + " failed " + expression + " == " + actual + " (expected " + expected + ")");
        }
    }
    private static void assertTrue(int testNum, boolean actual, String expression) {
        if (actual) {
            System.out.println("test " + testNum + " passed");
            numPassed++;
        } else {
            System.out.println("test " + testNum + " failed " + expression + " == false (expected true)");
        }
    }
    private static void assertFalse(int testNum, boolean actual, String expression) {
        if (!actual) {
            System.out.println("test " + testNum + " passed");
            numPassed++;
        } else {
            System.out.println("test " + testNum + " failed " + expression + " == true (expected false)");
        }
    }
}