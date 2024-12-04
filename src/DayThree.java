import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {

    int output = 0;

    public static int checkInputStringForMultiplications(String input){
        Pattern pattern =  Pattern.compile("mul\\((-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)\\)");
        Matcher match = pattern.matcher(input);
        int total = 0;
        if(match.find()) {
            do {
                int firstNumber = 0;
                int secondNumber = 0;
                String entireMatch = match.group();
                Pattern patternFirstNum = Pattern.compile("(-?\\d+)+");
                Matcher firstNum = patternFirstNum.matcher(entireMatch);
                if (firstNum.find()){
                    firstNumber = Integer.parseInt(firstNum.group(1));
                };
                Pattern patternSecondNum = Pattern.compile(",\\s*(-?\\d+(\\.\\d+)?)");  // Match the second number after ","
                Matcher secondNum = patternSecondNum.matcher(entireMatch);
                if (secondNum.find()){
                    secondNumber = Integer.parseInt(secondNum.group(1));
                };
                int multiplication = firstNumber * secondNumber;
                total+=multiplication;

            } while (match.find(match.start() + 1));
        }
        return  total;
    }



}
