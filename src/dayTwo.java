import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dayTwo {
    public ArrayList<String> input = new ArrayList<>();
    public ArrayList<String> output = new ArrayList<>();
    public dayTwo(ArrayList<String> input){
        this.input = input;

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

}
