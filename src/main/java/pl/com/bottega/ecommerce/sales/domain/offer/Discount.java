package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private Money value;
    private String cause;

    Discount(Money value, String cause) {
        this.value = value;
        this.cause = cause;
    }

    public Money getValue() {
        return value;
    }

    public String getCause() {
        return cause;
    }
}
