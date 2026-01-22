import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
/**
 * Write a description of class SimpleGraphicsProject here.
 *
 * @author Eli Shattuck
 * @version 11/12/25
 */
public abstract class SimpleGraphics extends JPanel {

    private static Graphics2D g2;

    public void start(String name, int width, int height) {
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public abstract void draw();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        draw();
    }
    public static int toInt(double d) { return (int)Math.round(d); }
    public static void setColor(Color c) {
        g2.setColor(c);
    }
    public static void square(double x, double y, double w) {
        //g2.fillRect(toInt(x-w/2), toInt(y-w/2), toInt(w), toInt(w));
        g2.fill(new Rectangle2D.Double(x - w/2, y - w/2, w, w));
    }
}
