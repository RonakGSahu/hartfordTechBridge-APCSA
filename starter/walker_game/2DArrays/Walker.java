
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Walker {

	private int row; // current row of the walker
	private int col; // current column of the walker

	public Walker(int r, int c) {
		this.row = r;
		this.col = c;
	}

	public int getRow() { return row; }
	public int getCol() { return col; }
	public void setRow(int r) { this.row = r; }
	public void setCol(int c) { this.col = c; }
}