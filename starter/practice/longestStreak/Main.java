/* 
 * @author (Md Amit Hasan)
 * @version (Dec 5th 2025)
*/

public class Main {
    public static void main(String[] args) {

        int score = 0;

        // Test 1: 15 days
        int[] r1 = {1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1};
        // Longest streak = 4
        if (CountRainyDays.longestRainStreak(r1) == 4) score++;

        // Test 2: 10 days
        int[] r2 = {1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
        // Longest streak = 3
        if (CountRainyDays.longestRainStreak(r2) == 3) score++;

        // Test 3: 4 days
        int[] r3 = {1, 1, 0, 1};
        // Longest streak = 2
        if (CountRainyDays.longestRainStreak(r3) == 2) score++;

        // Test 4: 4 days, no rain
        int[] r4 = {0, 0, 0, 0};
        // Longest streak = 0
        if (CountRainyDays.longestRainStreak(r4) == 0) score++;

        System.out.println("Score: " + score + " / 4");
    }
}