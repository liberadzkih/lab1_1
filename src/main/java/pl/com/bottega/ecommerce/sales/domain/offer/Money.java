package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {

    private BigDecimal value;
    private String currency;
    public Money(BigDecimal value)
    {
        this(value,null);
    }
    public Money(BigDecimal value, String currency)
    {
        this.currency = currency;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
