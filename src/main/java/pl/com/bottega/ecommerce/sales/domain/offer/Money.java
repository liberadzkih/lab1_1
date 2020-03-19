package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

class CurrencyMismatchException extends Exception {

    CurrencyMismatchException() {
        super();
    }
}

public class Money {

    private BigDecimal amount;
    private String currency;

    Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Money add(Money moneyToAdd) throws CurrencyMismatchException {
        if (!currency.equals(moneyToAdd.getCurrency())) {
            throw new CurrencyMismatchException();
        }
        return new Money(amount.add(moneyToAdd.getAmount()), currency);
    }

    public Money multiply(BigDecimal moneyToMultiplyBy) {

        return new Money(amount.multiply(moneyToMultiplyBy), currency);
    }

    public Money subtract(Money moneyToSubtract) throws CurrencyMismatchException {
        if (!currency.equals(moneyToSubtract.getCurrency())) {
            throw new CurrencyMismatchException();
        }
        return new Money(amount.subtract(moneyToSubtract.getAmount()), currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
