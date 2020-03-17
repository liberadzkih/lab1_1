package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal value;
    private String currency;
    
    public Money(BigDecimal value) {
    	this(value, "PLN");
    }
    
    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

	public Money subtract(Money money) {
		return new Money(value.subtract(money.value), currency);
	}

	public Money multiply(Money money) {
		return new Money(value.multiply(money.value), currency);
	}

	public int compareTo(Money money) {
		return value.compareTo(money.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value, currency);
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
        Money other = (Money) obj;
        return Objects.equals(value, other.value)
               && Objects.equals(currency, other.currency);
	}
}
