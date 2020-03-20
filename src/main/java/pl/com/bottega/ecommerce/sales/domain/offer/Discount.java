package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private BigDecimal value;
    private String cause;

    public Discount(BigDecimal value, String cause) {
        this.value = value;
        this.cause = cause;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCause() {
        return cause;
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(value, cause);
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
        return Objects.equals(value, other.value)
               && Objects.equals(cause, other.cause);
    }
}
