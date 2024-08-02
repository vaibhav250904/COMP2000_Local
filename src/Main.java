import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Canvas extends JPanel implements MouseMotionListener {
        private Grid grid;
        private Point mousePosition;

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
            grid = new Grid(20, 20, 35); // 20x20 grid with each cell of size 35
            addMouseMotionListener(this);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            grid.paint(g, mousePosition);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mousePosition = e.getPoint();
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {}
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }
}
