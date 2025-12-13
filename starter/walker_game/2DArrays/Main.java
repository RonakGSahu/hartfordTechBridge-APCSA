
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rows = promptInt(sc, "Enter number of rows: ", 1, 100);
		int cols = promptInt(sc, "Enter number of cols: ", 1, 100);

		Grid layoutGrid = new Grid(rows, cols);
		int startR = rows - 1;
		int startC = 0;
		Walker walker = new Walker(startR, startC);
		layoutGrid.addWalker(walker);

		boolean running = true;
		System.out.println();
		while (running) {
			System.out.println(layoutGrid.render());
			System.out.print("Move (w/a/s/d, q=quit): ");
			String cmd = sc.nextLine().trim().toLowerCase();
			if (cmd.isEmpty()) continue;

			boolean moved = false;

			// Fix this part to actually move the walker ;) this code doesn't do anything yet
			boolean to_compile_code = true;

			if (!to_compile_code ){
				moved = true;
			}
			else if (cmd.equals("q")) {
				running = false;
				continue;
			} else {
				System.out.println("Unknown command: " + cmd);
				continue;
			}
			
			if (!moved) {
				System.out.println("Bump! Edge of grid.");
			}
			System.out.println();
			throw new UnsupportedOperationException("Not implemented yet");
		}
		System.out.println("Goodbye!");
		sc.close();
	}

	private static int promptInt(Scanner sc, String prompt, int min, int max) {
		while (true) {
			System.out.print(prompt);
			String line = sc.nextLine().trim();
			try {
				int val = Integer.parseInt(line);
				if (val < min || val > max) {
					System.out.println("Please enter a value between " + min + " and " + max + ".");
				} else {
					return val;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid integer.");
			}
		}
	}
}