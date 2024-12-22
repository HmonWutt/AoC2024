/*
If the stone is engraved with the number 0,
it is replaced by a stone engraved with the number 1.
If the stone is engraved with a number
that has an even number of digits, it is replaced by two stones.
The left half of the digits are engraved on the new left stone,
and the right half of the digits are engraved on the new right stone.
(The new numbers don't keep extra leading zeroes: 1000 would become stones 10 and 0.)
If none of the other rules apply, the stone is replaced by a new stone;
the old stone's number multiplied by 2024 is engraved on the new stone.*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

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
}
