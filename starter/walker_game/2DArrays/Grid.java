
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grid {
    private final int rows;
    private final int cols;
    private Walker walker;

    public Grid(int rows, int cols) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getRows() { throw new UnsupportedOperationException("Not implemented yet"); }
    public int getCols() { throw new UnsupportedOperationException("Not implemented yet"); }

    public void addWalker(Walker w) {
        if (w == null) throw new IllegalArgumentException("walker cannot be null");
        this.walker = w;
    }

    public Walker getWalker() { return walker; }

    public boolean move(int dRow, int dCol) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        int wr = -1, wc = -1;
        if (walker != null) { wr = walker.getRow(); wc = walker.getCol(); }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (i == wr && j == wc) {
                    sb.append('W');
                } else {
                    sb.append('.');
                }
                if (j < cols - 1) {
                    sb.append(' ');
                }
            }
            if (i < rows - 1) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
