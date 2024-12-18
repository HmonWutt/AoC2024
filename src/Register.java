public class Register {
    private Integer value;
    private String name;
    public Register( Integer value){
        this.value = value;
    }

    public void setValue(Integer newValue) {
        this.value = newValue;
    }

    public Integer getValue (){
        return this.value;
    }


}
