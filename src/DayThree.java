import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {
    public static int findAll(String pattern, String input) {
        ArrayList<String> matches = findMatchesAndMakeArray(pattern, input);
        int index = 0;
        int total = 0;
        boolean enable = true;
        while (index < matches.size()){
                if (findMatchBoolean("[^\\w\\s]*don\\'t\\(\\)[^\\w\\s]*", matches.get(index))) {
                    enable = false;
                }
                else if (findMatchBoolean("\\w*do\\(\\)\\w*", matches.get(index))) {
                    enable = true;
                }
               else {
                   if (enable){
                    String numberPattern = "(-?\\d+)+";
                    ArrayList<String> numbers = findMatchesAndMakeArray(numberPattern, matches.get(index));
                    int multiplication = multiply(numbers.get(0), numbers.get(1));
                    total += multiplication;
                   }
                }
               index++;
            }
        return total;
    }
    public static int checkInputStringForMultiplications(String entirePattern, String input){
        int total = 0;
        ArrayList<String> entireMatch = findMatchesAndMakeArray(entirePattern,input);
        String numberPattern = "(-?\\d+)+";
        for (String each:entireMatch){
            ArrayList<String> numbers = findMatchesAndMakeArray(numberPattern,each);
            int multiplication = multiply(numbers.get(0), numbers.get(1));
            total+=multiplication;
        };
        return  total;
    }
    private static int multiply(String firstNumberString, String secondNumberString){
        int firstNumberInteger = Integer.parseInt(firstNumberString);
        int secondNumberInteger = Integer.parseInt(secondNumberString);
        return firstNumberInteger * secondNumberInteger;

    }
    private static ArrayList<String> findMatchesAndMakeArray(String patternInput, String input){
        Pattern pattern =  Pattern.compile(patternInput);
        Matcher match = pattern.matcher(input);
        ArrayList<String> output = new ArrayList<>();
        while (match.find()) output.add(match.group(0));
        return output;
    }
    public static int countMatches(String patternInput, String input){
        Pattern pattern =  Pattern.compile(patternInput);
        Matcher match = pattern.matcher(input);
        ArrayList<String> output = new ArrayList<>();
        while (match.find()) output.add(match.group());
        return output.size();
    }
    public static boolean findMatchBoolean(String patternInput, String input) {
        Pattern pattern = Pattern.compile(patternInput);
        Matcher match = pattern.matcher(input);
        return match.find();
    }




}
