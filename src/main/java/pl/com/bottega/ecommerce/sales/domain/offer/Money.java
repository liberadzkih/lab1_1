package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    private BigDecimal value;
    private String currency;

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public Money multiply(int multiplier) {
        this.value = value.multiply(new BigDecimal(multiplier));
        return this;
    }

    public Money subtract(BigDecimal subtrahend) {
        this.value = value.subtract(subtrahend);
        return this;
    }
}
