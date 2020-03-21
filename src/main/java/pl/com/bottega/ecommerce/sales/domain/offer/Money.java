package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal value;

    private String currency;

    public Money(BigDecimal value) {
        this.value = value;
        this.currency = null;
    }

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getDenomination() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public Money multiply(int quantity) {
        BigDecimal newValue = value.multiply(new BigDecimal(quantity));
        return new Money(newValue,currency);
    }

    public Money subtract(Money subtrahend) {
        BigDecimal newValue = value.subtract(subtrahend.getDenomination());
        return new Money(newValue, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(value, money.value) &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }
}
