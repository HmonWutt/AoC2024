import java.util.ArrayList;
import java.util.Collections;

public class LeftAndRightComparison {
    private final ArrayList<String>input;
    public ArrayList<Integer> left = new ArrayList<>();
    public ArrayList<Integer> right = new ArrayList<>();
    private int totalDifference = 0;

    public LeftAndRightComparison(ArrayList<String> input) {
        this.input = input;
        split();
    }
    private void split() {
        for (String each : this.input) {
            String[] output = each.split("\\s+");
            Integer leftHalf = Integer.parseInt(output[0]);
            Integer rightHalf = Integer.parseInt(output[1]);
            this.left.add(leftHalf);
            this.right.add(rightHalf);

        }
    }
    public ArrayList<Integer> getLeft() {
        return this.left ;
    }

    public ArrayList<Integer> getRight() {
        return right;
    }

    private void calculateTotalDifference() {
        ArrayList<Integer> left = this.left;
        Collections.sort(left);
        ArrayList<Integer> right = this.right;
        Collections.sort(right);
        int distance = 0;
        for (int i = 0; i < left.size(); i++) {
            //part one
            if (left.get(i) > right.get(i)) {
                distance = left.get(i) - right.get(i);
            } else {
                distance = right.get(i) - left.get(i);
            }
            this.totalDifference += distance;
        }
    }

    public int getTotalDifference() {
        calculateTotalDifference();
        return totalDifference;
    }
}


