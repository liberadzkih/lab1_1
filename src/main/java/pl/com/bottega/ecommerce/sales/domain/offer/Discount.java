package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String discountCause;

    private Money value;

    public Discount(String discountCause, Money value) {
        this.discountCause = discountCause;
        this.value = value;
    }

    public Money getDiscount() {
        return value;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Discount discount1 = (Discount) o;
        return Objects.equals(discountCause, discount1.discountCause) &&
                Objects.equals(value, discount1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountCause, value);
    }
}
