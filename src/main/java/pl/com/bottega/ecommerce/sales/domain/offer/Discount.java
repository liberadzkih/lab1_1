package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    private String cause;

    private Cash value;

    public Discount(String cause, Cash value) {
        this.cause = cause;
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Cash getValue() {
        return value;
    }

    public void setValue(Cash value) {
        this.value = value;
    }

}
