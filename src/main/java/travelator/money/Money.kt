package travelator.money

import java.math.BigDecimal
import java.util.*

class Money private constructor(
    val amount: BigDecimal,
    val currency: Currency
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val money = o as Money
        return amount == money.amount && currency == money.currency
    }

    override fun hashCode(): Int {
        return Objects.hash(amount, currency)
    }

    override fun toString(): String {
        return amount.toString() + " " + currency.currencyCode
    }

    fun add(that: Money) = this + that

    operator fun plus(that: Money): Money {
        require(currency == that.currency) { "cannot add Money values of different currencies" }
        return Money(amount.add(that.amount), currency)
    }

    companion object {
        fun of(amount: BigDecimal, currency: Currency) =
            this(amount, currency)

        operator fun invoke(amount: BigDecimal, currency: Currency) =
            Money(
                amount.setScale(currency.defaultFractionDigits),
                currency
            ) // invoke를 재귀호출하는게 아니라 비공개 생성자 Money를 만든다.

        fun of(amountStr: String?, currency: Currency): Money {
            return of(BigDecimal(amountStr), currency)
        }

        fun of(amount: Int, currency: Currency): Money {
            return of(BigDecimal(amount), currency)
        }

        fun zero(userCurrency: Currency): Money {
            return of(BigDecimal.ZERO, userCurrency)
        }
    }
}