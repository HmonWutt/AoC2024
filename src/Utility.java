import java.util.ArrayList;

public class Utility {
    public static char checkCharacterAtPosition(Integer X, Integer Y, ArrayList<String> matrix){
        return matrix.get(X).charAt(Y);
    }
}
