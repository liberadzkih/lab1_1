package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product
    private String id;
    private String name;
    private Date snapshotDate;
    private String type;
    private Money money;

    public Product(String id, String type, Date snapshotDate, String name, BigDecimal money) {
        this.id = id;
        this.money = new Money(money);
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public BigDecimal getPrice() {
        return money.getValue();
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}