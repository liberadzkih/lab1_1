package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private Money discountValue;
    private String cause;

    Discount(Money discountValue, String cause) {
        this.discountValue = discountValue;
        this.cause = cause;
    }

    public Money getDiscountValue() {
        return discountValue;
    }

    public String getCause() {
        return cause;
    }
}
