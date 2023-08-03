import javax.swing.*;
import java.awt.*;

public class Cell{
        int x,y,xcoord,ycoord, size;
        Color colour,lineColour;
        public Cell(){
            this.x = 0;
            this.y = 0;
            this.xcoord = 0;
            this.ycoord = 0;
            this.size = 10;
            this.colour = Color.WHITE;
            this.lineColour = Color.BLACK;
        }
        public Cell(int i, int j, int size, int offset){
            this.x = i;
            this.y = j;
            this.size = size;
            this.xcoord = (i*size) + offset;
            this.ycoord = (j*size) + offset;
            this.colour = Color.WHITE;
            this.lineColour = Color.BLACK;
        }

        public Cell(int i, int j, int size, int offset, Color hue){
            this.x = i;
            this.y = j;
            this.size = size;
            this.xcoord = (i*size) + offset;
            this.ycoord = (j*size) + offset;
            this.colour = hue;
            this.lineColour = Color.BLACK;
        }

        public void drawCell(Graphics g){
            g.setColor(this.colour);
            g.fillRect(this.xcoord,this.ycoord,this.size, this.size);
            g.setColor(this.lineColour);
            g.drawRect(this.xcoord,this.ycoord,this.size, this.size);
        }

        public void drawHighlightedCell(Graphics g){
            g.setColor(Color.GREEN);
            g.fillRect(this.xcoord-5,this.ycoord-5,this.size+10, this.size+10);
            g.setColor(this.lineColour);
            g.drawRect(this.xcoord-5,this.ycoord-5,this.size+10, this.size+10);
        }
    }