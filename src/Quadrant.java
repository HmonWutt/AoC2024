import java.util.ArrayList;
import java.util.HashSet;
public class Quadrant {
    private String quadrantNumber;
    private ArrayList<Robot> robotsInQuadrant;
    private HashSet<String> numberOfOccupiedPositions;
    public Quadrant(String name){
        this.quadrantNumber = name;
        this.robotsInQuadrant= new ArrayList<>();
        this.numberOfOccupiedPositions = new HashSet<>();
    }
    public String getQuadrantNumber(){
        return this.quadrantNumber;
    }
    public void addRobot(Robot newRobot){
        this.robotsInQuadrant.add(newRobot);
        this.numberOfOccupiedPositions.add(newRobot.getCurrentX() +","+newRobot.getCurrentY());

    }
    public void removeRobot(Robot newRobot){
        this.robotsInQuadrant.remove(newRobot);

    }
    public void addRobotPositionToQuadrant(Robot robot){
        this.numberOfOccupiedPositions.add(robot.getCurrentX() +","+robot.getCurrentY());
    }
    public void removeRobotPositionFromQuadrant(Robot robot){
        this.numberOfOccupiedPositions.remove(robot.getCurrentX() +","+robot.getCurrentY());
    }
    public Integer countNumberOfOccupiedPositions(){
        return this.numberOfOccupiedPositions.size();
    }
    public Integer countRobotsInQuadrant(){
        return this.robotsInQuadrant.size();
    }

}
