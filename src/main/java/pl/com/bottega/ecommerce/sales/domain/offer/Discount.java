package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Discount {

    private Money value;
    private String cause;

    Discount(Money value, String cause) {
        this.value = value;
        this.cause = cause;
    }

    public Money getValue() {
        return value;
    }

    public String getCause() {
        return cause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount = (Discount) o;
        return Objects.equals(value, discount.value) && Objects.equals(cause, discount.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, cause);
    }
}
