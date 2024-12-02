import java.util.Hashtable;
import java.util.Map;

public class Dictionary {
    Hashtable<Integer, Integer> dictionary = new Hashtable<Integer,Integer>();
    LeftAndRightComparison leftAndRight;
    public Dictionary(LeftAndRightComparison leftAndRight){
        this.leftAndRight = leftAndRight;
    }
    private void convertListToEmptyDictionaryWithItemsInLeftAsKeys() {
        Hashtable<Integer, Integer> dict = new Hashtable<>();
        for(Integer integer :this.leftAndRight.getLeft())
        {
            if (!dict.containsKey(integer)) dict.put(integer, 0);
        }
        this.dictionary = dict;
    }

    private void countNumberOfTimesValuesInLeftAppearsInRight() {
        convertListToEmptyDictionaryWithItemsInLeftAsKeys();
        for (Integer item : leftAndRight.getRight()) {
            if (this.dictionary.containsKey(item)) {
                int newValue = dictionary.get(item) + 1;
                this.dictionary.put(item, newValue);
            }

        }
    }
    public int multiplyKeysAndValues() {
    int result = 0;
    countNumberOfTimesValuesInLeftAppearsInRight();
    for (Map.Entry<Integer, Integer> entry : this.dictionary.entrySet()) {
        int keyTimesValue = entry.getKey() * entry.getValue();
        result += keyTimesValue;

    }
    return result;
    }

}