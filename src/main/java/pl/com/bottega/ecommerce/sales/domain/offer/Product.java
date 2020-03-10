package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(snapshotDate, product.snapshotDate) &&
                Objects.equals(type, product.type) &&
                Objects.equals(money, product.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, snapshotDate, type, money);
    }
}