package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {

    private BigDecimal value;

    private String currency;

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public Money(BigDecimal value) {
        this.value = value;
        this.currency = null;
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

    public Money multiply(int factor) {
        return new Money(this.value.multiply(new BigDecimal(factor)));
    }

    public Money subtract(Money subtrahend) {
        return new Money(this.value.subtract(subtrahend.value));
    }

    @Override public int hashCode() {
        return super.hashCode();
    }

    @Override public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
