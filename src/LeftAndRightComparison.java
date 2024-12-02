import java.util.ArrayList;
import java.util.Collections;

public class LeftAndRightComparison {

    public ArrayList<Integer> left;
    public ArrayList<Integer> right;
    private int totalDifference = 0;

    public void setLeft(ArrayList<Integer> left) {
        this.left = left;
    }

    public void setRight(ArrayList<Integer> right) {
        this.right = right;
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


