package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

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

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return Objects.equals(value, money.value) &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    public Money multiply(int multiplier) {
        this.value = this.value.multiply(new BigDecimal(multiplier));
        return this;
    }

    public Money subtract(Money subtrahend) {
        this.value = this.value.subtract(subtrahend.value);
        return this;
    }
}
