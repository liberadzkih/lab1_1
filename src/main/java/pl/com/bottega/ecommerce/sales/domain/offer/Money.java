package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private String currency;
    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
        this.currency = null;
    }

    public Money(String currency, BigDecimal value) {
        this.currency = currency;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(getCurrency(), money.getCurrency()) &&
                Objects.equals(getValue(), money.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrency(), getValue());
    }

}
