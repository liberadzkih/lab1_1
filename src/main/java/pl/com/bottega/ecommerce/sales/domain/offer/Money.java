package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Money {

    private String currency;
    private BigDecimal value;

    public Money() {
        value = new BigDecimal(0);
    }

    public Money(BigDecimal value ) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
