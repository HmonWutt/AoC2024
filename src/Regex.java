import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static ArrayList<Integer> getNumbers(String string) {
        ArrayList<Integer> output = new ArrayList<>();
       String rg = "(\\d+)";
       Pattern pattern = Pattern.compile(rg);
        Matcher match = pattern.matcher(string);
        while (match.find()) {
            output.add(Integer.parseInt(match.group()));
        };
        return output;
    }
    public static ArrayList<Integer> getNumbersWithSigns(String string) {
        ArrayList<Integer> output = new ArrayList<>();
        String rg = "[+-]?(\\d+)";
        Pattern pattern = Pattern.compile(rg);
        Matcher match = pattern.matcher(string);
        while (match.find()) {
            output.add(Integer.parseInt(match.group()));
        };
        return output;
    }
}
