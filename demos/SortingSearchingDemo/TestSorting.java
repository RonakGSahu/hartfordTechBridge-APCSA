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
        testSpeed();
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
    private static void testSpeed() {
        int trials = 500;
        System.out.println("Testing average speed of different sorts, over "+trials+" trials");
        Random rand = new Random();
        
        List<Function<int[], Sorting.Result>> sorts = List.of(Sorting::bubbleSort,Sorting::selectionSort,Sorting::insertionSort,Sorting::quickSort);
        String[] names = new String[]{ "Bubble", "Selection", "Insertion", "Quick" };
        List<Function<Integer, Double>> expecteds = List.of(
            (Integer n) -> (n * (n-1)) / 2.0, // bubble and selection are deterministic and always use n(n-1)/2 comparisons
            (Integer n) -> (n * (n-1)) / 2.0,
            (Integer n) -> (n*n + n - 2) / 4.0, // insertion on average uses less
            (Integer n) -> {
                // from Knuth, Art of Computer Programming - Volume 3 (Sorting & Searching)
                double harmonic = 0;
                for(int i = 1; i <= n; i++) harmonic += 1.0/i;
                return 2 * (n + 1) * harmonic - 4 * n;
            }
        );
        
        for(int i = 0; i < sorts.size(); i++) {
            String name = names[i];
            Function<int[], Sorting.Result> sort = sorts.get(i);
            Function<Integer, Double> expected = expecteds.get(i);
            System.out.printf("%12s | %25s | %6s |  %9s | %6s%n", "Array Size", name+" Comparisons", "% Error", "Time(ms)", "Passed?");
            System.out.println("-------------+---------------------------+---------+------------+---------");
    
            for (int n = 10; n <= 10_000; n *= 10) {
                long total = 0;
    
                long startTime = System.nanoTime();
                for (int t = 0; t < trials; t++) {
                    int[] nums = randomUnsorted(n);
                    int target = nums[rand.nextInt(n)];
                    total += sort.apply(nums).getComparisons();
                }
                long endTime = System.nanoTime();
                double avgMS = (endTime - startTime) / 1_000_000.0 / trials;
                double avg = (double) total / trials;
    
                double exp = expected.apply(n);
                
                double err = 100*Math.abs(avg-exp) / exp;
                boolean passed = err < 20;
                
                totalTests++;
                if(passed) numPassed++;
                
                System.out.printf("%12d | %11.2f (%11.2f) | %6.2f%% | %8.5fms | %5b%n", n, avg, exp, err, avgMS, passed);
            }
            System.out.println();
        }
    }
    private static int[] randomUnsorted(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = rng.nextInt(1_000_000);
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