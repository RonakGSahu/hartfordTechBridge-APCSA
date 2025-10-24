
/**
 * A class to hold various Sorting algorithms. This "demo version" also tracks the number
 * of checks made by each algorithm;
 *
 * @author Eli Shattuck
 * @version 10/22/25
 */
public class Sorting
{
    static class Result
    {
        int comparisons;
        public Result(int c){ comparisons = c; }
        public int getComparisons() { return comparisons; }
        public void incrementComparisons() { comparisons++; }
    }
    private static void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static Result bubbleSort(int[] nums)
    {
        int count = 0;
        for(int i = 0; i < nums.length-1; i++)
        {
            for(int j = 0; j < nums.length-1-i; j++)
            {
                count++;
                if(nums[j+1] < nums[j]) {
                    swap(nums, j+1, j);
                }
            }
        }
        return new Result(count);
    }
    public static Result selectionSort(int[] nums)
    {
        int count = 0;
        for(int firstUnsorted = 0; firstUnsorted < nums.length; firstUnsorted++)
        {
            int minIndex = firstUnsorted;
            for(int i = firstUnsorted+1; i < nums.length; i++)
            {
                count++;
                if(nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            swap(nums, minIndex, firstUnsorted);
        }
        return new Result(count);
    }
    public static Result insertionSort(int[] nums)
    {
        int count = 0;
        
        for(int firstUnsorted = 1; firstUnsorted < nums.length; firstUnsorted++)
        {
            int toInsert = nums[firstUnsorted];
            int i = firstUnsorted-1;
            while(i >= 0 && nums[i] > toInsert)
            {
                count++;
                nums[i+1] = nums[i];
                i--;
            }
            if(i >= 0) count++;
            nums[i+1] = toInsert;
        }

        return new Result(count);
    }
    private static int partition(int[] nums, int lo, int hi, int pivot, Result r)
    {
        int i = (lo - 1);

        for (int j = lo; j < hi; j++) 
        {
            r.incrementComparisons();
            if (nums[j] <= nums[pivot]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, pivot);
        
        return i+1;
    }
    private static void quickSort(int[] nums, int lo, int hi, Result r)
    {
        if(lo < hi) 
        {
            int p = partition(nums, lo, hi, hi, r);
            quickSort(nums, lo, p-1, r);
            quickSort(nums, p+1, hi, r);
        }
    }
    public static Result quickSort(int[] nums)
    {
        Result r = new Result(0);
        quickSort(nums, 0, nums.length-1, r);
        return r;
    }
}