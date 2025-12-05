import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.abs;

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

    static Long process(List<Long> range, Long target){
        Long start = range.getFirst();
        Long end = range.getLast();
        if (target >= start && target <=end){
            return -1L;
        }
        return target;

    }

    static void iterateOver(){
        Set <List<Long>> checked = new HashSet<>();
        long start = Ingredients.ranges.getFirst().getFirst();
        long  end = Ingredients.ranges.getFirst().getLast();
        List<Long> starting = Ingredients.ranges.removeFirst();
        int index = 0;
        checked.add(starting);
        while (index <Ingredients.ranges.size()+1){
            for (List<Long> each: Ingredients.ranges){
                if (!checked.contains(each)) {
                    if (abs(end - each.getFirst()) >= 0) {
                        start = start < each.getFirst() ? start : each.getFirst();
                        end = end < each.getLast() ? end : each.getLast();
                        checked.add(each);
                    }
                }

            }

            }

        }




}

