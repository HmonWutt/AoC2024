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
       inputDownloader.downloadInput("https://adventofcode.com/2024/day/9/input", "dayNineInput");
        String dayNineInput = scanner.loadAsString("dayNineInput");
        String inptStr ="4165261931348465148257526891997319774979708127681174451880385312374584944951482938128521845657178554196820974922443715498810177041367076743735244626739510641725717884642215688387956150743111954070324631998348724344527641901462813222544468129136623587256950235630638277651021303566167312779166166319338646818433865761614114924482632311971246202911423080742684554317585563524355479310339065991772529547581323165093822067312052197630619148658631539049663629766324667638379267465829684917596620549718294644469738476660593658276170646068892755361958875377456631358639714088773788635393837291757425931733652511769830709895711673483781465940746284494539319474845124498170783359622979188831914841476793995573128290203176439629641733213237415166329549677321214214317461165616674094359319871368282510739545706933142987413741867913839985701585367515624398526565313696514020784949304963835642609047599074717946499671271574303744451939595448549059331198383023505764514078531858686982503855318037117870184134891757469271233117638036881352777310678694552987753635924931911458445932829154783974589164866915842082843023431185769689224399986547146966511666188030208347184231564394842887204273787176303961119863927072173891613771496567878652262582974613864021253339342630649787289677442946481114836797393949522876117365674125981991562227934862933531217961263984195659323498921796704845875854635730774387864363123826438662158249621181292125861997226197415380284258463837139645253958271117156196918381289542452235219113199915367850543537731236776179147598512353251524917644995849206323513634983150805343512847322054484493341733521599443249103417355996417720207841332291762135885679216526781254494939643038245817472540751996927114197036582270102528866711351757147868885650319225703673872025855194745182889488921224296710298570723511682948573162456959195380583952261058529726805250314928144886643395892154633216914926122785783412188087843215241161517645851449443449647793589144604957899338185598276635242666651661334489687451666174347042386212486154282152982360755199328678776417531071285268301443154692354834827896879659614278344338718258847899651457854612223986828069835622192645734439535133448631729715876195503641545733894077121048664759347442189696741786106043865613813376549879198485295989981193942440821328542369964836293313665111419753886950124476491944881958222614614762406830228499664565891443941534381439191460578891933868872980813853268324389626505042812210778461717694984643569039427961123440825483895654387093157973728756773710179480858151458412593633381711252450633095352873427453158712943941497482333281143452844789767597656627342763912899988659607921202682576987733996105367683858412935827519374965129358199176898763823062803946211848468442321032663385924046251874765850212136665321602799438497134027785862265467925489573887699191357726938212622211808073242114716772938228538088938966991353537638153613943342682730979188385391951573785279681265543216954344614414538747843419773321343388628452823024188887373068227979676149347091928079463648987763738315813074463859653329633239919727435770249360499437532930348056485620116338401271141373482756421595311892535532758884258161195359577629705764171224877948706258582925848271599361525516721559835713575781274364193135311742932623529834314199535940851597532247383626642967526279213356381461407692671131448692182846667074661397252314846030833197505042844973767856513597469410959061547352895029344192568037489860891670483337554568128368617087599764314243741957621577249196138998794990718368889287474463211840419836579964246386807656684579363654525390342829142099637332511582995327357827624353549733187346622968136610385395353984179275995288341853966735473158894325904589963376627982469054806634271625704312976735683832254124111861849135347021944731731565261191831738965388147360873041967912549942621827941221303860424441308437716347706098831677392347442918125343212628382091762657701888283463896538581137689228774335568448108228235140526646718177853744941158495866734511611971244579505821611136137543305797159424507091957215177141394542615147139320485034899393905465177512155625708059796613943384802071651563965589199673302552439562979931631987194775628080682542212681758287704666816167576790839914944396733549423390412920393561607957993220528634833937654199804322712495945871526739856319662868749736831281694856835886901020291387312617407845732222161598644440954184352436402529217051865550476676503621671652983515371030906238167481877558194251759876887067624538304463969038933693388969944434363388349476924823678540679538859518439879862628947358937550522280176054654086205522363887527455377958602313449741739989477594158915218488996554808686552374908392197633326961288545384990228080343672972370148757997816908739483422132780605062299287201597551732907379995230615693523512661461918435193624118674324074574245407442782368622940967560414935569446615264995577459683331766737689867161972449584947927221602437662868205334868121359221223240836183701919779176979144685435601444783857595960234631829964748015315746549837335420499145807621848846199628432385273341855225501594405050856624105974706960708415406587231186901795741336593588196634119985456531503162676254394559232854624778799943779885224897146778743698333875599235119785511122212922855586836196929787487422259398589996305512355712504269897627893328641656489554598249704366536644326821802719143160969982529814492011896837982738514018255733282426386718525340219510628587761331992531636356181543879914707171329461823480342787767237118247207813175410321961895329871588279246776999873541141996923789902017926428488086641393551936725450371731278618682891118326276622179587756250855885234580254994504442273945699516203680414717741151246922205336519386538878371875117120941962221344882753428416713628686656956835174364134223724941747154995975536324833729327629968676188643768867602014654462801036647517841615287887295596845366792159928242815822616021391929532319425290498693962415994047382114814784444816982492176249747383743033862713473194891897764136134174213972378353528580713727754251609728227569182452525692564690259889678768696034622427859855978186581383405972777120601195986452717448916620153858504872531090884390733548203717889933137425498240132913351021624871312896148546696775773678269537406321716146984710492254708245554891195442638253828077534016912148791395495380621762364257684710428097405166524220799068584943977653955465511490912228278188115711108627551439686641985736263049936829729119112467853394805655601817893419195344623627989645128621836273692915564188272490881685391293338894649047141853765435615788396616435474289942834448337319348315865740189333206681983497409791243927717724468635494674212163853069264259568756733718156421285180365779405492362973687987337170431590764920768421465895564977343768991671185472583865805230932825923877615479747848549710843686249935767359387246122256776957764531521129659263748556435181354171299071565287175531624441667485293996719337209485646736843977641597171440363019194456722363558013598387574636177275957110537047438177389168302724516750542638402696544849346450778776772143717019515072285";
        //String newString = DayNine.constructString(inptStr);
        String newString = DayNine.constructString(dayNineInput);
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
        System.out.println(total);
    }


    }
