import java.math.BigInteger;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        AoCInputDownloader inputDownloader = new AoCInputDownloader();
        ReadFromFileUsingScanner scanner = new ReadFromFileUsingScanner();

        //////-------------------------------------DAY ONE------------------------------------------------////////
       /* inputDownloader.downloadInput("https://adventofcode.com/2024/day/1/input", "dayOneInput");
        ArrayList<String> dayOneInputRaw = scanner.loadAsArray("dayOneInput");
        LeftAndRightComparison dayOneInputCleaned = new LeftAndRightComparison(dayOneInputRaw);
        int partOneTotal = dayOneInputCleaned.getTotalDifference();
        //part-one
        System.out.println("Part one answer: " + partOneTotal);
        //part-two
        Dictionary rightAppearsInTheLeft = new Dictionary(dayOneInputCleaned);
        System.out.println("Part two answer: " + rightAppearsInTheLeft.multiplyKeysAndValues());*/

        //////-------------------------------------DAY TWO------------------------------------------------////////
      /*  inputDownloader.downloadInput("https://adventofcode.com/2024/day/2/input", "dayTwoInput");
        ArrayList<String> dayTwoInputRaw = scanner.loadAsArray("dayTwoInput");
        DayTwo totalReports = new DayTwo(dayTwoInputRaw);
        int totalSafeReports = totalReports.getSafeReports();
        System.out.println(totalSafeReports);
        int allowedOneUnsafe = totalReports.allowOneUnsafe();
        System.out.println(allowedOneUnsafe);
*/
        //////-------------------------------------DAY THREE------------------------------------------------////////
     /*   inputDownloader.downloadInput("https://adventofcode.com/2024/day/3/input", "dayThreeInput");
        String dayThreeInputRaw = scanner.loadAsString("dayThreeInput");
        String entireMatchPattern = "mul\\((-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)\\)";
        int total = DayThree.checkInputStringForMultiplications(entireMatchPattern, dayThreeInputRaw);
        System.out.println("Day three part one: "+total);
        String entireMatchPatternSecond = "do\\(\\)|don\\'t\\(\\)|mul\\((-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)\\)";
        int totalTwo = DayThree.findAll(entireMatchPatternSecond, dayThreeInputRaw);
        System.out.println("Day three part two: "+ totalTwo);*/

        //////-------------------------------------DAY FOUR------------------------------------------------////////
      /*  inputDownloader.downloadInput("https://adventofcode.com/2024/day/4/input", "dayFourInput");
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
        System.out.println(totalFourTwo);*/

        /////////////////////////////////////////DAY FIVE//////////////////////////////////
        //inputDownloader.downloadInput("https://adventofcode.com/2024/day/5/input", "dayFiveInput");
        //ArrayList<String> dayFiveInput = scanner.loadAsArray("dayFiveInput");
        //Page all = new Page(dayFiveInput);
        //System.out.println("All pages in order: "+all.checkPagesInOrder());
        //for(String each:all.bottomHalf)System.out.println(each);
        //////////////////////////////////////////Day SIX///////////////////////////////////////
       // inputDownloader.downloadInput("https://adventofcode.com/2024/day/6/input", "daySixInput");
        //ArrayList<String> daySixInput = scanner.loadAsArray("daySixInput");
        //Guard guard = new Guard();
         //guard.navigateMatrix(daySixInput, true);
        //System.out.println("unique spots: "+numberOfUniqueSpots);
        //guard.decidePositionOfObsticle(daySixInput);
        /////////////////////////////////Day Eight////////////////////////////////
        //inputDownloader.downloadInput("https://adventofcode.com/2024/day/7/input", "daySevenInput");
        //ArrayList<String> daySevenInput = scanner.loadAsArray("daySevenInput");

        //BigInteger countTrueTests = TestFile.addTrueTestValues(daySevenInput,true);/////change to false to get part one answer
        //System.out.println("Tests that are true: "+countTrueTests);
        /////////////////////////////////Day Eight///////////////////////////////////
        inputDownloader.downloadInput("https://adventofcode.com/2024/day/8/input", "dayEightInput");
        ArrayList<String> dayEightInput = scanner.loadAsArray("dayEightInput");
        ArrayList<String> matrix = new ArrayList<>(dayEightInput);
        ArrayList<String> matrixResonant = new ArrayList<>();
        int bound = matrix.size();
        ArrayList<Node> nodes = Uti.getNodes(matrix);
        matrixResonant = Uti.makeNewMatrices(nodes,dayEightInput,bound);
        int total = Uti.countAntinodesPartTwo(matrixResonant);
        Uti.printMatrix(matrixResonant);
        System.out.println(total);

   /*     String inptStr ="2333133121414131402";
        ArrayList<Integer> updatedString = new ArrayList<>(Collections.nCopies(200, 0));
        int freeSpaceStartIndex = 1;
        int lengthOfString = inptStr.length();

        //int lastValue = inptStr.charAt(currentIndex);
        int total = 0;
        int nonFreeSpaceIndex = 0;
        int freeSpaceIndex =1;
        int firstValue=0;
        int firstValueIndex = 0;
        int indexToUpdateNewArray = 0;
        int oldStringIndex = 0;
        int lastValue = lengthOfString-1;
        //lastValue = DayNineUtil.charToInt(inptStr,currentIndex);
        while ( lastValue >0 && oldStringIndex<lengthOfString) {
            while (oldStringIndex%2==0){
                int freeSpaceNeededForThisValue = DayNineUtil.charToInt(inptStr, oldStringIndex);
                while (freeSpaceNeededForThisValue > 0) {
                    updatedString.set(indexToUpdateNewArray,firstValue) ;
                    freeSpaceNeededForThisValue -= 1;
                   indexToUpdateNewArray += 1;
                }
                oldStringIndex += 1;
                firstValue+=1;
            }

            int freeSpaceAvailable = DayNineUtil.charToInt(inptStr, oldStringIndex);
            int freeSpaceNeededForThisValue = DayNineUtil.charToInt(inptStr, oldStringIndex);
            while (freeSpaceNeededForThisValue > 0 && freeSpaceAvailable > 0) {
                //total += DayNineUtil.calculateIndexTimesValue(lastValue, runningIndex);
                //runningIndex += 1;
                updatedString.set(indexToUpdateNewArray ,lastValue);
                freeSpaceNeededForThisValue -= 1;
                freeSpaceAvailable -= 1;
                freeSpaceIndex+=1;
                indexToUpdateNewArray+=1;
            }
            if (freeSpaceNeededForThisValue == 0 && freeSpaceAvailable >0) {
                lastValue -=1;
            }

         *//*   while (freeSpaceNeededForThisValue > 0 && freeSpaceAvailable >0) {
                //total += DayNineUtil.calculateIndexTimesValue(lastValue, runningIndex);
                updatedString = updatedString + "," + lastValue ;
                //runningIndex += 1;
                freeSpaceNeededForThisValue -= 1;
                freeSpaceAvailable -= 1;
            }*//*
            if (freeSpaceAvailable ==0) {
                oldStringIndex += 1;

            }


        }
        System.out.println(updatedString);*/

    }

    }
