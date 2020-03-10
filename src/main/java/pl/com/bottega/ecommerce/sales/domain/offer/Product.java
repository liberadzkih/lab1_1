package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String id;
    private BigDecimal price;
    private String productName;
    private Date snapshotDate;
    private String type;

    public Product(String id, BigDecimal price, String productName, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.productName = productName;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }
}
