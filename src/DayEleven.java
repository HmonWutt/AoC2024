import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class DayEleven {
    public static HashMap<Long,Long> makeStones (String Input){
        HashMap<Long, Long> dictionary = new HashMap<>();
        ArrayList<String> stoneNumbers = new ArrayList<>(Arrays.asList(Input.split(" ")));
        ArrayList<Long> stones = new ArrayList<>();
        for (String each:stoneNumbers){
            Long num = (long) Integer.parseInt(each);
            dictionary.put(num,1L);
        }
       return dictionary;
    }
    public static ArrayList<Long> transformStones(ArrayList<Long> originalStones) {
        ArrayList<Long> stones = new ArrayList<>();
       // for (int i = 0 ; i < blinks ;i++) {
            for (Long each : originalStones) {
                ArrayList<Long> temp = Stone.transform(each);
                stones.addAll(temp);
            }
       // }
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
