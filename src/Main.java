import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        AoCInputDownloader inputDownloader = new AoCInputDownloader();
        ReadFromFileUsingScanner scanner = new ReadFromFileUsingScanner();

        //////-------------------------------------DAY ONE------------------------------------------------////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/1/input", "dayOneInput");
        ArrayList<String> dayOneInputRaw = scanner.loadAsArray("dayOneInput");
        LeftAndRightComparison dayOneInputCleaned = new LeftAndRightComparison(dayOneInputRaw);
        int partOneTotal = dayOneInputCleaned.getTotalDifference();
        //part-one
        System.out.println("Part one answer: " + partOneTotal);
        //part-two
        Dictionary rightAppearsInTheLeft = new Dictionary(dayOneInputCleaned);
        System.out.println("Part two answer: " + rightAppearsInTheLeft.multiplyKeysAndValues());

        //////-------------------------------------DAY TWO------------------------------------------------////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/2/input", "dayTwoInput");
        ArrayList<String> dayTwoInputRaw = scanner.loadAsArray("dayTwoInput");
        DayTwo totalReports = new DayTwo(dayTwoInputRaw);
        int totalSafeReports = totalReports.getSafeReports();
        System.out.println(totalSafeReports);
        int allowedOneUnsafe = totalReports.allowOneUnsafe();
        System.out.println(allowedOneUnsafe);

        //////-------------------------------------DAY THREE------------------------------------------------////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/3/input", "dayThreeInput");
        String dayThreeInputRaw = scanner.loadAsString("dayThreeInput");
        String entireMatchPattern = "mul\\((-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)\\)";
        int total = DayThree.checkInputStringForMultiplications(entireMatchPattern, dayThreeInputRaw);
        System.out.println("Day three part one: "+total);
        String entireMatchPatternSecond = "do\\(\\)|don\\'t\\(\\)|mul\\((-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)\\)";
        int totalTwo = DayThree.findAll(entireMatchPatternSecond, dayThreeInputRaw);
        System.out.println("Day three part two: "+ totalTwo);

        //////-------------------------------------DAY FOUR------------------------------------------------////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/4/input", "dayFourInput");
        ArrayList<String> originalMatrix = scanner.loadAsArray("dayFourInput");
        //ArrayList<String> originalMatrix = scanner.loadAsArray("dayFourTest");
        int totalXMASES = 0;
        String partOnePattern = "XMAS";
        totalXMASES+=DayFour.findXMAS(partOnePattern,originalMatrix);
        ArrayList<String> diagnolaisedOriginalMatrix = DayFour.diagnoalise(originalMatrix);
        totalXMASES+=DayFour.findXMAS(partOnePattern,diagnolaisedOriginalMatrix);
        ArrayList<String> rowsAndColsSwappedMatrix = DayFour.swapRowsAndCols(originalMatrix);
        totalXMASES+=DayFour.findXMAS(partOnePattern,rowsAndColsSwappedMatrix);
        ArrayList<String> swappedRowsAndColsReversed = DayFour.reverse(rowsAndColsSwappedMatrix);
        ArrayList<String> diagnolaisedSwappedRowsAndCols = DayFour.diagnoalise(swappedRowsAndColsReversed);
        totalXMASES+=DayFour.findXMAS(partOnePattern,diagnolaisedSwappedRowsAndCols);
        System.out.println("Day four part one: "+ totalXMASES);
        int totalFourTwo=0;
        totalFourTwo+= DayFour.findCrossedMas(originalMatrix);
        System.out.println(totalFourTwo);

        /////////////////////////////////////////DAY FIVE//////////////////////////////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/5/input", "dayFiveInput");
        ArrayList<String> dayFiveInput = scanner.loadAsArray("dayFiveInput");
        int index = 0;
        ArrayList<String> topHalf = new ArrayList<>();
        ArrayList<String> bottomHalf = new ArrayList<>();

        while (!dayFiveInput.get(index).isEmpty()){
            topHalf.add(dayFiveInput.get(index));
            index++;
        }
        index++;
        while(index < dayFiveInput.size()){
           bottomHalf.add(dayFiveInput.get(index)) ;
           index++;
        }

    }
    }
