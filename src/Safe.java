import java.util.ArrayList;
import static java.lang.Math.abs;



public class Safe {
    int currentPosition1 = 50;
    int currentPosition=50;
    int count;
    int count1;

    public void turn(String instruction ){
        String direction = instruction.substring(0,1);
        int number = Integer.parseInt( instruction.substring(1));
        int rotations = 0;
        if (direction.equals("L")){
            rotations = this.currentPosition1 +100 - number%100;
        }
        else{
            rotations = number + this.currentPosition1;
        }
        this.currentPosition1 = abs(rotations)%100;
//        System.out.println(this.currentPosition1);
        if (this.currentPosition1 == 0){
            this.count1+=1;
        }
    }
    public void turnTwo(String instruction){
            String direction = instruction.substring(0,1);
            int number = Integer.parseInt( instruction.substring(1));
            if ( number>=100) {
                this.count+= (number/100);

            }
            int remainder = number %100;

            if (direction.equals("L")){
                int newPosition = abs(this.currentPosition +100 - remainder)%100;
                if (newPosition > this.currentPosition && this.currentPosition !=0 && newPosition !=0){
                    this.count+=1;
                }
                this.currentPosition = newPosition;
            }
            else{
                int newPosition = abs(this.currentPosition+remainder)%100;
                if (newPosition < this.currentPosition && this.currentPosition!=0 && newPosition !=0){
                    this.count+=  1;
                }
                this.currentPosition = newPosition;

            }
            if (this.currentPosition == 0) this.count+=1;
//            System.out.println("Instruction: "+instruction);
//            System.out.println("new position: "+ this.currentPosition);
//            System.out.println("Count : "+this.count);

        }

    public static void run(ArrayList<String> dayOne) {

//        ArrayList<String> dayOne = new ArrayList<>(Arrays.asList("L68","L30","R48","L5","R60","L55","L1","L99","R14","L82"));
        Safe safe = new Safe();
        for (String each:dayOne){
            safe.turn(each);
            safe.turnTwo(each);

        }
        System.out.println("Part one: "+safe.count1);
        System.out.println("Part two: "+safe.count);
    }
    }
