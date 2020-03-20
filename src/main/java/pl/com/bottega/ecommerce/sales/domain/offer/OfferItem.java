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

    public OfferItem(String productId, Money productPrice, String productName, Date productSnapshotDate, String productType,
            int quantity, Money discount, String discountCause) {
        this.product=new Product(productId, productName, productSnapshotDate, productType, productPrice);
        this.quantity = quantity;
        this.discount = new Discount(discountCause, discount);

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount.getValue());
        }

        this.totalCost.setValue(product.getPrice().multiply(new BigDecimal(quantity).subtract(discountValue)));


    }

    public int getQuantity() {
        return quantity;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductId() { return product.getProductId(); }

    @Override
    public int hashCode() {
        return Objects.hash(totalCost, discount,  quantity, product);
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
               && quantity == other.getQuantity()
               && Objects.equals(totalCost, other.getTotalCost());
    }

    /**
     *
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product == null) {
            if (other.getProduct() != null) {
                return false;
            }
        } else if (!product.equals(other.getProduct())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue().compareTo(other.getTotalCost().getValue()) > 0) {
            max = totalCost.getValue();
            min = other.getTotalCost().getValue();
        } else {
            max = other.getTotalCost().getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
