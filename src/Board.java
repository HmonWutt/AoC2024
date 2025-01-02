import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private Quadrant quartOne;
    private Quadrant quartTwo;
    private Quadrant quartThree;
    private Quadrant quartFour;
    private final Integer height;
    private final Integer width;

    public Board(Integer height, Integer width){
        this.quartOne = new Quadrant("One");
        this.quartTwo = new Quadrant("Two");
        this.quartThree = new Quadrant("Three");
        this.quartFour = new Quadrant("Four");
        this.width = width;
        this.height = height;

    }
    public Integer getWidth(){
        return this.width;
    }
    public Integer getHeight(){
        return this.height;
    }
    public Integer countRobots(Integer X, ArrayList<Robot> allRobots){
        moveRobotsXnumberOfTimes(X,allRobots);

      /*   String [][] matrix = new String[this.width+1][this.height+1];
       for (int i = 0; i < matrix.length; i++) {         // Loop through rows
            for (int j = 0; j < matrix[i].length; j++) {  // Loop through columns
                matrix[i][j] =".";
            }
        }*/
        /*for (Robot each:allRobots){
            checkRobotsInEachQuadrant(each);
            Integer occupiedPositionsInOne = this.quartOne.countNumberOfOccupiedPositions();
            Integer occupiedPositionsInTwo = this.quartTwo.countNumberOfOccupiedPositions();
            Integer occupiedPositionsInThree = this.quartThree.countNumberOfOccupiedPositions();
            Integer occupiedPositionsInFour = this.quartFour.countNumberOfOccupiedPositions();
            if ((occupiedPositionsInOne== occupiedPositionsInTwo) &&
                    (occupiedPositionsInThree == occupiedPositionsInFour) &&
                    occupiedPositionsInOne < occupiedPositionsInThree) {
                System.out.println("Number of iterations: "+count);
                System.out.println(occupiedPositionsInOne +"," +occupiedPositionsInTwo +"," +occupiedPositionsInThree +"," +occupiedPositionsInFour);
                //return count;
            }*/


          /*  if (count>45000) {
                matrix[each.getCurrentX()][each.getCurrentY()] = "#";
                for (int i = 0; i < matrix.length / 2; i++) {         // Loop through rows
                    for (int j = 0; j < matrix[i].length / 2; j++) {  // Loop through columns
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println("");
                }
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            }
            //System.out.println(occupiedPositionsInOne +"," +occupiedPositionsInTwo +"," +occupiedPositionsInThree +"," +occupiedPositionsInFour);

        }*/

        Integer robotsInOne = this.quartOne.countRobotsInQuadrant();
        Integer robotsInTwo = this.quartTwo.countRobotsInQuadrant();
        Integer robotsInThree = this.quartThree.countRobotsInQuadrant();
        Integer robotsInFour = this.quartFour.countRobotsInQuadrant();
        return robotsInOne * robotsInTwo * robotsInThree * robotsInFour;
    }
    public void removeRobotPositionFromAllQuadrants(Robot robot){
                this.quartFour.removeRobotPositionFromQuadrant(robot);
                this.quartOne.removeRobotPositionFromQuadrant(robot);
                this.quartTwo.removeRobotPositionFromQuadrant(robot);
                this.quartThree.removeRobotPositionFromQuadrant(robot);
    }
    public void addRobotToQuadrant(String quadrantName, Robot newRobot){
        switch (quadrantName) {
            case "one":
                this.quartOne.addRobot(newRobot);
                this.quartFour.removeRobot(newRobot);
                this.quartTwo.removeRobot(newRobot);
                this.quartThree.removeRobot(newRobot);
                break;
            case "two":
                this.quartTwo.addRobot(newRobot);
                this.quartOne.removeRobot(newRobot);
                this.quartThree.removeRobot(newRobot);
                this.quartFour.removeRobot(newRobot);
                break;
            case "three":
                this.quartThree.addRobot(newRobot);
                this.quartOne.removeRobot(newRobot);
                this.quartTwo.removeRobot(newRobot);
                this.quartFour.removeRobot(newRobot);
                break;
            default:
                this.quartFour.addRobot(newRobot);
                this.quartOne.removeRobot(newRobot);
                this.quartTwo.removeRobot(newRobot);
                this.quartThree.removeRobot(newRobot);
        }

    }

    public void moveRobotsXnumberOfTimes(Integer X,ArrayList<Robot> allRobots){

        for (int i1 = 0; i1<X; i1++){
            for(Robot each:allRobots){
                removeRobotPositionFromAllQuadrants(each);
                each.updatePosition();
                checkRobotsInEachQuadrant(each);
            }
        Integer occupiedPositionsInOne = this.quartOne.countNumberOfOccupiedPositions();
            Integer occupiedPositionsInTwo = this.quartTwo.countNumberOfOccupiedPositions();
            Integer occupiedPositionsInThree = this.quartThree.countNumberOfOccupiedPositions();
            Integer occupiedPositionsInFour = this.quartFour.countNumberOfOccupiedPositions();
            //System.out.println(i+"----"+occupiedPositionsInOne +"," +occupiedPositionsInTwo +"," +occupiedPositionsInThree +"," +occupiedPositionsInFour);
            if ((occupiedPositionsInOne== occupiedPositionsInTwo) &&
                    (occupiedPositionsInThree == occupiedPositionsInFour)) //&&
                   // occupiedPositionsInOne < occupiedPositionsInThree)
            {String [][] matrix = new String[this.width+1][this.height+1];
                for (int i = 0; i < matrix.length; i++) {         // Loop through rows
                    for (int j = 0; j < matrix[i].length; j++) {  // Loop through columns
                        matrix[i][j] =".";
                    }
                }
                for(Robot each:allRobots){
                    matrix[each.getCurrentX()][each.getCurrentY()] = "#";
                }
                for (int i = 0; i < matrix.length / 2; i++) {
                    for (int j = 0; j < matrix[i].length / 2; j++) {  // Loop through columns
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println("");
                }
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println(i1+"----"+occupiedPositionsInOne +"," +occupiedPositionsInTwo +"," +occupiedPositionsInThree +"," +occupiedPositionsInFour);
                //return count;
            }
        }
    }
    public void checkRobotsInEachQuadrant(Robot newRobot){
        Integer robotX = newRobot.getCurrentX();
        Integer robotY = newRobot.getCurrentY();
        Integer firstQuadrantStartX = 0;
        Integer firstQuadrantEndX = (this.width/2)-1;
        Integer secondQuadrantStartX =  firstQuadrantEndX +2;
        Integer secondQuadrantEndX =  this.width;
        Integer firstQuadrantStartY = 0;
        Integer firstQuadrantEndY = (this.height/2)-1;
        Integer secondQuadrantStartY =  0;

        Integer thirdQuadrantStartY = firstQuadrantEndY+2;
        Integer thirdQuadrantEndY = this.height;

        if ((robotX>= firstQuadrantStartX && robotX<= firstQuadrantEndX) &&
            (robotY>= firstQuadrantStartY && robotY<= firstQuadrantEndY)){
            addRobotToQuadrant("one", newRobot);
            this.quartOne.addRobotPositionToQuadrant(newRobot);

        }
        else if ((robotX>= secondQuadrantStartX && robotX<= secondQuadrantEndX) &&
                (robotY>= firstQuadrantStartY && robotY<= firstQuadrantEndY)){
            addRobotToQuadrant("two", newRobot);
            this.quartTwo.addRobotPositionToQuadrant(newRobot);
        }
        else if ((robotX>= firstQuadrantStartX && robotX<= firstQuadrantEndX) &&
                (robotY>= thirdQuadrantStartY && robotY<= thirdQuadrantEndY)){
            addRobotToQuadrant("three", newRobot);
            this.quartThree.addRobotPositionToQuadrant(newRobot);
        }
        else if ((robotX>= secondQuadrantStartX && robotX<= secondQuadrantEndX) &&
                (robotY>= thirdQuadrantStartY && robotY<= thirdQuadrantEndY)){
            addRobotToQuadrant("four", newRobot);
            this.quartFour.addRobotPositionToQuadrant(newRobot);
        }

    }


}
