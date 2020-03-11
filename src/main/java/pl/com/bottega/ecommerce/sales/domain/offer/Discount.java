package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private String discountCause;

    private Money discount;

    public Discount(String discountCause, Money discount) {
        super();
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((discount == null) ? 0 : discount.hashCode());
        result = prime * result + ((discountCause == null) ? 0 : discountCause.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Discount other = (Discount) obj;
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
