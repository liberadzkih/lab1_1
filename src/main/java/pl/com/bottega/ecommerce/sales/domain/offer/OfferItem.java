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

    // product
    private Product product;

    private int quantity;

    private Money totalCost;

    // discount
    private Discount discount;

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
                     int quantity, String currency) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null, currency);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
                     int quantity, BigDecimal discount, String discountCause, String currency) {

        this.product = new Product(productId, new Money(productPrice, currency), productName, productSnapshotDate, productType);

        this.quantity = quantity;

        this.discount = new Discount( new Money(discount, currency), discountCause);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount);
        }

        this.totalCost = new Money(null, currency);
        this.totalCost.multiply(quantity).subtract(new Money(discountValue, currency));
    }

    public String getProductId() {
        return product.getId();
    }

    public BigDecimal getProductPrice() {
        return product.getPrice().getValue();
    }

    public String getProductName() {
        return product.getName();
    }

    public Date getProductSnapshotDate() {
        return product.getSnapshotDate();
    }

    public String getProductType() {
        return product.getType();
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTotalCost(Money totalCost) {
        this.totalCost = totalCost;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, totalCost, discount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        OfferItem offerItem = (OfferItem) obj;
        return quantity == offerItem.quantity &&
                Objects.equals(product, offerItem.product) &&
                Objects.equals(totalCost, offerItem.totalCost) &&
                Objects.equals(discount, offerItem.discount);
    }

    /**
     * @param item
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (!this.product.equals(other.product)) {
            return true;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue().compareTo(other.getTotalCost()) > 0) {
            max = totalCost.getValue();
            min = other.getTotalCost();
        } else {
            max = other.getTotalCost();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
