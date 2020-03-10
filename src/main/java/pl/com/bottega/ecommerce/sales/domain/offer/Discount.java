package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private Money value;

    private String cause;

    public Discount(BigDecimal value, String currency, String cause) {
        this.cause = cause;
        BigDecimal discountValue = value == null ? new BigDecimal(0) : value;
        this.value = new Money(discountValue, currency);
    }

    public BigDecimal getValue() {
        return value.getValue();
    }

    public String getCause() {
        return cause;
    }
}
