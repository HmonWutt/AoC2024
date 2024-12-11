import java.util.ArrayList;

public class Node {
    int count=0;
    int name=count;
    String frequency;
    int x=0;
    int y=0;
    Node neighbourNode;
    ArrayList<ArrayList<String>> matrix = new ArrayList<>();
    public Node(String frequency,int x, int y){
        this.name = count;
        count++;
        this.frequency= frequency;
        this.x = x;
        this.y = y;
    }

    public String getFrequency(int x, int y){
        return this.matrix.get(x).get(y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }




}
