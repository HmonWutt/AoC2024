import java.util.ArrayList;
import java.util.Arrays;

public class InstructionParser {
    private ArrayList<String> opCodeAndOperand;
    private ArrayList<Integer> instructions;
    private ArrayList<Integer> operands;
    public InstructionParser(String input){
        this.opCodeAndOperand = new ArrayList<>(Arrays.asList(input.split(",")));

    }
    public ArrayList<Integer> getOperands(){
        ArrayList<Integer> operands= new ArrayList<>();
        for (int i=1;i < this.opCodeAndOperand.size();i+=2){
            String each = this.opCodeAndOperand.get(i);
            operands.add(Integer.parseInt(String.valueOf(each)));
        }
        return operands;
    }
    public ArrayList<Integer> getInstructions(){
        ArrayList<Integer> instructions= new ArrayList<>();
        for (int i=0;i < this.opCodeAndOperand.size();i+=2){
            String each = this.opCodeAndOperand.get(i);
            instructions.add(Integer.parseInt(String.valueOf(each)));
        }
        return instructions;
    }

}
