public class Operand {
    public static long getOperandValue(long operand, long registerA,long registerB,long registerC){
        if (operand<=3||operand==7) return operand;
        else if (operand==4) return registerA;
        else if (operand==5) return registerB;
        return registerC;
    }
}
