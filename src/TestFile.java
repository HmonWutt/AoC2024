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

    public static boolean recursion(BigInteger result,BigInteger value, ArrayList<BigInteger> values, boolean isPartOne){

        if (values.isEmpty()){
            return Objects.equals(result, value);
        }
        else {
            BigInteger temp = values.remove(0);
            boolean resultOne;
            boolean resultTwo;
            boolean resultThree;

            if (isPartOne){
            resultOne = recursion(result,value.multiply(temp),new ArrayList<BigInteger>(values), isPartOne);
            resultTwo =  recursion(result,value.add(temp),new ArrayList<BigInteger>(values),isPartOne);
            resultThree =  recursion(result,stringToBigInteger(value,temp),new ArrayList<BigInteger>(values),isPartOne);
            return resultOne||resultTwo||resultThree;}
            resultOne = recursion(result,value.multiply(temp),new ArrayList<BigInteger>(values), isPartOne);
            resultTwo =  recursion(result,value.add(temp),new ArrayList<BigInteger>(values),isPartOne);
            return resultOne||resultTwo;
        }
    }
    public static BigInteger stringToBigInteger(BigInteger firstNum, BigInteger secondNum ){
        String firstNumStr = firstNum.toString();
        String secondNumStr = secondNum.toString();
        String concatStr = firstNumStr+secondNumStr;
        return new BigInteger(concatStr);

    }
    public static ArrayList<BigInteger> findTrueTestValues(ArrayList<ArrayList<BigInteger>> input, boolean isPartTwo){
        ArrayList<BigInteger> passed = new ArrayList<>();
        for (ArrayList<BigInteger>each:input){
            ArrayList<BigInteger> rightOperand = sliceArray(each,1,each.size());
            BigInteger value = rightOperand.remove(0);
            if (recursion(each.get(0),value,rightOperand,isPartTwo))passed.add(each.get(0));
        }
        return passed;
    }
    public static BigInteger addTrueTestValues(ArrayList<String> input, boolean isPartOne){
        ArrayList<ArrayList<BigInteger>>preparedInput = prepareInput(input);
        ArrayList<BigInteger> trueTestValues = findTrueTestValues(preparedInput,isPartOne);
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