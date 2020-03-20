package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {

    private String productId;
    private String productName;
    private Date productSnapshotDate;
    private String productType;
    private Money price;

    public Product(String productId, String productName, Date productSnapshotDate, String productType, Money price) {
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
        this.price=price;
    }
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId,productName, productSnapshotDate, productType,price);
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
        return Objects.equals(productId, other.getProductId())
               && Objects.equals(productName, other.getProductName())
               && Objects.equals(price, other.getPrice())
               && Objects.equals(productSnapshotDate, other.getProductSnapshotDate())
               && Objects.equals(productType, other.getProductType());
    }

}
