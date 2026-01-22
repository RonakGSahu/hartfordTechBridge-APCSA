import java.awt.Color;
/**
 * Write a description of class SimpleDrawing here.
 *
 * @author Eli Shattuck
 * @version 11/12/25
 */
public class Mystery2 extends SimpleGraphics {
    public void draw() {
        setColor(Color.BLUE);
        mysteryShape(400, 400, 729);//243);
    }
    public void mysteryShape(double x, double y, double w) {
        double newW = w / 3;
        if (newW > 25) { 
            for(int xOff = -1; xOff < 2; xOff++) {
                for(int yOff = -1; yOff < 2; yOff++) {
                    if(xOff == 0 && yOff == 0) { 
                        continue;
                    }
                    mysteryShape(x + newW*xOff, y + newW*yOff, newW);
                }
            }
        } else { 
            //System.out.printf("%f %f %f\n", x, y, w);
            square(x, y, w); 
        } 
    }
    public static void main(String[] args) {
        Mystery2 drawing = new Mystery2();
        drawing.start("Mystery Shape 2", 800, 800);
    }
}
