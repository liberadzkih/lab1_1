/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    private int quantity;
    private Money totalCost;
    private Product product;


    private Discount discount;

    public OfferItem(Money totalcost, Product product, Discount discount, int quantity) {
        this.quantity=quantity;
        this.totalCost=totalcost;
        this.product=product;
        this.discount=discount;

    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
            int quantity, BigDecimal discount, String discountCause) {
        this.product=new Product(productId, productName, productSnapshotDate, productType);
        this.quantity = quantity;
        this.discount = new Discount(discountCause);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount);
        }

        this.totalCost = new Money(productPrice.multiply(new BigDecimal(quantity))
                                     .subtract(discountValue));
    }
    public BigDecimal getProductPrice() {
        return product.getPrice().getValue();
    }

    public String getProductId() {
        return product.getProductId();
    }

    public String getProductName() {
        return product.getProductName();
    }

    public Date getProductSnapshotDate() {
        return product.getProductSnapshotDate();
    }

    public String getProductType() {
        return product.getProductType();
    }

    public BigDecimal getTotalCost() {
        return totalCost.getValue();
    }

    public String getTotalCostCurrency() {
        return totalCost.getCurrency();
    }

    public BigDecimal getDiscount() {
        return discount.getValue().getValue();
    }

    public String getDiscountCause() {
        return discount.getCause();
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getTotalcost() {
        return totalCost;
    }

    public void setTotalcost(Money totalcost) {
        this.totalCost = totalcost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }


    @Override
    public int hashCode() {
        return Objects.hash(totalCost.getCurrency(), discount, discount.getCause(), product.getProductId(), product.getProductName(), product.getPrice().getValue(), product.getProductSnapshotDate(), product.getProductType(),
                quantity, totalCost.getValue());
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
        OfferItem other = (OfferItem) obj;
        return Objects.equals(getTotalcost().getCurrency(), other.getTotalcost().getCurrency())
               && Objects.equals(discount, other.discount)
               && Objects.equals(discount.getCause(), other.getDiscount())
               && Objects.equals(product.getProductId(), other.getProduct().getProductId())
               && Objects.equals(product.getProductName(), other.getProduct().getProductName())
               && Objects.equals(product.getPrice().getValue(), other.getProduct().getPrice().getValue())
               && Objects.equals(product.getProductSnapshotDate(), other.getProduct().getProductSnapshotDate())
               && Objects.equals(product.getProductType(), other.getProduct().getProductType())
               && quantity == other.quantity
               && Objects.equals(totalCost.getValue(), other.getTotalcost().getValue());
    }

    /**
     *
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.getPrice() == null) {
            if (other.getProduct().getPrice() != null) {
                return false;
            }
        } else if (!product.getPrice().equals(other.getProduct().getPrice())) {
            return false;
        }
        if (product.getProductName() == null) {
            if (other.getProduct().getProductName() != null) {
                return false;
            }
        } else if (!product.getProductName().equals(other.getProduct().getProductName())) {
            return false;
        }

        if (product.getProductId() == null) {
            if (other.getProduct().getProductId() != null) {
                return false;
            }
        } else if (!product.getProductId().equals(other.getProduct().getProductId())) {
            return false;
        }
        if (product.getProductType() == null) {
            if (other.getProduct().getProductType() != null) {
                return false;
            }
        } else if (!product.getProductType().equals(other.getProduct().getProductType())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue().compareTo(other.getTotalcost().getValue()) > 0) {
            max = totalCost.getValue();
            min = other.getTotalcost().getValue();
        } else {
            max = other.getTotalcost().getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
