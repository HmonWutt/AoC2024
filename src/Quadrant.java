import java.util.ArrayList;

public class Quadrant {
    private String quadrantNumber;
    private ArrayList<Robot> robotsInQuadrant;
    public Quadrant(String name){
        this.quadrantNumber = name;
        this.robotsInQuadrant= new ArrayList<>();
    }
    public String getQuadrantNumber(){
        return this.quadrantNumber;
    }
    public void addRobot(Robot newRobot){
        this.robotsInQuadrant.add(newRobot);
    }
    public Integer countRobotsInQuadrant(){
        return this.robotsInQuadrant.size();
    }

}
