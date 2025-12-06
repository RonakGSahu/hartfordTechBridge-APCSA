
/**
 * Write a description of class CountTrees here.
 *
 * @author (Md Amit Hasan)
 * @version (Dec 5th 2025)
 */
class CountTrees {

    public static int countTreesWithLeaves(int[] heights) {

        int count = 0; // counts trees with height > 30

        for (int h : heights) {
            if (h > 30) {
                count++;
            }
        }

        return count;
    }
}