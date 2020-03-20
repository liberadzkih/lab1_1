package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Money {

    private String currency;
    private BigDecimal value;

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public Money() {
        value = new BigDecimal(0);
    }

    public void setValue(BigDecimal value) { this.value = value; }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value,currency);
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
        return Objects.equals(value, other.getValue())
               && Objects.equals(currency, other.getCurrency());
    }

    public BigDecimal multiply(BigDecimal bigDecimal) {
        return value.multiply(bigDecimal);
    }
}
