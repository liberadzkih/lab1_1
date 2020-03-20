package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value) &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
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

    public Money multiply(int quantity) {
        return new Money(value).multiply(quantity);
    }

    public Money subtract(Money money) {
        return new Money(value.subtract(money.getValue()));
    }
}
