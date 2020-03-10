package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private String cause;
    private Money value;

    public Discount() {
        value = new Money(new BigDecimal(0));
    }

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(getCause(), discount.getCause()) &&
                Objects.equals(getValue(), discount.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCause(), getValue());
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

}
