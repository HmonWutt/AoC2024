public class Operand {
    public static Integer getOperandValue(Integer operand, Integer registerA,Integer registerB,Integer registerC){
        if (operand<=3||operand==7) return operand;
        else if (operand==4) return registerA;
        else if (operand==5) return registerB;
        return registerC;
    }
}
