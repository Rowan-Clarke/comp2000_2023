import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Actor {
    //fields
    Cell pos;
    Color colour = Color.PINK;
    //constructors
    Actor(Cell cell){
        pos = cell;
    }
    //methods
    public void paint(Graphics g){
        g.setColor(colour);
        g.fillRect(pos.x, pos.y, pos.size, pos.size);
        g.setColor(Color.BLACK);
        g.drawRect(pos.x, pos.y, pos.size, pos.size);
    }
}
