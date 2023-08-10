import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle {
  // fields
  int x;
  int y;
  static int size = 35;

  // constructors
  public Cell(int inX, int inY) {
    super(inX, inY, size, size);
    x = inX;
    y = inY;
  }

  // methods
  public void paint(Graphics g, Point mousePos) {
    if (mousePos == null){
      g.setColor(Color.WHITE);
    }
    else{
      if(super.contains(mousePos) == true) {
        g.setColor(Color.GRAY);
      } else {
        //255-(255*(x/710)
        //g.setColor(new Color(255*(x/710),255-(255*((x+y)/710)/2),255*(y/710)));
        g.setColor(Color.WHITE);
      }
    }
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }

  // public boolean contains(Point p) {
  //   if(p != null) {
  //     return x < p.x && x+size > p.x && y < p.y && y+size > p.y;
  //   } else {
  //     return false;
  //   }
  // }
}
