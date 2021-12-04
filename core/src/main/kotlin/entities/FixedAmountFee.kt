package app.entities

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class FixedAmountFee(private val fixedAmount: BigDecimal) : Fee {

    private val formatter = DecimalFormat()

    override fun apply(amount: BigDecimal): BigDecimal {
        return amount + fixedAmount;
    }

    override val text: String
        get() {
            formatter.roundingMode = RoundingMode.DOWN
            formatter.positivePrefix = "R$"
            formatter.negativePrefix = "-R$"
            formatter.maximumFractionDigits = 2
            formatter.minimumFractionDigits = 2
            return formatter.format(fixedAmount)
        }
}