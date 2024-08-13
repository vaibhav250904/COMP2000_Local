import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cell {
    static int size = 35;
    private int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g, Point mousePos) {
        if (mousePos != null && contains(mousePos)) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    private boolean contains(Point p) {
        if (p == null) {
            return false;
        }
        return p.x >= x && p.x < x + size && p.y >= y && p.y < y + size;
    }
}