import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class Grid {
    Cell[][] cells = new Cell[20][20];
    private LinkedList<Point> mouseTrail = new LinkedList<>();

    public Grid() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(10 + Cell.size * i, 10 + Cell.size * j);
            }
        }
    }

    public void updateMouseTrail(Point point) {
        if (point != null) {
            mouseTrail.addFirst(point);
            if (mouseTrail.size() > 100) {
                mouseTrail.removeLast();
            }
        }
    }

    public void paint(Graphics g, Point mousePos) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].paint(g, mousePos);
            }
        }
        drawMouseTrail(g);
    }

    private void drawMouseTrail(Graphics g) {
        for (Point p : mouseTrail) {
            if (p != null) {
                g.setColor(new Color(0, 0, 255, 128)); // Semi-transparent red
                g.fillOval(p.x - 10, p.y - 10, 20, 20);
            }
        }
    }
}