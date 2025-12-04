import java.util.ArrayList;
import java.util.List;

public class PaperRoll {
    private int x;
    private int y;
    private int neighbours;
    static String[] grid;
    int edge ;
    PaperRoll(int x, int y){
        this.x = x;
        this.y = y;
        this.edge = grid.length;
    }
    public static void makeGrid (String[] grid){
        PaperRoll.grid = grid;

    }

    public int getNeighbours() {
        int[] directions = {0,1,-1};
        for (int x1 : directions){
            for (int y1: directions){
                int newX = x+x1;
                int newY = y+y1;
//                if (x == 0 || newX == edge){
//                    this.increaseNeighbours(1   );
//                }
//                if (y==0 || newY == edge){
//                    this.increaseNeighbours(1);
//                }
                if ((0<=newX && newX < this.edge) && (0<=newY && newY <  this.edge) && (PaperRoll.grid[newX].charAt(newY) =='@')){

                    this.increaseNeighbours(1);
                }
            }
        }
        return neighbours;
    }

    private void increaseNeighbours(int count){
        this.neighbours+=count;
    }
}
