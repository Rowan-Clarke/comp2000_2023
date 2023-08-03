import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        //System.out.println("Red vs. Blue");
        Main window = new Main();
    }
    
    class Cell{
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

        public Cell(int i, int j, int size, int offset, Color colour){
            this.x = i;
            this.y = j;
            this.size = size;
            this.xcoord = (i*size) + offset;
            this.ycoord = (j*size) + offset;
            this.colour = colour;
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
    class Grid{
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
            for (int i = 0; i < this.width; i++){
                for (int j = 0; j < this.height; j++){
                    this.grid[i][j] = new Cell(i,j,this.cellSize,this.offset);
                }
            }
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
                    Color newColour = new Color(255*(i/255),200,255*(j/255));
                    this.grid[i][j] = new Cell(i,j,this.cellSize,this.offset, newColour);
                }
            } 
        }

        public void drawGrid (Graphics g){
            for (int i = 0; i < this.width; i++){
                for (int j = 0; j < this.height; j++){
                    Cell c = this.grid[i][j];
                    Point mousePos = getMousePosition();
                    int mX = mousePos.x;
                    int mY = mousePos.y;
                    int sX = c.x;
                    int sY = c.y;
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

    class Canvas extends JPanel{
        public Canvas(){
            setPreferredSize(new Dimension(720, 720));
        }
        @Override
        public void paint(Graphics g){
            Grid grid = new Grid(20,35);
            grid.drawGrid(g);
            // Grid grid = new Grid(20,35);
            //Grid grid = new Grid(30,5,100,10);
            // for (int i = 0; i < grid.width; i++){
            //     for (int j = 0; j < grid.height; j++){
            //         Cell x = grid.grid[i][j];
            //         g.setColor(x.colour);
            //         g.fillRect(x.xcoord,x.ycoord,x.size, x.size);
            //         g.setColor(x.lineColour);
            //         g.drawRect(x.xcoord,x.ycoord,x.size, x.size);
            //     }
            // } 

            // for (int i = 10; i < 710; i += 35){
            //     for (int j = 10; j<710; j+= 35){
            //         g.setColor(Color.BLACK);
            //         g.fillRect(i,j,35,35);
            //         g.setColor(Color.WHITE);
            //         g.drawRect(i,j,35,35);
            //     }
            // }
        }
    }

    private Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
        getMousePosition();
        // Grid grid = new Grid(30,5,100,10);
    }
}

