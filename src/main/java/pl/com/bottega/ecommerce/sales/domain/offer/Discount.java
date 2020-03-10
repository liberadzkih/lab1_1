package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String cause;

    private Money value;

    public Discount(Money value) {
        this.cause = null;
        this.value = value;
    }

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }
    public BigDecimal getValue() {
        return value.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(cause, discount.cause) &&
                Objects.equals(value, discount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cause, value);
    }

    public String getCause() {
        return cause;
    }
}
