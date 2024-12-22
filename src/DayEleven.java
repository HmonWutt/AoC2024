import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class DayEleven {
    public static void printTotalSpawns(Integer limit,String input ){
        Long total = 0L;
        HashMap<Long,Long> stones = DayEleven.keepBlinking(limit,input);
        for ( Long key : stones.keySet()){
            total+=stones.get(key);
            //System.out.println(key+","+stones.get(key));
        }
        System.out.println(total);

    }
    public static HashMap<Long,Long> keepBlinking (Integer limit, String input){
        HashMap<Long, ArrayList<Long>> dictionary = new HashMap<>();
        HashMap<Long, Long> stonesNotInDict = new HashMap<>();
        HashMap<Long, Long> stonesInDict = new HashMap<>();
        HashMap<Long, Long> stones = DayEleven.makeStones(input);
        Integer blinks = 0;
        while (blinks < limit) {
            for (Long stone : stones.keySet()) {
                Long numOfParent = stones.get(stone);
                if (dictionary.containsKey(stone)) {
                    ArrayList<Long> spawns = dictionary.get(stone);
                    for (Long spawn : spawns) {
                        DayEleven.findTargetInDictAndAddIfNotAlreadyExists(stonesInDict,spawn,numOfParent);
                    }
                } else{
                    DayEleven.findTargetInDictAndAddIfNotAlreadyExists(stonesNotInDict,stone,numOfParent);
                }
            }
            if (!stonesNotInDict.isEmpty()) {
                for (Long each : stonesNotInDict.keySet()) {
                    ArrayList<Long> spawns = Stone.transform(each);
                    Long numOfParent = stonesNotInDict.get(each);
                    dictionary.put(each, spawns);
                    for (Long spawn : spawns) {
                        DayEleven.findTargetInDictAndAddIfNotAlreadyExists(stonesInDict,spawn,numOfParent);
                    }
                }
            }
            stones.clear();
            for (Long key : stonesInDict.keySet()) {
                stones.put(key, stonesInDict.get(key)); // Use copy constructor for deep clone
            }
            stonesNotInDict.clear();
            stonesInDict.clear();
            blinks += 1;
            //System.out.println(blinks+","+stones.size());

        }
        return stones;
    }
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
