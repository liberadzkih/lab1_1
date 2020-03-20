package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String cause;

    private Money value;

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    @Override public int hashCode() {
        return super.hashCode();
    }

    @Override public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
