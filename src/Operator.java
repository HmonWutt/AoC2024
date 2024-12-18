
public class Operator {
    Register A;
    Register B;
    Register C;
    InstructionPointer IP;
    Operand operand;

    public Operator(Integer Avalue, Integer Bvalue, Integer Cvalue){
        this.A = new Register(Avalue);
        this.B = new Register(Bvalue);
        this.C = new Register(Cvalue);
        this.IP = new InstructionPointer();
        this.IP.setPointer(0);
    }
    public Integer getInstruction(){
        return this.IP.getPointer();
    }

    public void setInstruction(Integer value){
        this.IP.setPointer(value);
    }
   public void opcodeZero(Integer comboOperand){
       Integer value = (int) (this.A.getValue()/Math.pow(2,comboOperand));
       this.A.setValue(value);
       Integer currentIPCount = this.IP.getPointer()+1;
       this.IP.setPointer(currentIPCount);
   }
    public void opcodeOne(Integer litOperand){
        Integer value = this.B.getValue()^litOperand;
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }
    public void opcodeTwo(Integer comboOperand){
        Integer value = comboOperand%8;
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }
    public void opcodeThree(Integer litOperand){
        if (this.A.getValue()!=0){
            this.IP.setPointer(litOperand);
        }
        else{
            Integer currentIPCount = this.IP.getPointer()+1;
            this.IP.setPointer(currentIPCount);
        }
    }
    public void opcodeFour(){
        Integer value = this.B.getValue()^this.C.getValue();
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }
    public Integer opcodeFive(Integer comboOperand){
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
        return comboOperand%8;
    }


    public void opcodeSix(Integer comboOperand){
        Integer value = (int) (this.A.getValue()/Math.pow(2,comboOperand));
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }


    public void opcodeSeven(Integer comboOperand){
        Integer value = (int) (this.A.getValue()/Math.pow(2,comboOperand));
        this.C.setValue(value);
        Integer currentIPCount = IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }



}
