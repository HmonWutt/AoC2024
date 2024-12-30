import java.util.ArrayList;

public class DayThirteen {
    public static Integer countTokens(ArrayList<String> input) {
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
            if (SolveEquation.solve(firstEquation, secondEquation) > 0)
                totalTokens += SolveEquation.solve(firstEquation, secondEquation);
        }
        return totalTokens;
    }
}
