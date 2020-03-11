package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal value;

    private String currency;

    public Money(BigDecimal value) {
        this(value, null);
    }

    public Money(BigDecimal value, String currecy) {
        this.value = value;
        this.currency = currecy;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public Money multiply(BigDecimal multiplier) {
        this.value = this.value.multiply(multiplier);
        return this;
    }

    public Money subtract(BigDecimal subtrahend) {
        this.value = this.value.subtract(subtrahend);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
