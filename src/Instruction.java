
public class Instruction {
    Register A;
    Register B;
    Register C;
    InstructionPointer IP;
    public Instruction(Register A, Register B, Register C){
        this.A = A;
        this.B = B;
        this.C = C;
    }
   public void opcodeZero(Integer comboOperand){
       Integer value = (int) (this.A.getValue()/Math.pow(comboOperand,2));
       this.A.setValue(value);
       Integer currentIPCount = IP.getPointer()+2;
       IP.setPointer(currentIPCount);
   }
    public void opcodeOne(Integer litOperand){
        Integer value = this.A.getValue()^litOperand;
        this.B.setValue(value);
        Integer currentIPCount = IP.getPointer()+2;
        IP.setPointer(currentIPCount);
    }
    public void opcodeTwo(Integer comboOperand){
        Integer value = comboOperand%8;
        this.B.setValue(value);
        Integer currentIPCount = IP.getPointer()+2;
        IP.setPointer(currentIPCount);
    }
    public void opcodeThree(Integer litOperand){
        if (litOperand!=0){
            IP.setPointer(litOperand);
        }
        else{
            Integer currentIPCount = IP.getPointer()+2;
            IP.setPointer(currentIPCount);
        }
    }
    public void opcodeFour(){
        Integer value = this.B.getValue()^this.C.getValue();
        this.B.setValue(value);
        Integer currentIPCount = IP.getPointer();
        IP.setPointer(currentIPCount);
    }
    public Integer opcodeFive(Integer comboOperand){
        Integer currentIPCount = IP.getPointer()+2;
        IP.setPointer(currentIPCount);
        return comboOperand%8;
    }


    public void opcodeSix(Integer comboOperand){
        Integer value = (int) (this.A.getValue()/Math.pow(comboOperand,2));
        this.B.setValue(value);
        Integer currentIPCount = IP.getPointer()+2;
        IP.setPointer(currentIPCount);
    }


    public void opcodeSeven(Integer comboOperand){
        Integer value = (int) (this.A.getValue()/Math.pow(comboOperand,2));
        this.C.setValue(value);
        Integer currentIPCount = IP.getPointer();
        IP.setPointer(currentIPCount);
    }



}
