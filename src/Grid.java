import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Grid {
    // initializing fields
    Cell[][] cells = new Cell[20][20];
    Queue<Point> mouseTrail = new LinkedList<>(); //linked list for trail

    public Grid() {  // create grid
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(10 + Cell.size * i, 10 + Cell.size * j);
            }
        }
    }

    public void paint(Graphics g, Point mousePos) {
        if (mousePos != null) {
            if (mouseTrail.size() >= 100) {
                mouseTrail.poll(); 
            }
            mouseTrail.offer(new Point(mousePos)); 
        }

        // draw the grid
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].paint(g, mousePos);
            }
        }

        // for loop for drawing the mouse trail on top of the grid
        for (Point point : mouseTrail) {
            g.setColor(new Color(0, 0, 255, 100)); 
            g.fillOval(point.x - 5, point.y - 5, 15, 15); 
        }
    }
}