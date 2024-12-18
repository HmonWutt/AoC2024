public class Register {
    private long value;
    private String name;
    public Register( long value){
        this.value = value;
    }

    public void setValue(long newValue) {
        this.value = newValue;
    }

    public long getValue (){
        return this.value;
    }


}
