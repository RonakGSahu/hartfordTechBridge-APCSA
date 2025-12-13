
/* Problem 3 - Keeping the Biggest Fish at Mansfield Hollow Lake

You went fishing at Mansfield Hollow Lake.

Rules:
- you can catch up to 10 fish
- you can keep a maximum of 5 fish 
- you must release the rest

You recorded the length of each fish in an array.

Your job:
Keep the five largest fish and return their total length.

If you caught fewer than 5 fish, keep them all.

You may use Arrays.sort() for this problem.

* @author (Md Amit Hasan)
* @version (Dec 5th 2025)
*/
import java.util.Arrays;
class FishingTrip {

    public static int maxKeeperTotal(int[] fish) {

        Arrays.sort(fish);  // smallest to largest

        int n = fish.length;
        int total = 0;
        int maxKeep = 5;

        int loopStart;
        int loopEnd;

        // If fewer than 5 fish, keep all of them
        if (n <= maxKeep) {
            loopStart = 0;
            loopEnd = n - 1;
        } else {
            // Otherwise, keep the largest 5 fish
            loopStart = n - maxKeep;
            loopEnd = n - 1;
        }

        // Add selected fish
        for (int i = loopStart; i <= loopEnd; i++) {
            total += fish[i];
        }

        return total;
    }
}