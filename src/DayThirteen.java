import java.util.ArrayList;

public class DayThirteen {
    public static Integer countTokens(ArrayList<String> input, boolean isPartTwo) {
        Integer totalTokens = 0;
        for (String each : input) {
            ArrayList<Integer> eachSetOfEquations = Regex.getNumbers(each);
            ArrayList<Integer> firstEquation = new ArrayList<>();
            ArrayList<Integer> secondEquation = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    firstEquation.add(eachSetOfEquations.get(i));
                } else {
                    secondEquation.add(eachSetOfEquations.get(i));
                }
            }
            if (solve(firstEquation, secondEquation) > 0) {
                totalTokens += (solve(firstEquation, secondEquation));
            }
        }
        return totalTokens;
    }
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
            if ((first.get(2) - (first.get(1)*y))% first.get(0) == 0) {
                x = (first.get(2) - (first.get(1)*y))/ first.get(0);
                return (x*3) + y;
            }
            return -1;
        }
        return -1;
    }
}
