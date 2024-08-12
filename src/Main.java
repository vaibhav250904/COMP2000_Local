import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }


    class Canvas extends JPanel {
        Grid grid = new Grid(); // Instance of the Grid class to manage the grid of cells

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
        }

        @Override
        public void paint(Graphics g) {
            // Call the grid's paint method, passing the Graphics object and the current mouse position
            grid.paint(g, getMousePosition());
        }
    }

    // Constructor for the Main class, setting up the JFrame
    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Canvas canvas = new Canvas(); 
        this.setContentPane(canvas); 
        this.pack(); // Pack the frame to fit the preferred size of the content pane
        this.setVisible(true); // Make the window visible
    }

    // Method to run the main loop of the program
    public void run() {
        while (true) {
            repaint(); // Repaint the window continuously to update the display
            try {
                Thread.sleep(5); 
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
    }
}
