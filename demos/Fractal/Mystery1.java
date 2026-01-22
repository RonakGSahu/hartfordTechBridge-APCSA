import java.awt.Color;
/**
 * Write a description of class SimpleDrawing here.
 *
 * @author Eli Shattuck
 * @version 11/12/25
 */
public class Mystery1 extends SimpleGraphics {
    public void draw() {
        setColor(Color.BLUE);
        mysteryShape(400, 400, 729);
    }
    public void mysteryShape(double x, double y, double w) {
        double newW = w / 3;
        for(int xOff = -1; xOff < 2; xOff++) {
            for(int yOff = -1; yOff < 2; yOff++) {
                if(xOff == 0 && yOff == 0) { 
                    continue;
                }
                square(x + newW*xOff, y + newW*yOff, newW);
            }
        }
    }
    public static void main(String[] args) {
        Mystery1 drawing = new Mystery1();
        drawing.start("Mystery Shape 1", 800, 800);
    }
}
