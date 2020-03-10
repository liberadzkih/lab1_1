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

    private BigDecimal totalCost;

    private String currency;

    // discount
    private Discount theDiscount;

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
            int quantity) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType,
            int quantity, BigDecimal discount, String discountCause) {

        theProduct = new Product(productId, productPrice, productName, productSnapshotDate, productType);

        this.quantity = quantity;

        this.theDiscount = new Discount(discountCause,discount);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(theDiscount.getDiscount());
        }

        this.totalCost = productPrice.multiply(new BigDecimal(quantity))
                                     .subtract(discountValue);
    }

    public String getProductId() {
        return theProduct.getProductId();
    }

    public BigDecimal getProductPrice() {
        return theProduct.getProductPrice();
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
        return totalCost;
    }

    public String getTotalCostCurrency() {
        return currency;
    }

    public BigDecimal getDiscount() {
        return theDiscount.getDiscount();
    }

    public String getDiscountCause() {
        return theDiscount.getDiscountCause();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, theDiscount.getDiscount(), theDiscount.getDiscountCause(), theProduct.getProductId(),
                theProduct.getProductName(), theProduct.getProductPrice(), theProduct.getProductSnapshotDate(),
                theProduct.getProductType(), quantity, totalCost);
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
        return Objects.equals(currency, other.currency)
               && Objects.equals(theDiscount.getDiscount(), other.theDiscount.getDiscount())
               && Objects.equals(theDiscount.getDiscountCause(), other.theDiscount.getDiscountCause())
               && Objects.equals(theProduct.getProductId(), other.theProduct.getProductId())
               && Objects.equals(theProduct.getProductName(), other.theProduct.getProductName())
               && Objects.equals(theProduct.getProductPrice(), other.theProduct.getProductPrice())
               && Objects.equals(theProduct.getProductSnapshotDate(), other.theProduct.getProductSnapshotDate())
               && Objects.equals(theProduct.getProductType(), other.theProduct.getProductType())
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
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
