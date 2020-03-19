package pl.com.bottega.ecommerce.sales.domain.offer;

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

        return this.id.equals(other.getId())
               && this.name.equals(other.getName())
               && this.snapshotDate.equals(other.getSnapshotDate())
               && this.type.equals(other.getType())
               && this.price.equals(other.getPrice());

    }
}
