import java.util.ArrayList;

public class OriginAndDistance {

    int xDistance;
    int yDistance;
    int xOrigin;
    int yOrigin;

    public OriginAndDistance(ArrayList<Node> nodes, int firstNodeIndex, int secondNodeIndex) {
        getOriginAndDistances( nodes, firstNodeIndex, secondNodeIndex);

    }

    private void getOriginAndDistances(ArrayList<Node> nodes, int firstNodeIndex, int secondNodeIndex) {

        if (nodes.get(firstNodeIndex).frequency.equals(nodes.get(secondNodeIndex).frequency)) {
            this.xDistance = Uti.getXcomponent(nodes.get(secondNodeIndex), nodes.get(firstNodeIndex));
            this.yDistance = Uti.getYcoponent(nodes.get(secondNodeIndex), nodes.get(firstNodeIndex));
            this.xOrigin = nodes.get(firstNodeIndex).getX();
            this.yOrigin = nodes.get(firstNodeIndex).getY();
        }

    }
}
