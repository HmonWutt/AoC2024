import java.util.*;

public class Guard {
    ArrayList<String> matrix;
    int X;
    int Y;
    public Guard(ArrayList<String> matrix){
        this.matrix = matrix;
        findStartPosition();

    }
    public void coordinates (int X,int Y){
        this.X = X;
        this.Y = Y;
    }

    public void go(String direction){
        if (direction=="U"){
            this.X -=1;
           // System.out.println("GO UP");
        }
        else if (direction=="D"){
            this.X +=1;
            //System.out.println("GO DOWN");
        }
        else if (direction=="L"){
            this.Y -=1;
            //System.out.println("GO LEFT");
        }
        else{
            this.Y +=1;
           // System.out.println("GO RIGHT");
        }

    }
    public boolean isObstacle(String currentDIrection){
        char currentSpot ;
        if (currentDIrection=="U") currentSpot = this.matrix.get(this.X-1).charAt(this.Y);
        else if(currentDIrection == "D") currentSpot = this.matrix.get(this.X+1).charAt(this.Y);
        else if (currentDIrection == "L") currentSpot = this.matrix.get(this.X).charAt(this.Y-1);
        else currentSpot = this.matrix.get(this.X).charAt(this.Y+1);
        //if (currentSpot == '#')  System.out.println("Obstacle "+currentDIrection);
        return currentSpot =='#';
    }
    public void findStartPosition(){
        for (int X=0; X< this.matrix.size();X++) {
            this.X = X;
            if (this.matrix.get(X).indexOf("^")>0){
                this.Y = this.matrix.get(X).indexOf("^");
                return;
            }
        }
    }
    public String chooseDirection(String currentDIrection){
        if (currentDIrection=="U") return "R";
        else if(currentDIrection == "D") return "L";
        else if (currentDIrection == "L") return "U";
        return "D";
    }

    public int navigateMatrix() {
        Set<String> uniqueSpots = new HashSet<>();
        int XUpperLimit = this.matrix.size();
        int YUpperLimit = this.matrix.get(0).length();
        String currentDirection = "U";
        boolean isObstacle = false;
        try {
            while ((this.X > 0 && this.X < XUpperLimit - 1) && (this.Y > 0 && this.Y < YUpperLimit - 1)) {
                String currentCoordinates = this.X + "," + this.Y;
                uniqueSpots.add(currentCoordinates);
                go(currentDirection);
                isObstacle = isObstacle(currentDirection);

                //if (!isObstacle && (this.X-1 == 0 |this.X+1 == XUpperLimit - 1| this.Y-1 == 0 | this.Y+1 == YUpperLimit - 1)) break;
                if (isObstacle) {
                    //System.out.println("Met obstacle");
                    currentDirection = chooseDirection(currentDirection);
                }
            }
        } catch (Exception e) {
            String currentCoordinates = this.X + "," + this.Y;
            uniqueSpots.add(currentCoordinates);
            System.out.println("Found way out!Leaving the matrix!!@ "+this.X+","+this.Y);
        }
        return uniqueSpots.size();
    }

}

