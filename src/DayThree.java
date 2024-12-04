import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {

    private static ArrayList<String> findMatches(String patternInput, String input){
        Pattern pattern =  Pattern.compile(patternInput);
        Matcher match = pattern.matcher(input);
        ArrayList<String> output = new ArrayList<>();
        while (match.find()) output.add(match.group(0));
        return output;
    }
    public static int checkInputStringForMultiplications(String input){

        int total = 0;
        String entireMatchPattern = "mul\\((-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)\\)";
        ArrayList<String> entireMatch = findMatches(entireMatchPattern,input);
        for (String each:entireMatch){
            String numberPattern = "(-?\\d+)+";
            ArrayList<String> numbers = findMatches(numberPattern,each);
            int firstNumber = Integer.parseInt(numbers.get(0));
            int secondNumber = Integer.parseInt(numbers.get(1));
            int multiplication = firstNumber * secondNumber;
            total+=multiplication;
        };
        return  total;
    }



}
