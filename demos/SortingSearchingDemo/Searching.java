/**
 * A class to hold various Searching algorithms. This "demo version" also tracks the number
 * of checks made by each algorithm;
 *
 * @author Eli Shattuck
 * @version 10/16/25
 */
public class Searching
{
    static class Result
    {
        int comparisons;
        boolean isFound;
        public Result(int c, boolean f)
        {
            comparisons = c;
            isFound = f;
        }
        public int getComparisons() { return comparisons; }
        public boolean isFound() { return isFound; }
    }
    public static Result linearSearch(int[] data, int target)
    {
        int count = 0;
        for(int index = 0; index < data.length; index++)
        {
            count++;
            if(data[index] == target) 
            {
                return new Result(count, true);
            }
        }
        return new Result(count, false);
    }
    public static Result binarySearch(int[] data, int target)
    {
        int lo = 0;
        int hi = data.length-1;
        int count = 0;
        while(lo <= hi)
        {
            int mid = (lo + hi) / 2;
            count++;
            if(data[mid] < target) 
            {
                lo = mid+1;
            } 
            else if(data[mid] > target)
            {
                hi = mid-1;
            }
            else
            {
                return new Result(count, true);
            }
        }
        return new Result(count, false);
    }
}