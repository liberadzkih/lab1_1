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
    private Product theProduct;

    private int quantity;

    private Money totalCost;

    // discount
    private Discount theDiscount;

    public OfferItem(Product theProduct, int quantity) {
        this(theProduct, quantity, null);
    }

    public OfferItem(Product theProduct, int quantity, Discount theDiscount) {

        this.theProduct = theProduct;

        this.quantity = quantity;

        this.theDiscount = theDiscount;

        BigDecimal discountValue = new BigDecimal(0);
        if (this.theDiscount.getValue() != null) {
            discountValue = discountValue.add(theDiscount.getValue().getDenomination());
        }

        this.totalCost.setDenomination(theProduct.getProductPrice()
                                                .getDenomination()
                                                .multiply(new BigDecimal(quantity))
                                                .subtract(discountValue));
    }

    public String getProductId() {
        return theProduct.getProductId();
    }

    public BigDecimal getProductPrice() {
        return theProduct.getProductPrice().getDenomination();
    }

    public String getProductName() {
        return theProduct.getProductName();
    }

    public Date getProductSnapshotDate() {
        return theProduct.getProductSnapshotDate();
    }

    public String getProductType() {
        return theProduct.getProductType();
    }

    public BigDecimal getTotalCost() {
        return totalCost.getDenomination();
    }

    public String getTotalCostCurrency() {
        return totalCost.getCurrency();
    }

    public BigDecimal getDiscount() {
        return theDiscount.getValue().getDenomination();
    }

    public String getDiscountCause() {
        return theDiscount.getDiscountCause();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(theDiscount, theProduct, quantity, totalCost);
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
        return Objects.equals(theDiscount, other.theDiscount)
               && Objects.equals(theProduct, other.theProduct)
               && quantity == other.quantity
               && Objects.equals(totalCost, other.totalCost);
    }

    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (theProduct.getProductPrice() == null) {
            if (other.theProduct.getProductPrice() != null) {
                return false;
            }
        } else if (!theProduct.getProductPrice().equals(other.theProduct.getProductPrice())) {
            return false;
        }
        if (theProduct.getProductName() == null) {
            if (other.theProduct.getProductName() != null) {
                return false;
            }
        } else if (!theProduct.getProductName().equals(other.theProduct.getProductName())) {
            return false;
        }

        if (theProduct.getProductId() == null) {
            if (other.theProduct.getProductId() != null) {
                return false;
            }
        } else if (!theProduct.getProductId().equals(other.theProduct.getProductId())) {
            return false;
        }
        if (theProduct.getProductType() == null) {
            if (other.theProduct.getProductType() != null) {
                return false;
            }
        } else if (!theProduct.getProductType().equals(other.theProduct.getProductType())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getDenomination().compareTo(other.totalCost.getDenomination()) > 0) {
            max = totalCost.getDenomination();
            min = other.totalCost.getDenomination();
        } else {
            max = other.totalCost.getDenomination();
            min = totalCost.getDenomination();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
