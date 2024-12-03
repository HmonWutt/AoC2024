import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwo {
    public ArrayList<String> input = new ArrayList<>();
    public ArrayList<List<Integer>> output = new ArrayList<>();
    public DayTwo(ArrayList<String> input){
        this.input = input;
        this.output = StringListToIntegerList();

    }
    private ArrayList<List<Integer>> StringListToIntegerList(){
        ArrayList<List<Integer>> output = new ArrayList<>();
         for (String each: this.input) {
             List<String> stringList = new ArrayList<>(Arrays.asList(each.split("\\s+")));
             List<Integer> integerList = stringList.stream()
                     .map(Integer::parseInt)
                     .toList();
             output.add(integerList);
         }
        return output;
    }
    public int getSafeReports(){
        int total = 0;
        for (List<Integer> list: this.output) {
        if (isSafe(list)) total+=1;
        }
        return total;
    }
    public int allowOneUnsafe(){
        int total = 0;
        for (List<Integer> list: this.output) {
            if (isSafe(list))total+=1;
            else{
                boolean isAtLeastOneSafe = false;
                for (int i=0;i<list.size();i++){
                    List<Integer> newList = new ArrayList<>(list);
                    newList.remove(i);
                    if (isSafe(newList)) isAtLeastOneSafe = true;
                }
                if (isAtLeastOneSafe) total+=1;
            }
        }
        return total;
    }
    public boolean isSafe(List<Integer> input){
        int index = 1;
        int sign = input.get(0) - input.get(1);
        boolean isSafe = isLessThanThree(input.get(0),input.get(1));
        while (index < input.size()-1 && isSafe){
            int left = input.get(index);
            int right = input.get(index+1);
            int difference = left - right;
            isSafe = isLessThanThree(left,right) && isSameSign(sign , difference);
            index+=1;
        }
        return isSafe;
    }


    public boolean isSameSign(int oldDiff, int newDiff){
        return oldDiff * newDiff > 0;
    }
    public boolean isLessThanThree(int left, int right){
        return Math.abs(left - right) < 4 && Math.abs(left - right) > 0;
    }



}
