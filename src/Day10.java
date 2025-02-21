
import java.util.*;

public class Day10 {

    public static Integer countTrails( String part, ArrayList<String> matrix) {
        int total = 0;
        ArrayList<ArrayList<Integer>> trailHeads= findTrailHeads(matrix);
        int allPathsCount = 0;
        for (ArrayList<Integer> XY: trailHeads ){
            Set<ArrayList<Integer>> visitedCoordinates = walkTrailHeads("one",XY.get(0),XY.get(1),matrix);
            int pathsCount = walkTrailHeads("two",XY.get(0),XY.get(1),matrix);
            Integer count = countCompleteTrails(visitedCoordinates,matrix);
            allPathsCount+=pathsCount;
            total+=count;
            }

        if (part.equals("one")) return total;
        return allPathsCount;

    }

    public static Integer countCompleteTrails(Set<ArrayList<Integer>> visitedCoordinates, ArrayList<String>matrix){
        Iterator<ArrayList<Integer>> i = visitedCoordinates.iterator();
        Integer count = 0;
        while (i.hasNext()){
            ArrayList<Integer> XY = i.next();
            int x = XY.get(0);
            int y = XY.get(1);
            Integer altitude = getValueAtCoordinate(x,y,matrix);
            if (altitude == 9) {
                count += 1;
            }
        }
        return count;

    }
    public static <T>T walkTrailHeads(String part,Integer x, Integer y, ArrayList<String> matrix) {
        ArrayList <ArrayList<Integer>> trails = new ArrayList<>();
        Set<ArrayList<Integer>> visitedCoordinates = new HashSet<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList <Integer> altitudeList = new ArrayList<>();
        Integer altitude = getValueAtCoordinate(x,y,matrix);
        Integer length = matrix.size();
        trails.add(new ArrayList<>(Arrays.asList(x,y)));
        visitedCoordinates.add(new ArrayList<>(Arrays.asList(x,y)));
        altitudeList.add(altitude);
        Integer distinctPathCount = 0;

        while (!trails.isEmpty()) {
            ArrayList<Integer> currentNode= trails.remove(trails.size()-1);
            altitude = altitudeList.remove(altitudeList.size()-1);
            x = currentNode.get(0);
            y = currentNode.get(1);
            if (altitude == 9) distinctPathCount+=1;
            if (
                x + 1 < length &&
                getValueAtCoordinate(x + 1, y, matrix) == altitude + 1 &&
                !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x+1,y))))
                ) {
                trails.add(new ArrayList<>(Arrays.asList(x+1, y)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x+1,y)));
                Integer tempAltitude = getValueAtCoordinate(x+1,y,matrix);
                paths.add(new ArrayList<>(Arrays.asList(x+1,y)));

                altitudeList.add(tempAltitude);

            }
            if (x - 1 >= 0 &&
                getValueAtCoordinate(x - 1, y, matrix) == altitude + 1 &&
                    !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x-1,y))))
                ) {
                trails.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x - 1,y)));
                Integer tempAltitude = getValueAtCoordinate(x-1,y,matrix);
                paths.add(new ArrayList<>(Arrays.asList(x - 1,y)));
                altitudeList.add(tempAltitude);
            }
            if (y + 1 < length &&
                getValueAtCoordinate(x, y + 1, matrix) == altitude + 1 &&
                !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x,y+1))))
            ) {
                trails.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x,y+1)));
                Integer tempAltitude = getValueAtCoordinate(x,y+1,matrix);
                paths.add(new ArrayList<>(Arrays.asList(x,y+1)));
                altitudeList.add(tempAltitude);
            }

            if (y - 1 >= 0 && getValueAtCoordinate(x, y - 1, matrix) == altitude + 1 &&
                    !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x,y-1)))))
            {
                trails.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x,y-1)));
                Integer tempAltitude = getValueAtCoordinate(x,y-1,matrix);
                paths.add(new ArrayList<>(Arrays.asList(x,y-1)));
                altitudeList.add(tempAltitude);
            }
            if (part.equals("two")) visitedCoordinates.remove(currentNode);
        }
        if (part.equals("two")) return (T) distinctPathCount;
        return (T) visitedCoordinates;
    }

    private static Integer getValueAtCoordinate(Integer x, Integer y, ArrayList<String> matrix) {
    return Integer.parseInt(String.valueOf(matrix.get(x).charAt(y)));
    }

    private static ArrayList<ArrayList<Integer>> findTrailHeads(ArrayList<String> matrix){
        ArrayList<ArrayList<Integer>> trailHeadCoordinates= new ArrayList<>();
        for (int x=0;x<matrix.size();x++ ){
            for (int y=0;y<matrix.size();y++){
                if ( getValueAtCoordinate(x,y,matrix)==0) trailHeadCoordinates.add(new ArrayList<Integer> (Arrays.asList(x,y)));
            }
        }
        System.out.println("There are: "+trailHeadCoordinates.size()+" trailheads");
        return trailHeadCoordinates;
    }

}
