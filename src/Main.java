import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;



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
        /*inputDownloader.downloadInput("https://adventofcode.com/2024/day/8/input", "dayEightInput");
        ArrayList<String> dayEightInput = scanner.loadAsArray("dayEightInput");
        ArrayList<String> matrix = new ArrayList<>(dayEightInput);
        ArrayList<String> matrixPartOne;
        ArrayList<String> matrixResonant;
        int bound = matrix.size();
        ArrayList<Node> nodes = Uti.getNodes(matrix);
        matrixPartOne = Uti.makeNewMatrices(nodes,dayEightInput,bound,true);
        matrixResonant = Uti.makeNewMatrices(nodes,dayEightInput,bound,false);
        int totalOne = Uti.countAntinodesPartOne(matrixPartOne);
        Uti.printMatrix(matrixPartOne);
        System.out.println("Part one answer: "+totalOne+"\n");
        int total = Uti.countAntinodesPartTwo(matrixResonant);
        Uti.printMatrix(matrixResonant);
        System.out.println("Part two answer: "+total);*/
        ////////////////////////////////////////////////////Day Nine/////////////////////////////////////////////////
        //inputDownloader.downloadInput("https://adventofcode.com/2024/day/9/input", "dayNineInput");
        // String dayNineInput = scanner.loadAsString("dayNineInput");
        //String inptStr ="2333133121414131402";
        /*String newString = DayNine.constructString(inptStr);
        //String newString = DayNine.constructString(dayNineInput);
        ArrayList<String> input = new ArrayList<String> (List.of(newString.split(",")));
        int countUp = 0;
        int countDown = input.size();
        while (countDown > 0  && countUp < input.size()){
            countDown = input.size()-1;
             String onLeft = input.get(countUp);
             String onRight = input.get(countDown);
             if (onLeft.equals(".") && onRight.equals(".")) input.remove(countDown);
             else {
                 if (!onLeft.equals(".") && !onRight.equals(".")) countUp+=1;
                 else if (onLeft.equals(".")){
                     input.set(countUp, onRight);
                     input.remove(countDown);
                     countUp+=1;
                 }
                 else input.remove(countDown);
             }
             }

       int index = 0;
        BigInteger total  = BigInteger.valueOf(0);
        while(index < input.size() ){
            BigInteger temp = BigInteger.valueOf((long) index * Integer.parseInt(input.get(index)));
            total = total.add(temp);
            index+=1;
        }
        System.out.println(total);*/
        //ArrayList<Integer> output = DayNine.fillInSpaces(inptStr);
        //System.out.println(output);
        //////////////////////////////////////////////Day 17//////////////////////////////////////////////////
/*        String programme = "2,4,1,1,7,5,1,5,4,2,5,5,0,3,3,0";

        int len = programme.length()/2;
        Operator operator = new Operator(0,0,0,programme);
       // System.out.println("Part one answer: "+operator.execute());
        long num = (long)Math.pow(10,(len))/8;
        System.out.println(num);
        long num2 = num-117340;
        operator = new Operator(num,0,0,programme);
        String output= operator.execute();
        output = output.substring(0,output.length()-1);
       while(!programme.equals(output)&& num >0) {
           num= num-1;
           operator = new Operator(num, 0, 0, programme);
           output = operator.execute();
           output = output.substring(0,output.length()-1);
           if (num>num2) System.out.println(num+"\n"+output+",\n"+programme);
       }

       System.out.println(num);*/

        // inputDownloader.downloadInput("https://adventofcode.com/2024/day/2/input", "dayTwoInput");
        ArrayList<String> dayTenInputRaw = scanner.loadAsArray("dayTenTest");
        // Day10Recursion.countTrails(dayTenInputRaw);
        //String input = "337 42493 1891760 351136 2 6932 73 0";
        String input = "125 17";
        HashMap<Long, Long> stones = DayEleven.makeStones(input);
        Integer blinks = 0;
        HashMap<Long, ArrayList<Long>> dictionary = new HashMap<>();
        HashMap<Long, Long> stonesNotInDict = new HashMap<>();
        HashMap<Long, Long> stonesInDict = new HashMap<>();
        while (blinks < 5) {
            for (Long stone : stones.keySet()) {
                Long numOfParent = stones.get(stone);
                if (dictionary.containsKey(stone)) {
                    ArrayList<Long> spawns = dictionary.get(stone);

                    for (Long spawn : spawns) {
                        if (stonesInDict.containsKey(spawn)) {
                            Long count = stonesInDict.get(spawn);
                            stonesInDict.put(spawn, count + numOfParent);
                        } else {
                            stonesInDict.put(spawn, numOfParent);
                        }
                    }
                } else{
                    if (stonesNotInDict.containsKey(stone)) {
                        Long count = stonesNotInDict.get(stone);
                        stonesNotInDict.put(stone, count + numOfParent);
                    } else {
                        stonesNotInDict.put(stone, numOfParent);
                    }
                }
            }
            if (!stonesNotInDict.isEmpty()) {
                for (Long each : stonesNotInDict.keySet()) {
                    ArrayList<Long> spawns = Stone.transform(each);
                    Long numOfParent = stonesNotInDict.get(each);

                    dictionary.put(each, spawns);
                    for (Long spawn : spawns) {

                        if (stonesInDict.containsKey(spawn)) {
                            Long count = stonesInDict.get(spawn);
                            stonesInDict.put(spawn, count + numOfParent);
                        } else {
                            stonesInDict.put(spawn, numOfParent);
                        }
                    }
                }
            }
            stones.clear();
            for (Long key : stonesInDict.keySet()) {
                stones.put(key, stonesInDict.get(key)); // Use copy constructor for deep clone
            }
                stonesNotInDict.clear();
                stonesInDict.clear();
                blinks += 1;
                //System.out.println(blinks+","+stones.size());

            }
        Long total = 0L;
        for ( Long key : stones.keySet()){
            total+=stones.get(key);
            System.out.println(key+","+stones.get(key));
        }
        System.out.println(total);

        }
}