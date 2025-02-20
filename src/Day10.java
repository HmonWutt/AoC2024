import java.util.*;

public class Day10 {

    public static Integer countTrails( ArrayList<String> matrix) {
        Integer total = 0;
        ArrayList<ArrayList<Integer>> trailHeads= findTrailHeads(matrix);
        for (ArrayList<Integer> XY: trailHeads ){
            Set<ArrayList<Integer>> visitedCoordinates = walkTrailHeads(XY.get(0),XY.get(1),matrix);
            Integer count = countCompleteTrails(visitedCoordinates,matrix);
            //System.out.println(count+ " trails");
            total+=count;
            }
        return total;
    }
    public static Integer countCompleteTrails( Set<ArrayList<Integer>> visitedCoordinates,ArrayList<String>matrix){
        Iterator<ArrayList<Integer>> i = visitedCoordinates.iterator();
        Integer count = 0;
        while (i.hasNext()){
            ArrayList<Integer> XY = i.next();
            int x = XY.get(0);
            int y = XY.get(1);
            Integer altitude = getValueAtCoordinate(x,y,matrix);
            if (altitude == 9) count+=1;
        }
        return count;

    }
    public static Set<ArrayList<Integer>> walkTrailHeads(Integer x, Integer y,
                                  ArrayList<String> matrix) {
        ArrayList <ArrayList<Integer>> trails = new ArrayList<>();
        Set<ArrayList<Integer>> visitedCoordinates = new HashSet<>();
        ArrayList <Integer> altitudeList = new ArrayList<>();
        Integer altitude = getValueAtCoordinate(x,y,matrix);
        Integer length = matrix.size();
        trails.add(new ArrayList<>(Arrays.asList(x,y)));
        visitedCoordinates.add(new ArrayList<>(Arrays.asList(x,y)));
        altitudeList.add(altitude);
        while (!trails.isEmpty()) {
            ArrayList<Integer> coordinate = trails.remove(trails.size()-1);
            altitude = altitudeList.remove(altitudeList.size()-1);
            x = coordinate.get(0);
            y = coordinate.get(1);

            if (
                x + 1 < length &&
                getValueAtCoordinate(x + 1, y, matrix) == altitude + 1 &&
                !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x+1,y))))
                ) {
                trails.add(new ArrayList<>(Arrays.asList(x+1, y)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x+1,y)));
                Integer tempAltitude = getValueAtCoordinate(x+1,y,matrix);
                altitudeList.add(tempAltitude);
            }
            if (x - 1 >= 0 &&
                getValueAtCoordinate(x - 1, y, matrix) == altitude + 1 &&
                    !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x-1,y))))
                ) {
                trails.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x - 1,y)));
                Integer tempAltitude = getValueAtCoordinate(x-1,y,matrix);
                altitudeList.add(tempAltitude);
            }
            if (y + 1 < length &&
                getValueAtCoordinate(x, y + 1, matrix) == altitude + 1 &&
                !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x,y+1))))
            ) {
                trails.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x,y+1)));
                Integer tempAltitude = getValueAtCoordinate(x,y+1,matrix);
                altitudeList.add(tempAltitude);
            }

            if (y - 1 >= 0 && getValueAtCoordinate(x, y - 1, matrix) == altitude + 1 &&
                    !(visitedCoordinates.contains(new ArrayList<>(Arrays.asList(x,y-1)))))
            {
                trails.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                visitedCoordinates.add(new ArrayList<>(Arrays.asList(x,y-1)));
                Integer tempAltitude = getValueAtCoordinate(x,y-1,matrix);
                altitudeList.add(tempAltitude);
            }

        }
        return visitedCoordinates;


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
