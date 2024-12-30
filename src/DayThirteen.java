import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class DayThirteen {
    public static Object countTokens(ArrayList<String> input, boolean isPartTwo) {
        Integer totalTokens = 0;
        BigInteger totalTokenL  = new BigInteger("0");
        for (String each : input) {
            ArrayList<Integer> eachSetOfEquations = Regex.getNumbers(each);
            ArrayList<Integer> firstEquation = new ArrayList<>();
            ArrayList<Integer> secondEquation = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    firstEquation.add(eachSetOfEquations.get(i));
                } else {
                    secondEquation.add(eachSetOfEquations.get(i));
                }
            }
            if (isPartTwo){
               BigInteger obj = new BigInteger(String.valueOf(solve(firstEquation, secondEquation,true)));

                if (!obj.equals(BigInteger.valueOf(-1))){
                    totalTokenL = totalTokenL.add(obj);
                    System.out.println(totalTokenL);
                }
            }
            else{
                if ((Integer) solve(firstEquation, secondEquation,false) != -1) {
                    totalTokens += (Integer)(solve(firstEquation, secondEquation,false));
                }
            }
        }
        Object result = isPartTwo ? totalTokenL : totalTokens;
       return result;
    }
    public static Object solve(ArrayList<Integer> first, ArrayList<Integer> second, boolean isPartTwo) {

        Integer rightSide1 = 0;
        Integer rightSide2 = 0;
        BigInteger rightSide1L = new BigInteger("0");
        BigInteger rightSide2L = new BigInteger("0");
        Integer x1 = first.get(0) * second.get(0);
        Integer y1 = first.get(1) * second.get(0);
        Integer y2 = second.get(1) * first.get(0);
        if (!isPartTwo) {
            Integer x = 0;
            Integer y = 0;
            rightSide1 = first.get(2) * second.get(0);
            rightSide2 = second.get(2) * first.get(0);
            if ((rightSide1 - rightSide2) % (y1 - y2) == 0) {
                y = (rightSide1 - rightSide2) / (y1 - y2);
                if ((first.get(2) - (first.get(1) * y)) % first.get(0) == 0) {
                    x = (first.get(2) - (first.get(1) * y)) / first.get(0);
                    return (x * 3) + y;
                }
                return -1;
            }
            return -1;
        } else {
            BigInteger x;
            BigInteger y;
            BigInteger rightSide1original = BigInteger.valueOf(first.get(2)+ 10000000000000L);
            BigInteger rightSide2original = BigInteger.valueOf(second.get(2)+ 10000000000000L);
            rightSide1L = BigInteger.valueOf(second.get(0)).multiply(rightSide1original);
            rightSide2L = BigInteger.valueOf(first.get(0)) .multiply(rightSide2original);
            BigInteger rightsideDifference = rightSide1L.subtract(rightSide2L);
            BigInteger yDifference = BigInteger.valueOf(y1 - y2);
            BigInteger mod = rightsideDifference.abs().mod(yDifference.abs());
            if (mod.equals(BigInteger.ZERO)) {
                y = rightsideDifference.divide(yDifference);
                BigInteger yCoefficient = BigInteger.valueOf(first.get(1));
                BigInteger yValue = yCoefficient.multiply(y);
                BigInteger xCoefficient = BigInteger.valueOf(first.get(0));
                BigInteger difference = rightSide1original.subtract(yValue);
                if (difference.mod(xCoefficient).equals(BigInteger.ZERO)) {
                    x = difference.divide(xCoefficient);
                    System.out.println("token"+x.multiply(BigInteger.valueOf(3)).add(y));
                    return x.multiply(BigInteger.valueOf(3)).add(y);
                }
                return new BigInteger("-1");
            }
            return new BigInteger("-1");
        }
    }

}
