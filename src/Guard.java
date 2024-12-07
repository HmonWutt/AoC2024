import java.util.*;

public class Guard {
    ArrayList<String> matrix;
    int X;
    int Y;
    public void go(String direction) {
        if (direction == "U") {
            this.X -= 1;
            // System.out.println("GO UP");
        } else if (direction == "D") {
            this.X += 1;
            //System.out.println("GO DOWN");
        } else if (direction == "L") {
            this.Y -= 1;
            //System.out.println("GO LEFT");
        } else {
            this.Y += 1;
            // System.out.println("GO RIGHT");
        }

    }

    public boolean isObstacle(String currentDIrection,ArrayList<String> matrix) {
        char currentSpot;
        if (Objects.equals(currentDIrection, "U")) currentSpot = matrix.get(this.X - 1).charAt(this.Y);
        else if (Objects.equals(currentDIrection,"D"))currentSpot = matrix.get(this.X + 1).charAt(this.Y);
        else if (Objects.equals(currentDIrection, "L"))currentSpot = matrix.get(this.X).charAt(this.Y - 1);
        else currentSpot = matrix.get(this.X).charAt(this.Y + 1);
        return currentSpot == '#';
    }
    public String findClearPath(String currentDIrection,ArrayList<String> matrix) {

        char currentSpot = '#';
        ArrayList<Integer> XY = new ArrayList<>();
        int X = this.X;
        int Y = this.Y;
        String newDirection = "";
        String currentCoordinatesAndDirection = "";
        Set<String> path = new HashSet<>();
        int upperLimit = matrix.size();
        while (currentSpot == '#' && (X >= 0 && X <= upperLimit - 1) && (Y >= 0 && Y <= upperLimit - 1)){
            path = new HashSet<>();
            if (path.contains(currentCoordinatesAndDirection)){
                return "";}
            if (Objects.equals(currentDIrection, "U")) {
                currentSpot = matrix.get(X - 1).charAt(Y);
                if (currentSpot == '#') {
                    newDirection = chooseDirection("U");
                    Y += 1;
                }
            } else if (Objects.equals(currentDIrection, "D")) {
                currentSpot = matrix.get(X + 1).charAt(Y);
                if (currentSpot == '#') {
                    newDirection = chooseDirection("D");
                    Y -= 1;
                }
            } else if (Objects.equals(currentDIrection, "L")) {
                currentSpot = matrix.get(X).charAt(Y - 1);
                if (currentSpot == '#') {
                    newDirection = chooseDirection("L");
                    X -= 1;
                }
            } else {
                currentSpot = matrix.get(X).charAt(Y + 1);

                if (currentSpot == '#')
                {
                    newDirection = chooseDirection("R");
                    X += 1;
                }

            }
            currentCoordinatesAndDirection = "(" + X + "," + Y + "," + newDirection + ")";
            path.add(currentCoordinatesAndDirection);

        }
        return newDirection;
    }
    public static ArrayList<Integer> findStartPosition(ArrayList<String> matrix) {
        int x=0;
        int y=0;
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (int X = 0; X < matrix.size(); X++) {
            x = X;
            if (matrix.get(X).indexOf('^') > 0) {
                y= matrix.get(X).indexOf('^');
                coordinates.add(x);
                coordinates.add(y);
            }
        }
        return coordinates;
    }

    public String chooseDirection(String currentDIrection) {
        if (Objects.equals(currentDIrection,"U")) return "R";
        else if (Objects.equals(currentDIrection,"D")) return "L";
        else if (Objects.equals(currentDIrection,"L")) return "U";
        return "D";
    }
    public boolean navigateMatrix(ArrayList<String> matrix,boolean isPartOne) {
        Set<String> uniqueSpots = new HashSet<>();
        ArrayList<Integer> coordinates = findStartPosition(matrix);
        this.X = coordinates.get(0);
        this.Y =coordinates.get(1);
        int XUpperLimit = matrix.size();
        int YUpperLimit = matrix.get(0).length();
        String currentDirection = "U";
        boolean isObstacle = false;
        Set<String> path = new HashSet<>();

        boolean isInLoop = false;
        while ((this.X > 0 && this.X < XUpperLimit - 1) && (this.Y > 0 && this.Y < YUpperLimit - 1)) {
            if (isPartOne) {
                String currentCoordinates = "(" + this.X + "," + this.Y + ")";
                uniqueSpots.add(currentCoordinates);
            }
            String currentCoordinatesAndDirection = "(" + this.X + "," + this.Y + ","+currentDirection+")";
            if ( path.contains(currentCoordinatesAndDirection)){
                {
                    isInLoop=true;
                    break;
                }
            }
            if (isInLoop) break;
            path.add(currentCoordinatesAndDirection);
            isObstacle = isObstacle(currentDirection, matrix);
            while(isObstacle) {
                currentDirection = findClearPath(currentDirection,matrix);
                if (currentDirection.isEmpty()) {
                    isInLoop = true;
                    break;
                }
                isObstacle = isObstacle(currentDirection, matrix);
            }
            go(currentDirection);
        }
        if (isPartOne) {
            int numUniqueSpots = uniqueSpots.size()+1;
            System.out.println("Unique spots: "+ numUniqueSpots);
        }
        return isInLoop;
    }


    public ArrayList<String> putObstacle(int x, int y, ArrayList<String> matrix) {
        ArrayList<String> newMatrix = new ArrayList<>();
        String newString = "";
        for (int j = 0; j < matrix.size(); j++) {
            if (j == x) {
                String toModify = matrix.get(x);
                for (int i = 0; i < toModify.length(); i++) {
                    if (i == y) {
                        newString += '#';
                    }
                    else {
                        newString += toModify.charAt(i);
                    }
                }
                newMatrix.add( newString);
            }
            else{
                newMatrix.add(matrix.get(j));
            }
        }
        return newMatrix;
    }
    public void decidePositionOfObsticle(ArrayList<String> matrix){
        int count =0;
        ArrayList<Integer> coordinates = findStartPosition(matrix);
        final int xToSkip = coordinates.get(0);
        final int yToSkip =coordinates.get(1);
        ArrayList<String> newMatrix = new ArrayList<>();
        float it = 0;
        String coordinateXY = "";
        boolean isLoop = false;
        for (int x=0;x<matrix.size();x++){
            for (int y=0;y<matrix.size();y++){
                if (++it % 100==0)
                    System.out.println(it/(matrix.size()*matrix.size()));
                if (!(x==xToSkip && y==yToSkip)){
                    String XY = "("+x+","+y+")"+",";
                    coordinateXY+=XY;
                    newMatrix = putObstacle(x,y,matrix);
                    isLoop = navigateMatrix(newMatrix,false);
                    if (isLoop) {
                        count += 1;

                        /*for (String each : newMatrix) {
                            System.out.print(each);
                            System.out.println();

                        }
                        System.out.println("=======================================================");*/
                    }
                }

            }
        }
        //System.out.println("["+coordinateXY+"]");
        System.out.println("in loop"+count);
    }
}