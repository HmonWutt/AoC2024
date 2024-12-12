import java.util.ArrayList;

public class DayFour {
    public static int findXMAS(String pattern, ArrayList<String> matrix) {
        int total = 0;
        for (String each : matrix) {
            String reversed = new StringBuilder(each).reverse().toString();
            total+=DayThree.countMatches(pattern, each);
            total+=DayThree.countMatches(pattern, reversed);
        }
        return total;
    }
    public static int findCrossedMas( ArrayList<String> matrix){
        int total = 0;
        boolean matched = true;
        for (int row = 0; row < matrix.size()-2;row++) {
            for (int col = 0; col <matrix.size()-2;col++) {
                char currentChar = matrix.get(row).charAt(col);
                matched = check3by3box(matrix,currentChar,
                        'M','S', 'A','M','S',
                        row,col);
                if (matched) total += 1;
                matched = check3by3box(matrix,currentChar,
                        'M','M', 'A','S','S',
                        row,col);
                if (matched) total += 1;
                matched = check3by3box(matrix,currentChar,
                        'S','M', 'A','S','M',
                        row,col);
                if (matched) total += 1;
                matched =  check3by3box(matrix,currentChar,
                        'S','S', 'A','M','M',
                        row,col);
                if (matched) total += 1;
            }
        }
        return total;
    }

    public static boolean check3by3box(ArrayList<String> matrix,
                                       char currentChar,
                                       char toMatch,
                                       char rowSameCol2Right,
                                       char row1DownCol1Right,
                                       char row2DownColSame,
                                       char row2DownCol2Right,
                                       int row,
                                       int col) {
        boolean isXMAS = true;
        if (currentChar == toMatch) {
            isXMAS = checkCharAtPosition(rowSameCol2Right, matrix.get(row), col + 2)
                    && checkCharAtPosition(row1DownCol1Right, matrix.get(row + 1), col + 1)
                    && checkCharAtPosition(row2DownColSame, matrix.get(row + 2), col)
                    && checkCharAtPosition(row2DownCol2Right, matrix.get(row + 2), col + 2);
        }
        else return false;
        return isXMAS;
    }
    public static boolean checkCharAtPosition ( char character, String str,int y){
        return str.charAt(y) == character;
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