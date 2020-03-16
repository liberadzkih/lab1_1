package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private String currency;
    private BigDecimal value;

    public Money(String currency,BigDecimal value){
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency,value);
    }

    public BigDecimal multiply(BigDecimal bigDecimal) {
        return this.getValue().multiply(bigDecimal);
    }

    /*public BigDecimal subtract(BigDecimal bigDecimal)
    {
        return this.getValue().subtract(bigDecimal);
    }*/
    /*public Money add(BigDecimal discount) {
        value = value.add(discount);
        return this;
    }*/


}
