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
        return Objects.hash(id,name,price,snapshotDate,type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Product other = (Product) o;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (snapshotDate == null) {
            if (other.snapshotDate != null)
                return false;
        } else if (!snapshotDate.equals(other.snapshotDate))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }


}
