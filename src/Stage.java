import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Stage {
    //fields
    Grid grid;
    Actor[] actors;
    //int gridSize;
    //constructors
    Stage(){
        grid = new Grid();
        actors = new Actor[3];
        actors[0] = new Bird(grid.cells[8][5]);
        actors[1] = new Cat(grid.cells[15][17]);
        actors[2] = new Dog(grid.cells[7][2]);
    }
    //methods
    void paint(Graphics g, Point mousePos){
        grid.paint(g, mousePos);
        for (int i = 0; i < actors.length; i++){
            actors[i].paint(g);
        }
        
    }

    // void addActor(Actor a){
    //     Actor[] temp = new Actor[actors.length+1];
    //     for (int i = 0; i < actors.length; i++){
    //         temp[i] = actors[i];
    //     }
    //     temp[actors.length] = a;
    //     actors = temp;
    // }
}
