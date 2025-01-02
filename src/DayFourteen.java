import java.util.ArrayList;

public class DayFourteen{
    public static ArrayList<Robot> putRobotsAtStartingPosition(ArrayList<String> input, Integer height, Integer width) {
        ArrayList<Robot> allRobots = new ArrayList<>();
        for (String each : input) {
            ArrayList<Integer> coordinates = Regex.getNumbersWithSigns(each);
            Integer startingX = coordinates.get(0);
            Integer startingY = coordinates.get(1);
            Integer movingX = coordinates.get(2);
            Integer movingY = coordinates.get(3);
            Robot newRobot = new Robot(startingX, startingY, movingX, movingY, height, width);
            allRobots.add(newRobot);
        }
        return allRobots;
    }
}
