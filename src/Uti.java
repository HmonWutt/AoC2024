import java.util.ArrayList;

public class Uti {
    public static int getYcoponent(Node one, Node two) {
        return one.getY() - two.getY();
    }

    public static int getXcomponent(Node one, Node two) {
        return one.getX() - two.getX();
    }
    public static Antinode createAntinode(int x, int y){
        return new Antinode(x,y);
    }
    public static boolean isInBound(int x, int y,int bound) {
        return (x >=0 && x< bound && y>=0 && y<bound);
    }

    public static ArrayList<Node> getNodes(ArrayList<String> input) {
        int bound = input.size();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int row = 0; row < bound; row++) {
            for (int col = 0; col < bound; col++) {
                if (input.get(row).charAt(col) != '.') {
                    String frequency = Character.toString(input.get(row).charAt(col));
                    Node newNode = new Node(frequency, row, col);
                    nodes.add(newNode);
                }
            }
        }
        return nodes;
    }
    public static int countAntinodes(ArrayList<String > matrix){
        int total = 0;
        for (int row = 0; row < matrix.size() ; row++) {
            for (int col = 0; col < matrix.size(); col++) {
                if (matrix.get(row).charAt(col) == '#') {
                    total += 1;
                }
            }
        }
        return total;
    }
    public static void printMatrix(ArrayList<String> matrix) {
        for (String each : matrix) System.out.println(each);
        System.out.println("------------------------");
    }

    public static ArrayList<String> markAntinodes(ArrayList<String> matrix, int x, int y) {
        String temp = matrix.get(x);
        String newString = "";
        for (int k = 0; k < temp.length(); k++) {
            if (k != y) {
                newString += temp.charAt(k);
            } else {
                newString += "#";
            }
        }
        matrix.set(x, newString);
        return matrix;
    }
}

