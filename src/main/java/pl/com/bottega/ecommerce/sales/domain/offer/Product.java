package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String id;

    private Money price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, BigDecimal price, String currency, String name, Date snapshotDate, String type) {
        this.id = id;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
        this.price = new Money(price, currency);
    }

    public String getId() {
        return id;
    }

    public Money getPrice() { return price; }

    public BigDecimal getPriceValue() {
        return price.getValue();
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }
}
