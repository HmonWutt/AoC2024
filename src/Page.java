import java.util.*;

public class Page {
     Map<String, List<String>> dictionary = new HashMap<>();
     ArrayList<String> topHalf = new ArrayList<>();
     ArrayList<String> bottomHalf = new ArrayList<>();
     public Page(ArrayList<String> input){
        seperatePagesAndManual(input);
        makeDictionary();
    }
    public void makeDictionary() {
        Map<String, List<String>> dictionaryTemp = new HashMap<>();
        for (String each : this.topHalf) {
            ArrayList<String> frontBack = splitString(each, "\\|");
            addToDictionary(dictionaryTemp,frontBack.get(0), frontBack.get(1));
        }
        this.dictionary = dictionaryTemp;
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
        int total = 0;
        boolean isInOrder = true;
        for (String each : this.bottomHalf) {
            ArrayList<String> eachLine = splitString(each, ",");
            int page = 0;
            Set<String> allNumbersBeforeNow = new HashSet<>();
            while (page < eachLine.size()) {
                Set<String> tempSet = new HashSet<>();
                if (this.dictionary.get(eachLine.get(page))!=null) {
                    List<String> mustBeAfterCurrentValue = this.dictionary.get(eachLine.get(page));
                        if (mustBeAfterCurrentValue.size() > allNumbersBeforeNow.size()) {
                            tempSet = new HashSet<>(mustBeAfterCurrentValue); // Copy of value
                            tempSet.retainAll(allNumbersBeforeNow);
                        } else {
                            tempSet = new HashSet<>(allNumbersBeforeNow); // Copy of value
                            tempSet.retainAll(mustBeAfterCurrentValue);
                        }

                }

                isInOrder = tempSet.isEmpty();
                if (!isInOrder) break;
                allNumbersBeforeNow.add(eachLine.get(page));
                page += 1;
            }
            if (isInOrder) {
                total+=getMiddle(eachLine);
                //System.out.println(each);
                }
        }
            return total;
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

}
