import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdRange {
    long start;
    long end;
    ArrayList<Long> invalidIds1 = new ArrayList<>();
    ArrayList<Long> invalidIds = new ArrayList<>();

    IdRange(long start, long end) {
        this.start = start;
        this.end = end;
    }

    void findInvalid() {

        ArrayList<Long> invalidIds1 = new ArrayList<>();
        ArrayList<Long> invalidIds = new ArrayList<>();

        for (long i = start; i < end+1; i++) {
            String numberAsString = Long.toString(i);
            int mid = numberAsString.length() / 2;
            String firstHalf = numberAsString.substring(0, mid);
            String secondHalf = numberAsString.substring(mid);
            if (firstHalf.equals(secondHalf)) {
                this.invalidIds1.add(i);
            }
            if (checkIfRepeats(numberAsString)) this.invalidIds.add(i);

        }

    }


    boolean checkIfRepeats(String input){
        String regex = "";
        int inputLen = input.length();
        for (int i =0; i <inputLen/2;i+=1){
            regex+=input.charAt(i);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            int count = 0;
            while (matcher.find()){
                count++;
            }
            int patternLen = regex.length();
            if (count == (inputLen/patternLen)&& inputLen%patternLen==0 ){
                return true ;
            }

        }
        return false;

    }

}
