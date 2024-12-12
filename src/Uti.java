import java.util.ArrayList;

public class Uti {
    public static int getYcoponent(Node one, Node two) {
        return one.getY() - two.getY();
    }

    public static int getXcomponent(Node one, Node two) {
        return one.getX() - two.getX();
    }

    public static Antinode createAntinode(int x, int y) {
        return new Antinode(x, y);
    }

    public static boolean isInBound(int x, int y, int bound) {
        return (x >= 0 && x < bound && y >= 0 && y < bound);
    }

    public static ArrayList<String> makeNewMatrices(ArrayList<Node> nodes ,ArrayList<String> matrix, int bound, boolean isPartOne) {
        ArrayList<String> matrixPartOne = new ArrayList<>(matrix);
        int scalarSame = 2;
        int sameDirectionTwiceMagnitudeX ;
        int sameDirectionTwiceMagnitudeY;
        int oppositeDirectionSameMagnitudeX ;
        int oppositeDirectionSameMagnitudeY;

        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                //System.out.println(i + "," + j);
                if (nodes.get(i).frequency.equals(nodes.get(j).frequency)) {
                    Components parameters = new Components(nodes, i, j);
                    int xOrigin = parameters.xOrigin;
                    int yOrigin = parameters.yOrigin;
                    int xComponent = parameters.xComponent;
                    int yComponent = parameters.yComponent;
                    sameDirectionTwiceMagnitudeX = xOrigin + scalarSame * xComponent;
                    sameDirectionTwiceMagnitudeY = yOrigin + scalarSame * yComponent;
                    if (isPartOne) {
                        if (Uti.isInBound(sameDirectionTwiceMagnitudeX, sameDirectionTwiceMagnitudeY, bound)) {
                            matrixPartOne = Uti.markAntinodes(matrixPartOne, sameDirectionTwiceMagnitudeX, sameDirectionTwiceMagnitudeY);
                        }
                    }
                    while (Uti.isInBound(sameDirectionTwiceMagnitudeX, sameDirectionTwiceMagnitudeY, bound)) {
                        matrix = Uti.markAntinodes(matrix, sameDirectionTwiceMagnitudeX, sameDirectionTwiceMagnitudeY);
                        scalarSame += 1;
                        sameDirectionTwiceMagnitudeX = xOrigin + scalarSame * xComponent;
                        sameDirectionTwiceMagnitudeY = yOrigin + scalarSame * yComponent;
                        ;
                    }
                    oppositeDirectionSameMagnitudeX = xOrigin - xComponent;
                    oppositeDirectionSameMagnitudeY = yOrigin - yComponent;
                    if (isPartOne){
                        if (Uti.isInBound(oppositeDirectionSameMagnitudeX, oppositeDirectionSameMagnitudeY, bound)) {
                            matrixPartOne = Uti.markAntinodes(matrixPartOne, oppositeDirectionSameMagnitudeX, oppositeDirectionSameMagnitudeY);
                        }
                    }

                    while (Uti.isInBound(oppositeDirectionSameMagnitudeX, oppositeDirectionSameMagnitudeY, bound)) {
                        matrix = Uti.markAntinodes(matrix,oppositeDirectionSameMagnitudeX,oppositeDirectionSameMagnitudeY);
                        oppositeDirectionSameMagnitudeX -= xComponent;
                        oppositeDirectionSameMagnitudeY -= yComponent;
                        ;
                    }
                }
                scalarSame=2;
            }
        }
        if (isPartOne) return matrixPartOne;
        return matrix;
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
    public static int countAntinodesPartOne(ArrayList<String > matrix){
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
    public static int countAntinodesPartTwo(ArrayList<String > matrix){
        int total = 0;
        for (int row = 0; row < matrix.size() ; row++) {
            for (int col = 0; col < matrix.size(); col++) {
                if (matrix.get(row).charAt(col) != '.') {
                    total += 1;
                }
            }
        }
        return total;
    }
    public static void printMatrix(ArrayList<String> matrix) {
        for (String each : matrix) System.out.println(each);
        System.out.println("-----------------------------------------------------------------------------");
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

