package core.usecases.payment.digest

import java.math.BigDecimal

data class FeeDigesterOutput(
    val installment: Int,
    val withdrawDays: Int,
    val fixedAmount: BigDecimal?,
    val percentageAmount: BigDecimal,
)

data class PaymentMethodDigesterOutput(
    val description: String,
    val fees: List<FeeDigesterOutput>,
    val availableInstallments: List<Int> = emptyList(),
    val availableWithdraws: List<Int> = emptyList(),
)

data class PaymentCompanyDigesterOutput(
    val name: String,
    val paymentMethods: List<PaymentMethodDigesterOutput>,
)