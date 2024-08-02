import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cell {
    private int x;
    private int y;
    private int size;
    private Color fillColor;
    private Color borderColor;

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.fillColor = Color.WHITE;
        this.borderColor = Color.BLACK;
    }

    public void paint(Graphics g, Point mousePosition) {
        if (mousePosition != null && contains(mousePosition)) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(fillColor);
        }
        g.fillRect(x, y, size, size);
        g.setColor(borderColor);
        g.drawRect(x, y, size, size);
    }

    public boolean contains(Point p) {
        return p.x >= x && p.x < x + size && p.y >= y && p.y < y + size;
    }
}
