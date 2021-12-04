package app.entities

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class PercentFee(private val percentNumber: BigDecimal) : Fee {
    private val oneHundred = BigDecimal(100)
    private val formatter = DecimalFormat()

    override fun apply(amount: BigDecimal): BigDecimal {
        val value = amount.multiply(percentNumber).divide(oneHundred)
        return amount.add(value)
    }

    override val text: String
        get() {
            formatter.roundingMode = RoundingMode.DOWN
            formatter.positiveSuffix = "%"
            formatter.negativeSuffix = "%"
            formatter.maximumFractionDigits = 2
            return formatter.format(percentNumber)
        }
}