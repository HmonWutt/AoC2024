import java.math.BigInteger;
import java.util.*;

public class Page {
     Map<String, List<String>> frontBehindDictionary = new HashMap<>();
    Map<String, List<String>> behindFrontDictionary = new HashMap<>();
     ArrayList<String> topHalf = new ArrayList<>();
     ArrayList<String> bottomHalf = new ArrayList<>();
     public Page(ArrayList<String> input){
        seperatePagesAndManual(input);
        makeDictionary();
    }
    public void makeDictionary() {
        Map<String, List<String>> dictionaryTemp = new HashMap<>();
        Map<String, List<String>> dictionaryTemp1 = new HashMap<>();
        for (String each : this.topHalf) {
            ArrayList<String> frontBack = splitString(each, "\\|");
            addToDictionary(dictionaryTemp,frontBack.get(0), frontBack.get(1));
            addToDictionary(dictionaryTemp1,frontBack.get(1),frontBack.get(0));
        }
        this.frontBehindDictionary = dictionaryTemp;
        this.behindFrontDictionary = dictionaryTemp1;
        //printDictionary((HashMap<String, List<String>>)this.dictionary);
    }
    public void printDictionary(HashMap<String,List<String>>dictionary){
        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            List<String>value = entry.getValue();
            System.out.println(key + ": " +value);
        }
    }
    public static void addToDictionary(Map<String, List<String>> dictionary, String key, String value) {
        if (!dictionary.containsKey(key)) {
            dictionary.put(key, new ArrayList<>());
        }
        dictionary.get(key).add(value);
    }
    public static ArrayList<String> splitString (String input, String delimiter){
         return new ArrayList<>(Arrays.asList(input.split(delimiter)));
    }

    public void seperatePagesAndManual(ArrayList<String> input) {
        int index = 0;
        while (!input.get(index).isEmpty()) {
            this.topHalf.add(input.get(index));
            index++;
        }
        index++;
        while (index < input.size()) {
            this.bottomHalf.add(input.get(index));
            index++;
        }
    }
    public int checkPagesInOrder() {
        ArrayList<ArrayList<String>> reordered = new ArrayList<>();
        int orderedTotal = 0;
        int reorderedTotal = 0;
        boolean isInOrder = true;
        for (String each : this.bottomHalf) {
            ArrayList<String> eachLine = splitString(each, ",");
            int page = 0;
            Set<String> allNumbersBeforeNow = new HashSet<>();
            while (page < eachLine.size()) {
                Set<String> tempSet = new HashSet<>();
                if (this.frontBehindDictionary.get(eachLine.get(page))!=null) {
                    List<String> mustBeAfterCurrentValue = this.frontBehindDictionary.get(eachLine.get(page));
                        if (mustBeAfterCurrentValue.size() > allNumbersBeforeNow.size()) {
                            tempSet = new HashSet<>(mustBeAfterCurrentValue); // Copy of value
                            tempSet.retainAll(allNumbersBeforeNow);
                        } else {
                            tempSet = new HashSet<>(allNumbersBeforeNow); // Copy of value
                            tempSet.retainAll(mustBeAfterCurrentValue);
                        }
                }
                isInOrder = tempSet.isEmpty();
                if (!isInOrder) {
                    ArrayList<String> reorderedPages = reorder(eachLine);
                    //System.out.println(reorderedPages);
                    reordered.add(reorderedPages);
                    break;
                }
                allNumbersBeforeNow.add(eachLine.get(page));
                page += 1;
            }
            if (isInOrder) {
                orderedTotal+=getMiddle(eachLine);
                //System.out.println(each);
                }
        }
        for(ArrayList<String> eachReorderedString: reordered) {
            //System.out.println("Middle: "+getMiddle(eachReorderedString));
            reorderedTotal+=getMiddle(eachReorderedString);
        }
        System.out.println("Reordered total: "+reorderedTotal);
        return orderedTotal;
    }
    private ArrayList<String> reorder(ArrayList<String> pagesNotInOrder) {
        for (int i = 0; i<pagesNotInOrder.size()-1;i++){
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j <pagesNotInOrder.size()-i-1;j++){
                ArrayList<String> swapped = swap(pagesNotInOrder.get(j), pagesNotInOrder.get(j+1));
                pagesNotInOrder.set(j,swapped.get(1));
                pagesNotInOrder.set(j+1, swapped.get(0));
            }
        }
        return pagesNotInOrder;
    }
    public ArrayList<String> swap (String previous, String current){
        if (this.frontBehindDictionary.get(current) != null) {
            List<String> numsThatShouldBeAfterCurrent = this.frontBehindDictionary.get(current);
            //System.out.println("nums that should be behind "+current+":"+numsThatShouldBeAfterCurrent);
            if (numsThatShouldBeAfterCurrent.contains(previous)) {
                return new ArrayList<String>(Arrays.asList(current, previous));
            }
        }
        //return new ArrayList<String>(Arrays.asList(previous,current));
        if (this.behindFrontDictionary.get(previous) != null) {
            List<String> numsThatShouldBeBeforeCurrent = this.behindFrontDictionary.get(current);
            //System.out.println("nums that should be before "+current+":"+numsThatShouldBeBeforeCurrent);
            if (numsThatShouldBeBeforeCurrent.contains(current)) {
                return new ArrayList<String>(Arrays.asList(previous,current));
            }
        }
        return new ArrayList<String>(Arrays.asList(previous,current));
    }
    public static void isInOrder(String pageNumOne, String pageNumTwo, Map<String,List<String>> dictionary){
        System.out.println("Is in order"+dictionary.get(pageNumOne).contains(pageNumTwo));
        System.out.println(pageNumOne+": "+dictionary.get(pageNumOne)+ "page"+pageNumTwo);
    }
    public int getMiddle(ArrayList<String>input){
        int middleIndex = input.size()/2;
        String middleString = input.get(middleIndex);
        return Integer.parseInt(middleString);
    }
    public ArrayList<String> sliceStringArray(ArrayList<String>input,int start,int end){
         ArrayList<String> newArray = new ArrayList<>();
         for(int i = start; i < end; ++i) {
            newArray.add(input.get(i));
        }
         return newArray;
    }

}
