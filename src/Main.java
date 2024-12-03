import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        AoCInputDownloader inputDownloader = new AoCInputDownloader();
        ReadFromFileUsingScanner scanner = new ReadFromFileUsingScanner();

        //////-------------------------------------DAY ONE------------------------------------------------////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/1/input","dayOneInput");
        ArrayList<String> dayOneInputRaw = scanner.load("dayOneInput");
        LeftAndRightComparison dayOneInputCleaned = new LeftAndRightComparison(dayOneInputRaw);
        int partOneTotal = dayOneInputCleaned.getTotalDifference();
        //part-one
        System.out.println("Part one answer: "+partOneTotal);
        //part-two
        Dictionary rightAppearsInTheLeft = new Dictionary(dayOneInputCleaned);
        System.out.println("Part two answer: "+ rightAppearsInTheLeft.multiplyKeysAndValues());

        //////-------------------------------------DAY TWO------------------------------------------------////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/2/input","dayTwoInput");
        ArrayList<String> dayTwoInputRaw = scanner.load("dayTwoInput");
        DayTwo totalReports = new DayTwo(dayTwoInputRaw);
        int totalSafeReports = totalReports.getSafeReports();
        System.out.println(totalSafeReports);
        int allowedOneUnsafe = totalReports.allowOneUnsafe();
        System.out.println(allowedOneUnsafe);


    }

}