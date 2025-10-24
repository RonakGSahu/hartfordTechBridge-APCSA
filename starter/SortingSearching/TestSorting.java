import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * Runs test cases for Sorting.bubbleSort, Sorting.insertionSort, 
 * Sorting.selectionSort, and Searching.quickSort
 * 
 * Displays pass/fail status and total score.
 * 
 * @author Eli Shattuck
 * @version 10/22/25
 */

public class TestSorting {
    private static int numPassed = 0;
    private static int totalTests = 0;
    private static Random rng = new Random();
    public static void main(String[] args) {
        System.out.println("Running tests...\n");
        testSort(Sorting::bubbleSort, "bubbleSort");
        testSort(Sorting::selectionSort, "selectionSort");
        testSort(Sorting::insertionSort, "insertionSort");
        testSort(Sorting::quickSort, "quickSort");
        System.out.println("Passed " + numPassed + "/" + totalTests);
    }
    private static void testSort(Consumer<int[]> toTest, String name) {
        System.out.println("Testing " + name + " for correctness");
        
        int[] nums = new int[]{1, 2, 3};
        toTest.accept(nums);
        assertArrayEquals(1, nums, new int[]{1, 2, 3}, "sort([1, 2, 3])=[1, 2, 3]?");
        
        nums = new int[]{6, 7, 9, 2, 1, 4};
        toTest.accept(nums);
        assertArrayEquals(1, nums, new int[]{1, 2, 4, 6, 7, 9}, "sort([6, 7, 9, 2, 1, 4])=[1, 2, 4, 6, 7, 9]?");
        
        nums = new int[]{0, -1, 1, -2, 2};
        toTest.accept(nums);
        assertArrayEquals(1, nums, new int[]{-2, -1, 0, 1, 2}, "sort([0, -1, 1, -2, 2])=[-2, -1, 0, 1, 2]?");
        
        System.out.println();
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
    private static void assertArrayEquals(int testNum, int[] actual, int[] expected, String expression) {
        totalTests++;
        if (Arrays.equals(actual,expected)) {
            System.out.println("test " + testNum + " passed");
            numPassed++;
        } else {
            System.out.println("test " + testNum + " failed " + expression + " == " + Arrays.toString(actual) + " (expected " + Arrays.toString(expected) + ")");
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