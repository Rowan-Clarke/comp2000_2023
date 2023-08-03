import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        //System.out.println("Red vs. Blue");
        Main window = new Main();
    }

    class Canvas extends JPanel{
        public Canvas(){
            setPreferredSize(new Dimension(720, 720));
        }
        @Override
        public void paint(Graphics g){
            Grid grid = new Grid(20,35);
            grid.drawGrid(g);
        }
    }

    private Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
        Point mousePos = getMousePosition();
        // Grid grid = new Grid(30,5,100,10);
    }
}

