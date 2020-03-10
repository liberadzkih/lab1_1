package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Discount {
    private String cause;
    private Money value;

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public Money getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Discount discount = (Discount) o;
        return Objects.equals(getCause(), discount.getCause()) &&
                Objects.equals(getValue(), discount.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCause(), getValue());
    }
}
