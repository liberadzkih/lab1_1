package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private String currency;
    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
        this.currency = null;
    }

    public Money(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money substract(Money subtrahend){
        return new Money(amount.subtract(subtrahend.getAmount()));
    }
    public Money multiply(int multiplicand){
        return new Money(amount.multiply(new BigDecimal(multiplicand)));
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(getCurrency(), money.getCurrency()) &&
                Objects.equals(getAmount(), money.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrency(), getAmount());
    }


}
