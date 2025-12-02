import java.util.ArrayList;

public class IdRange {
    long start;
    long end;
    IdRange(long start, long end){
        this.start= start;
        this.end = end;
    }
    ArrayList<Long> findInvalid() {
        ArrayList<Long> invalidIds = new ArrayList<>();

        for (long i = start; i < end; i++) {
                String numberAsString = Long.toString(i);
                int mid = numberAsString.length() / 2;
                String firstHalf = numberAsString.substring(0, mid);
                String secondHalf = numberAsString.substring(mid);
                if (firstHalf.equals(secondHalf)) {
                    invalidIds.add(i);
                }

        }
        return invalidIds;
    }

}
