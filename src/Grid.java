import java.awt.Graphics;
import java.awt.Point;

public class Grid {
    private int rows;
    private int cols;
    private int cellSize;
    private Cell[][] cells;

    public Grid(int rows, int cols, int cellSize) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        cells = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i * cellSize + 10, j * cellSize + 10, cellSize);
            }
        }
    }

    public void paint(Graphics g, Point mousePosition) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j].paint(g, mousePosition);
            }
        }
    }
}
