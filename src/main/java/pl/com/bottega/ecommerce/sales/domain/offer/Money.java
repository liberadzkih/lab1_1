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

    Money multiply(int factor){
        this.value = this.value.multiply(new BigDecimal(factor));
        return this;
    }

    Money subtract(Money subtrahend){
        this.value = this.value.subtract(subtrahend.getValue());
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Money other = (Money) obj;

        return this.value.equals(other.getValue())
               && this.currency.equals(other.getCurrency());

    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
