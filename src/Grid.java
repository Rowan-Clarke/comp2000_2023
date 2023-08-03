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
                    Color newColour = new Color(i*12,((i+j)*12)/2,j*12);
                    this.grid[i][j] = new Cell(i,j,this.cellSize,this.offset, newColour);
                }
            } 
        }

        public void drawGrid (Graphics g){
            Point mousePos = new Point(0,0);
            double mX = mousePos.getX();
            double mY = mousePos.getY();
            for (int i = 0; i < this.width; i++){
                for (int j = 0; j < this.height; j++){
                    Cell c = this.grid[i][j];
                    c.drawCell(g);
                    // if (mX >= sX && mX <= sX+c.size && mY >= sY && mY <= sY+c.size){
                    //     c.drawHighlightedCell(g);
                    // }
                    // else{
                    //    c.drawCell(g);
                    // }
                }
            }
        }


    }