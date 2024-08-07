import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle{

  static int size = 35;

  public Cell(int inX, int inY) {
    super(inX, inY, size, size);
  }

  public void paint(Graphics g, Point mousePos) {
    g.setColor(contains(mousePos) ? Color.GRAY : Color.WHITE);
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }

  @Override
  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    }
    
    return false;
  }
}
