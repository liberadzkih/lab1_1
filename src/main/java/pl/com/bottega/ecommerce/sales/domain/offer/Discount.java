package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

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
        return Objects.equals(value, other.getDiscount()) && Objects.equals(cause, other.getCause());
    }
}
