import java.util.*;


public class Ingredients {
    static List<List<Long>> ranges ;
    Ingredients(String ranges){
        Ingredients.ranges = Ingredients.stringToNum(ranges);
    }

    static boolean checkIsInRange(Long ingredientID){
        int index = 0;
        while (index < Ingredients.ranges.size()){
            List<Long> range = Ingredients.ranges.get(index);
            Long start = range.getFirst();
            Long end = range.getLast();
            if (ingredientID >= start && ingredientID <=end){
                return true;
            }
            index+=1;
        }
        return false;
    }

    static List<List<Long>> stringToNum(String strings){
        List<List<Long>> ranges = new ArrayList<>();
        String[] stringList = strings.split("\\R");
        for (String each: stringList){
            String[] parts = each.split("-");
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            ranges.add(List.of(start,end));
        }
        return ranges;
    }

    static int run(String ingredients){
        String[] listOfIngredients = ingredients.split("\\R");
        int countOfFreshIngredients = 0;
        for (String each: listOfIngredients){
            Long ingredient = Long.parseLong(each);
            if (Ingredients.checkIsInRange(ingredient)){
                countOfFreshIngredients++;
            }

        }
        return countOfFreshIngredients;
    }

    static void makeHeap(){
        PriorityQueue<List<Long>> heap = new PriorityQueue<>(
                (a, b) -> Long.compare(a.get(0), b.get(0))
        );
        for (List<Long> each: Ingredients.ranges){
            heap.add(each);
        }
        List<Long> first = heap.poll();
        List<List<Long>> newRanges = new ArrayList<>();
        long total = 0l;
        while (!heap.isEmpty()){
            List<Long>second = heap.poll();
            if (first.getLast()<second.getFirst()){
                long diff = first.getLast() - first.getFirst()+1;
                total+= diff;
                first = second;
            }
            else{
                long start = first.getFirst();
                long end = first.getLast() < second.getLast()?  second.getLast():first.getLast();
                first = List.of(start,end);
            }

        }
        total+=(first.getLast()-first.getFirst()+1);
        System.out.println(total);
    }

}

