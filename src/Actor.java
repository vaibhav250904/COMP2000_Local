import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor {
    List<Polygon> shapes;
    Cell loc;

    public Actor(Cell loc) {
        this.loc = loc;
        this.shapes = new ArrayList<>();
        initializeShapes();
    }

    protected abstract void initializeShapes();

    public void paint(Graphics g) {
        for (Polygon shape : shapes) {
            g.drawPolygon(shape);
        }
    }
}
