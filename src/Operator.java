import java.util.ArrayList;

public class Operator {
    Register A;
    Register B;
    Register C;
    InstructionPointer IP;
    Operand operand;
    ArrayList<Integer> instructions;
    ArrayList<Integer> operands;

    public Operator(Integer Avalue, Integer Bvalue, Integer Cvalue,String programme){
        this.A = new Register(Avalue);
        this.B = new Register(Bvalue);
        this.C = new Register(Cvalue);
        this.IP = new InstructionPointer();
        this.IP.setPointer(0);
        InstructionParser parser = new InstructionParser(programme);
        this.instructions = parser.getInstructions();
        this.instructions.add(-1);
        this.operands = parser.getOperands();

    }
    public String execute(){
        int i = 0;
        String temp="";
        while (instructions.get(i) !=-1){
            if (instructions.get(i).equals(0)){
                Integer operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                opcodeZero(operandValue);
            }
            else if (instructions.get(i).equals(1)) opcodeOne(operands.get(i));
            else if (instructions.get(i).equals(2)){
                Integer operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                opcodeTwo(operandValue);

            }
            else if (instructions.get(i).equals(3)) opcodeThree(operands.get(i));

            else if (instructions.get(i).equals(4)) opcodeFour();

            else if (instructions.get(i).equals(5)){
                Integer operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                temp += this.opcodeFive(operandValue)+",";

            }
            else if (instructions.get(i).equals(6)){
                Integer operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                this.opcodeSix(operandValue);
            }
            else if (instructions.get(i).equals(7)){
                Integer operandValue = Operand.getOperandValue(this.operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                opcodeSeven(operandValue);
            }
            i = this.IP.getPointer();
        }
        return temp;
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
