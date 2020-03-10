package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigInteger;

public class Money {
    private BigInteger value;
    private String currency;
    
    public Money(BigInteger value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigInteger getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
