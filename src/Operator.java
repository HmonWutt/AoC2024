import java.util.ArrayList;

public class Operator {
    private final Register A;
    private final Register B;
    private final Register C;
    private final InstructionPointer IP;
    private Operand operand;
    private final ArrayList<Integer> instructions;
    private final ArrayList<Integer> operands;
    private String programme;

    public Operator(long Avalue, long Bvalue, long Cvalue, String programme){
        this.A = new Register(Avalue);
        this.B = new Register(Bvalue);
        this.C = new Register(Cvalue);
        this.IP = new InstructionPointer();
        this.IP.setPointer(0);
        InstructionParser parser = new InstructionParser(programme);
        this.instructions = parser.getInstructions();
        this.instructions.add(-1);
        this.operands = parser.getOperands();
        this.programme = programme;

    }

    public String execute(){
        int i = 0;
        String temp="";
        while (instructions.get(i) !=-1){
            if (instructions.get(i).equals(0)){
                long operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                opcodeZero(operandValue);
            }
            else if (instructions.get(i).equals(1)) opcodeOne(operands.get(i));
            else if (instructions.get(i).equals(2)){
                long operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                opcodeTwo(operandValue);

            }
            else if (instructions.get(i).equals(3)) opcodeThree(operands.get(i));

            else if (instructions.get(i).equals(4)) opcodeFour();

            else if (instructions.get(i).equals(5)){
                long operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                temp += this.opcodeFive(operandValue)+",";

            }
            else if (instructions.get(i).equals(6)){
                long operandValue = Operand.getOperandValue(operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                this.opcodeSix(operandValue);
            }
            else if (instructions.get(i).equals(7)){
                long operandValue = Operand.getOperandValue(this.operands.get(i),
                        this.A.getValue(),
                        this.B.getValue(),
                        this.C.getValue());
                opcodeSeven(operandValue);
            }
            i = this.IP.getPointer();
        }
        return temp;
    }
   public void opcodeZero(long comboOperand){
       long value = (long) (this.A.getValue()/Math.pow(2,comboOperand));
       this.A.setValue(value);
       Integer currentIPCount = this.IP.getPointer()+1;
       this.IP.setPointer(currentIPCount);
   }
    public void opcodeOne(long litOperand){
        long value = this.B.getValue()^litOperand;
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }
    public void opcodeTwo(long comboOperand){
        long value = comboOperand%8;
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }
    public void opcodeThree(int litOperand){
        if (this.A.getValue()!=0){
            this.IP.setPointer(litOperand);
        }
        else{
            Integer currentIPCount = this.IP.getPointer()+1;
            this.IP.setPointer(currentIPCount);
        }
    }
    public void opcodeFour(){
        long value = this.B.getValue()^this.C.getValue();
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }
    public long opcodeFive(long comboOperand){
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
        return comboOperand%8;
    }


    public void opcodeSix(long comboOperand){
        long value = (long) (this.A.getValue()/Math.pow(2,comboOperand));
        this.B.setValue(value);
        Integer currentIPCount = this.IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }


    public void opcodeSeven(long comboOperand){
        long value = (long) (this.A.getValue()/Math.pow(2,comboOperand));
        this.C.setValue(value);
        Integer currentIPCount = IP.getPointer()+1;
        this.IP.setPointer(currentIPCount);
    }

}
