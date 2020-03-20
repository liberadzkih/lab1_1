package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal amount;
    private String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
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
        return Objects.equals(getAmount(), money.getAmount()) &&
                Objects.equals(getCurrency(), money.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getCurrency());
    }

    public Money multiply(int number) {
        return new Money(getAmount().multiply(new BigDecimal(number)), null);
    }

    public Money substract(Money value) {
        return new Money(getAmount().subtract(value.getAmount()), null);
    }
}
