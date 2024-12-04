import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFromFileUsingScanner {

    public ArrayList<String> load(String filename) throws Exception {

        // pass the path to the file as a parameter
        File file = new File(new File(System.getProperty("user.dir")) + "/" + filename);
        //System.out.println(System.getProperty("user.dir") + "/" +filename);
        Scanner sc = new Scanner(file);
        ArrayList<String> output = new ArrayList<>();


        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            output.add(line);
        }

        return output;
    }
    public String loadAsString(String filename) throws Exception {

        // pass the path to the file as a parameter
        File file = new File(new File(System.getProperty("user.dir")) + "/" + filename);
        //System.out.println(System.getProperty("user.dir") + "/" +filename);
        Scanner sc = new Scanner(file);
        String output = "";

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            output+=line;
        }

        return output;
    }

}