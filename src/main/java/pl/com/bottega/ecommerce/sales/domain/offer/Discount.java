package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {
    private String cause;

    public Discount(String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }
}
