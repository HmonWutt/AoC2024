
import java.util.ArrayList;
import java.util.HashMap;

public class Stone {
    public static ArrayList<Long> transform(Long number){
        ArrayList<Long> stones = new ArrayList<>();
        if(number == 0) {
            //System.out.println(newStone.number);
            stones.add((long)1);
        }
        else if (String.valueOf(number).length()%2 == 0){
            String original = String.valueOf(number);
            Integer mid = original.length()/2;
            Integer end = original.length();
            Long firstNum = (long) Integer.parseInt(original.substring(0,mid));
            Long secondNum = (long) Integer.parseInt(original.substring(mid,end));
            stones.add(firstNum);
            stones.add(secondNum);
        }
        else{
            stones.add(number*2024);
        }
        return stones;
    }
    public static void findTargetInDictAndAddIfNotAlreadyExists(HashMap<Long, Long> dict, Long target, Long numOfParent){
        if (dict.containsKey(target)) {
            Long count = dict.get(target);
            dict.put(target, count + numOfParent);
        } else {
            dict.put(target, numOfParent);
        }
    }
}
