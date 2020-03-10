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

    public OfferItem(Product product, int quantity, String currency) {
        this(product, quantity, null, null, currency);
    }

    public OfferItem(Product product, int quantity, BigDecimal discountValue, String discountCause, String currency) {
        this.product = product;
        this.quantity = quantity;
        this.discount = new Discount(discountValue, currency, discountCause);
        this.totalCost = product.getPrice().multiply(quantity).subtract(discount.getValue());
    }

    public String getProductId() {
        return product.getId();
    }

    public BigDecimal getProductPrice() {
        return product.getPriceValue();
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
        return discount.getValue();
    }

    public String getDiscountCause() {
        return discount.getCause();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        OfferItem offerItem = (OfferItem) obj;
        return quantity == offerItem.quantity && Objects.equals(product, offerItem.product) && Objects.equals(totalCost,
                offerItem.totalCost) && Objects.equals(discount, offerItem.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, totalCost, discount);
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (getProductPrice() == null) {
            if (other.getProductPrice() != null) {
                return false;
            }
        } else if (!getProductPrice().equals(other.getProductPrice())) {
            return false;
        }
        if (getProductName() == null) {
            if (other.getProductName() != null) {
                return false;
            }
        } else if (!getProductName().equals(other.getProductName())) {
            return false;
        }

        if (getProductId() == null) {
            if (other.getProductId() != null) {
                return false;
            }
        } else if (!getProductId().equals(other.getProductId())) {
            return false;
        }
        if (getProductType() == null) {
            if (other.getProductType() != null) {
                return false;
            }
        } else if (!getProductType().equals(other.getProductType())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue().compareTo(other.totalCost.getValue()) > 0) {
            max = totalCost.getValue();
            min = other.totalCost.getValue();
        } else {
            max = other.totalCost.getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
