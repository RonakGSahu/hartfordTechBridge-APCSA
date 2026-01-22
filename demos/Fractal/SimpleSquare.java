import java.awt.Color;
/**
 * Write a description of class SimpleDrawing here.
 *
 * @author Eli Shattuck
 * @version 11/12/25
 */
public class SimpleSquare extends SimpleGraphics {
    public void draw() {
        setColor(Color.BLUE);
        square(400, 400, 729);
    }

    public static void main(String[] args) {
        SimpleSquare drawing = new SimpleSquare();
        drawing.start("Simple Square", 800, 800);
    }
}
