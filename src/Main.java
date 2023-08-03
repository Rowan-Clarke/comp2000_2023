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
            Point mousePos = getMousePosition();
            //Run this one to mke it work
            //grid.drawGrid(g);
            //Point mousePos = new Point(267,210);
            if (mousePos != null){
                Integer mX = mousePos.x;
                Integer mY = mousePos.y;
                if (mX == null || mY == null){
                    grid.drawGrid(g);
                }
                else{
                    grid.drawGridWithMouse(g, mX, mY);
                }
            }
            else{
                grid.drawGrid(g);
            }
            
            //grid.drawGridWithMouse(g, 35, 35);
        }
    }

    private Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
        // Grid grid = new Grid(30,5,100,10);
    }
}

