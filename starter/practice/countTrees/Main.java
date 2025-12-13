/* Problem 1 - Count Trees With Leaves

You are hiking on a trail in Connecticut during late fall.
You wrote down the heights of the trees you passed in an array.

A tree has leaves if its height is greater than 30 feet.
Your job:
Count how many trees in the array still have leaves.
 @author (Md Amit Hasan)
 @version (Dec 5th 2025)
*/

public class Main {
    public static void main(String[] args) {

        int score = 0;

        // Test 1: 15 trees
        int[] h1 = {10, 20, 40, 50, 31, 15, 5, 60, 35, 29, 45, 12, 8, 33, 27};
        // Leaves: 40, 50, 31, 60, 35, 45, 33; so total = 7
        if (CountTrees.countTreesWithLeaves(h1) == 7) score++;

        // Test 2: 20 trees
        int[] h2 = {31, 32, 33, 5, 10, 15, 45, 60, 29, 28, 27, 90, 55, 52, 40, 22, 21, 100, 37, 38};
        // Leaves (>30): 31,32,33,45,60,90,55,52,40,100,37,38; so total = 12
        if (CountTrees.countTreesWithLeaves(h2) == 12) score++;

        // Test 3: 10 trees
        int[] h3 = {5, 10, 15, 20, 31, 33, 40, 12, 8, 50};
        // Leaves: 31,33,40,50; so total = 4
        if (CountTrees.countTreesWithLeaves(h3) == 4) score++;

        // Test 4: 5 trees, all less than 30
        int[] h4 = {5, 10, 12, 20, 29};
        // Leaves: none; so 0
        if (CountTrees.countTreesWithLeaves(h4) == 0) score++;

        System.out.println("Score: " + score + " / 4");
    }
}