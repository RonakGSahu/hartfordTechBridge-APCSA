
/*
 * @author (Md Amit Hasan)
 * @version (Dec 5th 2025)
 */

public class Main {
    public static void main(String[] args) {

        int score = 0;

        // Test 1: 10 fish
        int[] f1 = {9, 3, 14, 8, 12, 5, 20, 1, 17, 11};
        // Largest 5 = 20, 17, 14, 12, 11 so total = 74
        if (FishingTrip.maxKeeperTotal(f1) == 74) score++;

        // Test 2: 10 fish
        int[] f2 = {2, 50, 33, 10, 5, 60, 25, 40, 18, 22};
        // Largest 5 = 60, 50, 40, 33, 25 so total = 208
        if (FishingTrip.maxKeeperTotal(f2) == 208) score++;

        // Test 3: 7 fish
        int[] f3 = {15, 9, 30, 22, 5, 17, 40};
        // Largest 5 = 40, 30, 22, 17, 15 so total = 124
        if (FishingTrip.maxKeeperTotal(f3) == 124) score++;

        // Test 4: fewer than 5 fish
        int[] f4 = {7, 1, 2};
        // Keep all = 7 + 1 + 2 = 10
        if (FishingTrip.maxKeeperTotal(f4) == 10) score++;

        System.out.println("Score: " + score + " / 4");
    }
}