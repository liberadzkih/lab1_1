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

    private Product product;

    private int quantity;

    private Money totalCost;

    private Discount discount;

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
            int quantity, String currency) throws CurrencyMismatchException {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null, currency);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
            int quantity, BigDecimal discount, String discountCause, String currency) throws CurrencyMismatchException {
        this.product = new Product(productId, new Money(productPrice, currency), productName, productSnapshotDate, productType);

        this.quantity = quantity;
        this.discount = new Discount(new Money(discount, currency), discountCause);

        Money discountValue = new Money(new BigDecimal(0), currency);
        if (discount != null) {
            discountValue = discountValue.add(this.discount.getValue());
        }

        this.totalCost = this.product.getPrice()
                                     .multiply(new BigDecimal(quantity))
                                     .subtract(discountValue);
    }

    public String getProductId() {
        return product.getId();
    }

    public BigDecimal getProductPrice() {
        return product.getPrice()
                      .getAmount();
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
        return totalCost.getAmount();
    }

    public String getTotalCostCurrency() {
        return totalCost.getCurrency();
    }

    public BigDecimal getDiscount() {
        return discount.getValue()
                       .getAmount();
    }

    public String getDiscountCause() {
        return discount.getCause();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCost.hashCode(), discount.hashCode(), product.hashCode(), quantity, totalCost.hashCode());
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
        return discount.equals(other.discount)
               && product.equals(other.product)
               && quantity == other.quantity
               && totalCost.equals(other.totalCost);
    }

    /**
     *
     * @param other
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (!product.equals(other.product)) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        if (!totalCost.getCurrency()
                      .equals(other.totalCost.getCurrency())) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getAmount()
                     .compareTo(other.totalCost.getAmount()) > 0) {
            max = totalCost.getAmount();
            min = other.totalCost.getAmount();
        } else {
            max = other.totalCost.getAmount();
            min = totalCost.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }
}
