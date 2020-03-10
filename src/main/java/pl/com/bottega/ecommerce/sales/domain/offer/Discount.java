package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private String cause;

    private Money value;

    public Discount(Money value) {
        this.cause = null;
        this.value = value;
    }

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }
    public BigDecimal getValue() {
        return value.getValue();
    }

    public String getCause() {
        return cause;
    }
}
