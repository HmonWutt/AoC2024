import java.util.ArrayList;

public class Components {

    int xComponent;
    int yComponent;
    int xOrigin;
    int yOrigin;

    public Components(ArrayList<Node> nodes, int firstNodeIndex, int secondNodeIndex) {
        getParameters( nodes, firstNodeIndex, secondNodeIndex);

    }

    private void getParameters(ArrayList<Node> nodes, int firstNodeIndex, int secondNodeIndex) {

        if (nodes.get(firstNodeIndex).frequency.equals(nodes.get(secondNodeIndex).frequency)) {
            this.xComponent = Uti.getXcomponent(nodes.get(secondNodeIndex), nodes.get(firstNodeIndex));
            this.yComponent = Uti.getYcoponent(nodes.get(secondNodeIndex), nodes.get(firstNodeIndex));
            this.xOrigin = nodes.get(firstNodeIndex).getX();
            this.yOrigin = nodes.get(firstNodeIndex).getY();
        }

    }
}
