import java.util.ArrayList;
import java.util.Arrays;

public class InstructionParser {
    public String getRegister(String input){
        ArrayList<String> inputSplit = new ArrayList<>(Arrays.asList(input.split(":")));
        ArrayList<String> indexZero = new ArrayList<>(Arrays.asList(inputSplit.get(0).split(" ")));
        return indexZero.get(0);
    }

    public ArrayList<Integer> getOperands(String input){
        ArrayList<String> inputSplit = new ArrayList<>(Arrays.asList(input.split(":")));
        ArrayList<String> indexOne = new ArrayList<>(Arrays.asList(inputSplit.get(1).split(" ")));
        String str = indexOne.get(0);
        ArrayList<Integer> operands= new ArrayList<>();
        for (int i=0;i < str.length();i++){
            char each = str.charAt(i);
            operands.add(Integer.parseInt(String.valueOf(each)));
        }
        return operands;
    }


}
