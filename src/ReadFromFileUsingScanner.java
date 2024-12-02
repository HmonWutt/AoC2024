import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFromFileUsingScanner {

    public LeftAndRightComparison load(String filename) throws Exception {

        // pass the path to the file as a parameter
        File file = new File(new File(System.getProperty("user.dir")) + "/" + filename);
        //System.out.println(System.getProperty("user.dir") + "/" +filename);
        Scanner sc = new Scanner(file);
        ArrayList<Integer> outputLeft = new ArrayList<>();
        ArrayList<Integer> outputRight = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\s+ ");
            outputLeft.add(Integer.valueOf(line[0]));
            outputRight.add(Integer.valueOf(line[1]));
        }
        LeftAndRightComparison leftAndRightComparison = new LeftAndRightComparison();
        leftAndRightComparison.setLeft(outputLeft);
        leftAndRightComparison.setRight(outputRight);
        return leftAndRightComparison;
    }

}