package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Discount {

    private String discountCause;

    private Money discount;

    public Discount(String discountCause, Money discount) {
        this.discountCause = discountCause;
        this.discount = discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public Money getDiscount() {
        return discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discount,discountCause);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Discount other = (Discount) o;
        if (discount == null) {
            if (other.discount != null)
                return false;
        } else if (!discount.equals(other.discount))
            return false;
        if (discountCause == null) {
            if (other.discountCause != null)
                return false;
        } else if (!discountCause.equals(other.discountCause))
            return false;
        return true;
    }
}
