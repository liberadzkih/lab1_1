package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String cause;
    private Money value;

    public Discount(String cause) {
        this.cause = cause;
        this.value= new Money();
    }

    public String getCause() {
        return cause;
    }

    public Money getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cause,value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Discount other = (Discount) obj;
        return (Objects.equals(value, other.getValue())
               && Objects.equals(cause, other.getCause()));
    }



}
