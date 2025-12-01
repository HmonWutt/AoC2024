import java.io.File;
import java.io.*;
import java.util.ArrayList;
public class ReadFromFileUsingScanner {

    public ArrayList<String> loadAsArray(String filename) throws Exception {
        ArrayList<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
           while (br.ready()){
               input.add(br.readLine());
           }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return input;
    }
    public String loadAsString(String filename) throws Exception {

        StringBuilder output = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            while(br.ready()){
                output.append(br.readLine());

            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return output.toString();
    }
    public String keepLineBreaks(String filename) throws Exception{
        StringBuilder output = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.ready()) {
                output.append(br.readLine()).append("\n");  // Append the line and then a newline character
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return output.toString();
    }

}