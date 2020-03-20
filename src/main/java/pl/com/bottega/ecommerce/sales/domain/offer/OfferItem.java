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

    public Money getTotalcost() {
        return totalCost;
    }

    public Product getProduct() {
        return product;
    }

    public Discount getDiscount() { return discount; }

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
               && Objects.equals(totalCost, other.getTotalcost());
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
