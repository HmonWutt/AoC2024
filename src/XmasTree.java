import java.util.*;

public class XmasTree {
 public static Integer countNeighbours(Integer x0, Integer y0, String[][] matrix) {
     ArrayList<ArrayList<Integer>> unvisited = getUnvisitedPositions(matrix);
     Set<ArrayList<Integer>> visited = new HashSet<>();
     Deque<ArrayList<Integer>> deque = new ArrayDeque<>();
     ArrayList<Integer> XY = new ArrayList<>(Arrays.asList(x0, y0));
     visited.add(XY);
     unvisited.remove(XY);
     deque.addLast(XY);
     while (!deque.isEmpty()) {
         ArrayList<Integer> position = deque.removeFirst();
         Integer x = position.get(0);
         Integer y = position.get(1);
         if (!visited.contains(new ArrayList<>(Arrays.asList(x - 1, y))) &&
                 x - 1 >= 0 && matrix[x - 1][y] == "#") {
             deque.addLast(new ArrayList<>(Arrays.asList(x - 1, y)));
             visited.add(new ArrayList<>(Arrays.asList(x - 1, y)));
             unvisited.remove(new ArrayList<>(Arrays.asList(x - 1, y)));
         }
         if (!visited.contains(new ArrayList<>(Arrays.asList(x, y - 1))) &&
                 y - 1 >= 0 && matrix[x ][y-1] == "#") {
             deque.addLast(new ArrayList<>(Arrays.asList(x, y - 1)));
             visited.add(new ArrayList<>(Arrays.asList(x, y - 1)));
             unvisited.remove(new ArrayList<>(Arrays.asList(x, y - 1)));
         }
         if (!(visited.contains(new ArrayList<>(Arrays.asList(x + 1, y)))) &&
                 x + 1 < matrix.length && matrix[x +1][y] == "#") {
             deque.addLast(new ArrayList<>(Arrays.asList(x + 1, y)));
             visited.add(new ArrayList<>(Arrays.asList(x + 1, y)));
             unvisited.remove(new ArrayList<>(Arrays.asList(x + 1, y)));
         }
         if (!visited.contains(new ArrayList<>(Arrays.asList(x, y + 1))) &&
                 y + 1 < matrix[0].length && matrix[x][y+1] == "#") {
             deque.addLast(new ArrayList<>(Arrays.asList(x, y + 1)));
             visited.add(new ArrayList<>(Arrays.asList(x, y + 1)));
             unvisited.remove(new ArrayList<>(Arrays.asList(x, y + 1)));
         }

     }
     return visited.size();
 }
    public static ArrayList<ArrayList<Integer>> getUnvisitedPositions(String[][] matrix) {
        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
        for (int x = 0; x < matrix[0].length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                ArrayList<Integer> XY = new ArrayList<>(Arrays.asList(x, y));
                positions.add(XY);
            }
        }
        return positions;
    }

}
