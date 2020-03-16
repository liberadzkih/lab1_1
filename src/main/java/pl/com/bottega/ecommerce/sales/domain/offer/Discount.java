package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String cause;
    private Money value;

    public Discount(String cause,Money value){
        this.cause = cause;
        this.value = value;
    }

    public Money getDiscount() {
        return value;
    }

    public String getCause() {
        return cause;
    }
}
