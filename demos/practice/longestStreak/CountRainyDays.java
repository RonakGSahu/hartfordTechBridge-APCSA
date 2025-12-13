
/**
 * Write a description of class lsls here.
 *
 * @author (Md Amit Hasan)
 * @version (Dec 5th 2025)
 */
class CountRainyDays {

    public static int longestRainStreak(int[] rain) {

        int currentStreak = 0;  // tracks ongoing rainy days
        int maxStreak = 0;      // stores the longest streak found

        for (int day : rain) {
            if (day == 1) {
                currentStreak++;  
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;  
            }
        }

        return maxStreak;
    }
}
