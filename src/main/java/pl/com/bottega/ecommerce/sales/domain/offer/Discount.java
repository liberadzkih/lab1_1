package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String cause;
    private Money value;

    public Discount(String cause) {
        cause = cause;
        value= new Money();
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        cause = cause;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }



}
