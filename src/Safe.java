import static java.lang.Math.abs;
import static java.lang.Math.floorDiv;



public class Safe {
    int currentPosition = 50;
    int count;
    int count1;

    public void turn(String instruction ){
        String direction = instruction.substring(0,1);
        int number = Integer.parseInt( instruction.substring(1));
        int rotations = 0;
        if (direction.equals("L")){
            rotations = this.currentPosition +100 - number%100;
        }
        else{
            rotations = number + this.currentPosition;
        }
        this.currentPosition = abs(rotations)%100;
        System.out.println(this.currentPosition);
        if (this.currentPosition == 0){
            this.count+=1;
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
    }
