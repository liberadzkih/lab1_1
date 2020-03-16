package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

    public String getProductId() {
        return id;
    }

    public Money getProductPrice() {
        return price;
    }

    public String getProductName() {
        return name;
    }

    public Date getProductSnapshotDate() {
        return snapshotDate;
    }

    public String getProductType() {
        return type;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, snapshotDate, type, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(id, other.getProductId())
               && Objects.equals(name, other.getProductName())
               && Objects.equals(snapshotDate, other.getProductSnapshotDate())
               && Objects.equals(type, other.getProductType())
               && Objects.equals(price, other.getProductPrice());
    }
}
