package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private BigDecimal value;
    private String cause;

    public Discount(BigDecimal value, String cause) {
        this.value = value;
        this.cause = cause;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCause() {
        return cause;
    }
}
