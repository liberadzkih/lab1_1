package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Cash {

    private String currency;

    private BigDecimal value;

    public Cash(String currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
