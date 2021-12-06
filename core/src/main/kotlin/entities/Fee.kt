package app.entities

import java.math.BigDecimal

data class Fee(
    val company: Company,
    val installment: Int = 1,
    val withdrawDays: Int,
    val fixedAmount: BigDecimal? = BigDecimal(0),
    val percentageValue: BigDecimal? = BigDecimal(0),
    val paymentMethod: PaymentMethod,
)

