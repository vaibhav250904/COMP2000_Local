import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle {
    static int size = 35;

    // constructors
    public Cell(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    // methods
    public void paint(Graphics g, Point mousePos) {
        if (mousePos != null && contains(mousePos)) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }

    @Override
    public boolean contains(Point p) {
        if (p == null) {
            return false;
        }
        return super.contains(p);
    }
}
