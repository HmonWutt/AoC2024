import java.util.*;

public class GardenGroup {
    public static Integer countEdges(Integer x, Integer y, ArrayList<String> matrix) {
        char current = Utility.checkCharacterAtPosition(x, y, matrix);
        Integer total = 0;
        if (x - 1 < 0 || x - 1 >= 0 && Utility.checkCharacterAtPosition(x - 1, y, matrix) != current) {
            total += 1;
        }
        if (y - 1 < 0 || y - 1 >= 0 && Utility.checkCharacterAtPosition(x, y - 1, matrix) != current) {
            total += 1;
        }
        if (x + 1 >= matrix.size() || x + 1 < matrix.size() && Utility.checkCharacterAtPosition(x + 1, y, matrix) != current) {
            total += 1;
        }
        if (y + 1 >= matrix.size() || y + 1 < matrix.size() && Utility.checkCharacterAtPosition(x, y + 1, matrix) != current) {
            total += 1;
        }
        return total;
    }

    public static HashMap<Integer, ArrayList<Integer>> findGroups(ArrayList<String> matrix, Integer x0, Integer y0 ) {
        ArrayList<ArrayList<Integer>> unvisited = getUnvisitedPositions(matrix);
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dictionary = new HashMap<>();
        Integer groupNumber = 0;
         while (!unvisited.isEmpty()) {
             char current = Utility.checkCharacterAtPosition(x0, y0, matrix);
             Set<ArrayList<Integer>> visited = new HashSet<>();
             Set<ArrayList<Integer>> group = new HashSet<>();
             Deque<ArrayList<Integer>> deque = new ArrayDeque<>();
             ArrayList<Integer> XY = new ArrayList<>(Arrays.asList(x0, y0));
             visited.add(XY);
             unvisited.remove(XY);
             deque.addLast(XY);
             group.add(XY);
             while (!deque.isEmpty()) {
                 ArrayList<Integer> position = deque.removeFirst();
                 Integer x = position.get(0);
                 Integer y = position.get(1);

                 if (!visited.contains(new ArrayList<>(Arrays.asList(x - 1, y))) &&
                         x - 1 >= 0 && Utility.checkCharacterAtPosition(x - 1, y, matrix) == current) {
                     deque.addLast(new ArrayList<>(Arrays.asList(x - 1, y)));
                     visited.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                     group.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                     unvisited.remove(new ArrayList<>(Arrays.asList(x - 1, y)));
                 }
                 if (!visited.contains(new ArrayList<>(Arrays.asList(x, y - 1))) &&
                         y - 1 >= 0 && Utility.checkCharacterAtPosition(x, y - 1, matrix) == current) {
                     deque.addLast(new ArrayList<>(Arrays.asList(x, y - 1)));
                     visited.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                     unvisited.remove(new ArrayList<>(Arrays.asList(x, y - 1)));
                     group.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                 }
                 if (!(visited.contains(new ArrayList<>(Arrays.asList(x + 1, y)))) &&
                         x + 1 < matrix.size() && Utility.checkCharacterAtPosition(x + 1, y, matrix) == current) {
                     deque.addLast(new ArrayList<>(Arrays.asList(x + 1, y)));
                     visited.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                     unvisited.remove(new ArrayList<>(Arrays.asList(x + 1, y)));
                     group.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                 }
                 if (!visited.contains(new ArrayList<>(Arrays.asList(x, y + 1))) &&
                         y + 1 < matrix.size() && Utility.checkCharacterAtPosition(x, y + 1, matrix) == current) {
                     deque.addLast(new ArrayList<>(Arrays.asList(x, y + 1)));
                     visited.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                     unvisited.remove(new ArrayList<>(Arrays.asList(x, y + 1)));
                     group.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                 }
             }
             ArrayList<ArrayList<Integer>> positions = new ArrayList<>(group);
             dictionary.put(groupNumber,positions);
             group.clear();
             groupNumber+=1;
            if (!unvisited.isEmpty()) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(unvisited);
            ArrayList<Integer> newPosition = list.get(0);
            x0 = newPosition.get(0);
            y0 = newPosition.get(1);

        }

}
         return countEdgesEachGroup(dictionary,matrix);

    }

    public static HashMap<String, ArrayList<ArrayList<Integer>>> groupsAndEdges(ArrayList<String> matrix) {
        HashMap<String, ArrayList<ArrayList<Integer>>> dictionary = new HashMap<>();
        for (int x = 0; x < matrix.size(); x++) {
            for (int y = 0; y < matrix.size(); y++) {
                String character = String.valueOf(Utility.checkCharacterAtPosition(x, y, matrix));
                ArrayList<Integer> coordinates = new ArrayList<>(Arrays.asList(x, y));
                if (dictionary.containsKey(character)) {
                    ArrayList<ArrayList<Integer>> existingCoordinates = dictionary.get(character);
                    existingCoordinates.add(coordinates);
                    dictionary.put(character, existingCoordinates);
                } else {
                    dictionary.put(character, new ArrayList<>(Arrays.asList(coordinates)));
                }
            }
        }
        return dictionary;
    }

    public static HashMap<Integer, ArrayList<Integer>> countEdgesEachGroup(HashMap<Integer, ArrayList<ArrayList<Integer>>> dictionary, ArrayList<String> matrix) {
        HashMap<Integer, ArrayList<Integer>> edgeCount = new HashMap<>();
        for (Integer groupNumber : dictionary.keySet()) {
            ArrayList<ArrayList<Integer>> positions = dictionary.get(groupNumber);
            Integer total = 0;
            for (ArrayList<Integer> XY : positions) {
                total += countEdges(XY.get(0), XY.get(1), matrix);
            }
            edgeCount.put(groupNumber, new ArrayList<>(Arrays.asList(total, positions.size())));
        }
        return edgeCount;
    }

    public static ArrayList<ArrayList<Integer>> getUnvisitedPositions(ArrayList<String> matrix) {
        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
        for (int x = 0; x < matrix.size(); x++) {
            for (int y = 0; y < matrix.size(); y++) {
                ArrayList<Integer> XY = new ArrayList<>(Arrays.asList(x, y));
                positions.add(XY);
            }
        }
        return positions;
    }
}