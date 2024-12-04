import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFour {
    public static int findXMAS(ArrayList<String> matrix) {
        int total = 0;
        for (String each : matrix) {
            String reversed = new StringBuilder(each).reverse().toString();
            total+=DayThree.countMatches("XMAS", each);
            total+=DayThree.countMatches("XMAS", reversed);
            //if (DayThree.findMatchBoolean("SAMX",reversed)) total+=1;
        }

        return total;
    }
    public static String reverseString(String originalString){
        String reversedString = "";
        for (int i = originalString.length()-1; i >=0; i--){
            reversedString+=originalString.charAt(i);
        }
        return reversedString;
    }

   public static ArrayList<String> swapRowsAndCols (ArrayList<String> matrix) {
       ArrayList<String> transformedMatrix = new ArrayList<>();
       String newRow = "";
       for (int i = 0; i < matrix.size(); i++) {
           for (int j = 0; j < (matrix.get(0)).length(); j++) {
               newRow += matrix.get(j).charAt(i);
           }
           transformedMatrix.add(newRow);
           newRow = "";
       }
       return transformedMatrix;
   }


   public static ArrayList<String> diagnoalise(ArrayList<String> matrix){
        ArrayList<String> diagonalList = new ArrayList<>();
        String diagonals = "";
        int rowLimit = matrix.size();
        int colLimit = matrix.get(0).length();
        int currentRow = 0;
        int currentCol = 0;
        boolean goingUp = true;
        int limit = rowLimit * colLimit;
        int counter = 0;
       while (counter != limit){
           if (goingUp) {
               while (currentRow >= 0 && currentCol < colLimit) {
                   char charAtCurrentPosition = matrix.get(currentRow).charAt(currentCol);
                   diagonals += charAtCurrentPosition;
                   currentRow -= 1;
                   currentCol += 1;
                   counter+=1;
               }
               if (currentCol == colLimit) {
                   currentCol -= 1;
                   currentRow += 2;

               } else {
                   currentRow += 1;
               }
               diagonalList.add(diagonals);
               diagonals = "";
           }
           goingUp = false;
           if (!goingUp) {
               while (currentRow < rowLimit && currentCol >= 0) {
                   char charAtCurrentPosition = matrix.get(currentRow).charAt(currentCol);
                   diagonals += charAtCurrentPosition;
                   currentRow += 1;
                   currentCol -= 1;

                   counter+=1;
               }
               if (currentRow == rowLimit) {
                   currentRow -= 1;
                   currentCol += 2;
               } else {
                   currentCol += 1;
               }
               diagonalList.add(diagonals);
               diagonals = "";
           }
           goingUp = true;
       }
       return diagonalList;
   }
   public static ArrayList<String> reverse(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<>();
        for (String each: input){
            String reversed = new StringBuilder(each).reverse().toString();
            output.add(reversed);
        }
        return output;
   }



}