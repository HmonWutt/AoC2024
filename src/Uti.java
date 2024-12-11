import java.util.ArrayList;

public class Uti{
    public static int getYcoponent(Node one, Node two){
        return one.getY() - two.getY();
    }
    public static int getXcomponent(Node one, Node two){
        return one.getX() - two.getX();
    }
    public static  Antinode createAntinode(int x, int y) {
        Antinode newAntinode = null;
        //if ((x>=0 && x<=bound) && (y>=0 && y<=bound)) {
             newAntinode = new Antinode(x,y);
            return newAntinode;

    }
    public static boolean isNode(ArrayList<Node>matrix, int x, int y){
        boolean isNode = false;
        int index =0;
        while (!isNode && index < matrix.size())
        {
            isNode = matrix.get(index).getX()==x && matrix.get(index).getY()==y;
            index+=1;
        }
        return isNode;

    }
    public static Distance getDistance(Node one, Node two){
        int Xdifference = one.x-two.x;
        int Ydifference = one.y-two.y;
       // System.out.println("Distance: "+Math.sqrt(Xdifference * Xdifference + Ydifference*Ydifference));
        return new Distance(Xdifference,Ydifference);
    }
}


