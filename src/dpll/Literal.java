package dpll;

public class Literal {

    private Boolean sign;

    private Integer value;

    Literal() {
    }

    Literal(Boolean sign, Integer value) {
        this.sign = sign;
        this.value = value;
    }

    public Boolean getSign() {
        return this.sign;
    }

    public void setSign(Boolean sign) {
        this.sign = sign;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Literal getNegated() {
        return new Literal(!this.sign, this.value);
    }


}
