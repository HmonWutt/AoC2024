import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class TestFile {
    /*ArrayList<String> input= new ArrayList<>();
    public TestFile(ArrayList<String> input){
        this.input = input;
    }*/
    public static ArrayList<ArrayList<BigInteger>> prepareInput(ArrayList<String> input) {
        ArrayList<ArrayList<BigInteger>> finalList = new ArrayList<>();
        for (String each:input){
            ArrayList<BigInteger> newList = new ArrayList<>();
            ArrayList<String> expression = Page.splitString(each,":");
            BigInteger leftOperand = new BigInteger (expression.get(0));
            newList.add(leftOperand);
            String rightOperandString = expression.get(1).strip();
            String [] temp = rightOperandString.split(" ");
            for(int i=0; i<temp.length; i++) {
                newList.add(new BigInteger(temp[i]));
            }
            finalList.add(newList);
            }
        return finalList;
    }

    public static boolean recursion(BigInteger result,BigInteger value, ArrayList<BigInteger> values){

        if (values.isEmpty()){
            return Objects.equals(result, value);
        }
        else {
            BigInteger temp = values.remove(0);
            boolean resultOne;
            boolean resultTwo;
            resultOne = recursion(result,value.multiply(temp),new ArrayList<BigInteger>(values));
            resultTwo =  recursion(result,value.add(temp),new ArrayList<BigInteger>(values));
            return resultOne||resultTwo;
        }
    }

    public static ArrayList<BigInteger> findTrueTestValues(ArrayList<ArrayList<BigInteger>> input){
        ArrayList<BigInteger> passed = new ArrayList<>();
        for (ArrayList<BigInteger>each:input){
            ArrayList<BigInteger> rightOperand = sliceArray(each,1,each.size());
            BigInteger value = rightOperand.remove(0);
            if (recursion(each.get(0),value,rightOperand))passed.add(each.get(0));
        }
        return passed;
    }
    public static BigInteger addTrueTestValues(ArrayList<String> input){
        ArrayList<ArrayList<BigInteger>>preparedInput = prepareInput(input);
        ArrayList<BigInteger> trueTestValues = findTrueTestValues(preparedInput);
        BigInteger total = new BigInteger ("0");
        for (BigInteger each: trueTestValues) total = total.add(each);
        return total;
    }
    public static  ArrayList<BigInteger> sliceArray(ArrayList<BigInteger> input, int start,int end){
        ArrayList<BigInteger> newArray = new ArrayList<>();
        for (int i=start; i <end;i++){
            newArray.add(input.get(i));
        }
        return newArray;
    }

}
