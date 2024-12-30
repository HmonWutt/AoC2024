import java.util.ArrayList;

public class SolveEquation {
    public static Integer solve(ArrayList<Integer> first, ArrayList<Integer> second){
        Integer x = 0;
        Integer y = 0;
        Integer x1 = first.get(0) * second.get(0);
        Integer y1 = first.get(1) * second.get(0);
        Integer rightSide1 = first.get(2) * second.get(0);
        Integer y2 = second.get(1) * first.get(0);
        Integer rightSide2 = second.get(2) * first.get(0);
        if ((rightSide1-rightSide2)%(y1-y2)  == 0){

            y = (rightSide1-rightSide2)/(y1-y2);
            System.out.println("1 met y: "+y);
            if ((first.get(2) - (first.get(1)*y))% first.get(0) == 0) {
                x = (first.get(2) - (first.get(1)*y))/ first.get(0);
                System.out.println("2 met x: "+x);
                System.out.println("tokens: "+((x*3)+y));
                return (x*3) + y;

            }
            return -1;
        }
        return -1;
    }
}
