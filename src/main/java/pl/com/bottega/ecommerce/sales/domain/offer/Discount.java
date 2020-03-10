package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private Money value;

    private String cause;

    public Discount(BigDecimal value, String currency, String cause) {
        this.cause = cause;
        BigDecimal discountValue = value == null ? new BigDecimal(0) : value;
        this.value = new Money(discountValue, currency);
    }

    public BigDecimal getValue() {
        return value.getAmount();
    }

    public String getCause() {
        return cause;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Discount discount = (Discount) obj;
        return Objects.equals(value, discount.value) && Objects.equals(cause, discount.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, cause);
    }
}
