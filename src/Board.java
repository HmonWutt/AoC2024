import java.util.ArrayList;

public class Board {
    private Quadrant quartOne;
    private Quadrant quartTwo;
    private Quadrant quartThree;
    private Quadrant quartFour;
    private final Integer height;
    private final Integer width;

    public Board(Integer height, Integer width) {
        this.quartOne = new Quadrant("One");
        this.quartTwo = new Quadrant("Two");
        this.quartThree = new Quadrant("Three");
        this.quartFour = new Quadrant("Four");
        this.width = width;
        this.height = height;

    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer countRobots(Integer X, ArrayList<Robot> allRobots) {
        moveRobotsXnumberOfTimes(X, allRobots);
        for (Robot each : allRobots) {
            checkRobotsInEachQuadrant(each);
        }
        Integer robotsInOne = this.quartOne.countRobotsInQuadrant();
        Integer robotsInTwo = this.quartTwo.countRobotsInQuadrant();
        Integer robotsInThree = this.quartThree.countRobotsInQuadrant();
        Integer robotsInFour = this.quartFour.countRobotsInQuadrant();
        return robotsInOne * robotsInTwo * robotsInThree * robotsInFour;
    }

    public void addRobotToQuadrant(String quadrantName, Robot newRobot) {
        switch (quadrantName) {
            case "one":
                this.quartOne.addRobot(newRobot);
                break;
            case "two":
                this.quartTwo.addRobot(newRobot);
                break;
            case "three":
                this.quartThree.addRobot(newRobot);
                break;
            default:
                this.quartFour.addRobot(newRobot);
        }

    }
    public void moveRobotsXnumberOfTimes(Integer X,ArrayList<Robot> allRobots){
        for (int i = 0; i<X; i++){
            for(Robot each:allRobots){
                each.updatePosition();
            }
        }
    }
    public void findXmasTree(Integer X, ArrayList<Robot> allRobots) {
        for (int i1 = 1; i1 < X; i1++) {
            for (Robot each : allRobots) {
                each.updatePosition();
            }
            String[][] matrix = new String[this.width + 1][this.height + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = ".";///row and col switched to make tree upright
                }
            }
            for (Robot each : allRobots) {
                matrix[each.getCurrentX()][each.getCurrentY()] = "#";
            }

            Robot firstRobot = allRobots.get(0);
            Integer count = XmasTree.countNeighbours( firstRobot.getCurrentX(),firstRobot.getCurrentY(), matrix);
            if (count>15){
                System.out.println("iteration: "+i1+","+count);
                for (int i =( matrix.length/2)-2; i < matrix.length; i++) {         // Loop through rows
                    for (int j = ( matrix.length/2)-(matrix.length/4);j<( matrix.length/2)+(matrix.length/2); j++) {  // Loop through columns
                        System.out.print(matrix[j][i]);
                    }
                    System.out.println();
                }
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
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

        }
        else if ((robotX>= secondQuadrantStartX && robotX<= secondQuadrantEndX) &&
                (robotY>= firstQuadrantStartY && robotY<= firstQuadrantEndY)){
            addRobotToQuadrant("two", newRobot);
        }
        else if ((robotX>= firstQuadrantStartX && robotX<= firstQuadrantEndX) &&
                (robotY>= thirdQuadrantStartY && robotY<= thirdQuadrantEndY)){
            addRobotToQuadrant("three", newRobot);
        }
        else if ((robotX>= secondQuadrantStartX && robotX<= secondQuadrantEndX) &&
                (robotY>= thirdQuadrantStartY && robotY<= thirdQuadrantEndY)){
            addRobotToQuadrant("four", newRobot);
        }

    }


}
