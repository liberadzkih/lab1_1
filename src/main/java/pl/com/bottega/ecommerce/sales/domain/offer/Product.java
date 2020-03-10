package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {

    private String id;
    private Money price;
    private String name;
    private Date snapshotDate;
    private String type;

    Product(String id, Money price, String name, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Money getPrice() {
        return price;
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
