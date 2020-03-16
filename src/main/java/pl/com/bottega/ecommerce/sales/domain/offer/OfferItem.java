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
    private Product product;
    private Discount discount;
    private Money totalCost;

    public OfferItem(Product product, int quantity) {
        this(product, null, quantity,  null);
    }

    public OfferItem(Product product, Discount discount, int quantity,Money totalCost) {
        this.product = product;
        this.discount =discount;
        this. quantity = quantity;
        this.totalCost = totalCost;

        /*BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount.getDiscount().getValue());
        }*/

        this.totalCost.setValue(product.getProductPrice().multiply(new BigDecimal(quantity)).subtract(discount.getDiscount().getValue()));
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, discount, quantity, totalCost);
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
        return Objects.equals(product, other.getProduct())
               && Objects.equals(discount, other.getDiscount())
               && Objects.equals(totalCost, other.getTotalCost())
               && getQuantity() == other.getQuantity();
    }


    public boolean sameAs(OfferItem other, double delta) {
        if (product.getProductPrice() == null) {
            if (other.product.getProductPrice() != null) {
                return false;
            }
        } else if (!product.getProductPrice().equals(other.product.getProductPrice())) {
            return false;
        }
        if (product.getProductName() == null) {
            if (other.product.getProductName() != null) {
                return false;
            }
        } else if (!product.getProductName().equals(other.product.getProductName())) {
            return false;
        }

        if (product.getProductId() == null) {
            if (other.product.getProductId() != null) {
                return false;
            }
        } else if (!product.getProductId().equals(other.product.getProductId())) {
            return false;
        }
        if (product.getProductType() == null) {
            if (other.product.getProductType() != null) {
                return false;
            }
        } else if (!product.getProductType().equals(other.product.getProductType())) {
            return false;
        }

        if (getQuantity() != other.getQuantity()) {
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
