

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        //////-------------------------------------DAY ONE------------------------------------------------////////
        AoCInputDownloader inputDownloader = new AoCInputDownloader();
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/1/input","dayOneInput");
        ReadFromFileUsingScanner scanner = new ReadFromFileUsingScanner();
        LeftAndRightComparison dayOneInputList = scanner.load("dayOneInput");
        int partOneTotal = dayOneInputList.getTotalDifference();
        //part-one
        System.out.println("Part one answer: "+partOneTotal);
        //part-two
        Dictionary rightAppearsInTheLeft = new Dictionary(dayOneInputList);
        System.out.println("Part two answer: "+ rightAppearsInTheLeft.multiplyKeysAndValues());

        //////-------------------------------------DAY TWO------------------------------------------------////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/2/input","dayTwoInput");


    }

}