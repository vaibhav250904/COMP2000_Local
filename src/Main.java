import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    class Canvas extends JPanel {
        Grid grid = new Grid();
        LinkedList<Point> mouseTrail = new LinkedList<>();

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
        }

        @Override
        public void paint(Graphics g) {
            grid.paint(g, getMousePosition());
            drawMouseTrail(g);
        }

        private void drawMouseTrail(Graphics g) {
            for (Point p : mouseTrail) {
                if (p != null) {
                    g.setColor(new Color(255, 0, 0, 128)); // Semi-transparent red
                    g.fillOval(p.x - 10, p.y - 10, 20, 20);
                }
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            grid.paint(g, getMousePosition());
            drawMouseTrail(g);
        }

        @Override
        public void addNotify() {
            super.addNotify();
            requestFocus();
            addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    mouseTrail.addFirst(e.getPoint());
                    if (mouseTrail.size() > 100) {
                        mouseTrail.removeLast();
                    }
                    repaint();
                }
            });
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            repaint();
        }
    }
}
