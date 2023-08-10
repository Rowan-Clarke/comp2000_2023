import javax.swing.*;
import java.awt.*;

public class Grid{
        int width,height,cellSize,offset;
        Cell[][] grid;

        public Grid(){
            this.width = 10;
            this.height = 10;
            this.cellSize = 10;
            this.offset = 10;
            this.grid = new Cell[width][height];
            for (int i = 0; i < width; i++){
                for (int j = 0; j < height; j++){
                    grid[i][j] = new Cell(i,j,cellSize,offset);
                }
            }
        }

        public Grid(int gridSize, int size){
            this.width = gridSize;
            this.height = gridSize;
            this.cellSize = size;
            this.offset = 10;
            this.grid = new Cell[width][height];
            populateGridColourful();
        }

        public Grid(int xSize, int ySize, int offsetSize, int size){
            this.width = xSize;
            this.height = ySize;
            this.cellSize = size;
            this.offset = offsetSize;
            this.grid = new Cell[width][height];
            populateGrid();
        }

        private void populateGrid(){
            for (int i = 0; i < this.width; i++){
                for (int j = 0; j < this.height; j++){
                    this.grid[i][j] = new Cell(i,j,this.cellSize,this.offset);
                }
            } 
        }

        private void populateGridColourful(){
            for (int i = 0; i < this.width; i++){
                for (int j = 0; j < this.height; j++){
                    //Color newColour = new Color(255*(i/width),255*(((j+i)/height)/2),255*(j/height));
                    //Color newColour = new Color(i*(255/width),((i+j)*(255/width))/2,j*(255/width));
                    Color newColour = new Color(i*(255/width),(255-(j+i*(255/width)/2))/2,j*(255/width));

                    this.grid[i][j] = new Cell(i,j,this.cellSize,this.offset, newColour);
                }
            } 
        }

        public void drawGrid (Graphics g){
            for (int i = 0; i < this.width; i++){
                for (int j = 0; j < this.height; j++){
                    Cell c = this.grid[i][j];
                    c.drawCell(g);
                }
            }
        }

        public void drawGridWithMouse (Graphics g, Integer mX, Integer mY){
            if (mX == null || mY == null){
                return;
            }
            for (int i = 0; i < this.width; i++){
                for (int j = 0; j < this.height; j++){
                    Cell c = this.grid[i][j];
                    if (collide(mX, mY, c.xcoord, c.ycoord, c.xcoord + c.size, c.ycoord + c.size) == true){
                        //c.drawHighlightedCell(g);
                        c.drawCell(g, Color.GREEN);
                    }
                    else{
                        c.drawCell(g);
                    }
                }
            }
        }

        public boolean collide (int x1, int y1, int x2, int y2, int x3, int y3){
            if (x1 >= x2 && x1 <= x3){
                if (y1 >= y2 && y1 <= y3){
                    return true;
                }
            }
            return false;
        }


    }