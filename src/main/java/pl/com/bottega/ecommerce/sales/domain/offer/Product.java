package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {

    private String id;

    private String name;

    private Date snapshotDate;

    private String type;

    private Money price;

    public Product(String id, String name, Date snapshotDate, String type, Money price) {
        this.id = id;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
        this.price = price;
    }

    public String getId() {
        return id;
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

    public Money getPrice() {
        return price;
    }

}
