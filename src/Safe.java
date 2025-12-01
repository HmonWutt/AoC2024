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
}
