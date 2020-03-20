package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Discount {

    private Money value;

    private String cause;

    public Discount(Money value, String cause) {
        this.value = value;
        this.cause = cause;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Discount discount = (Discount) obj;
        return Objects.equals(value, discount.value) &&
                Objects.equals(cause, discount.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, cause);
    }
}
