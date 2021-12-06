package app.usecases.payment.digest

import app.contracts.PaymentGatewayStore
import app.entities.Fee
import app.errors.NotFoundError

class PaymentCompanyDigesterExecutor(private val store: PaymentGatewayStore) : PaymentCompanyDigesterUseCase {

    override fun digest(companyName: String): Result<PaymentCompanyDigesterOutput> {
        val fees = store.findAllCompanyFees(companyName)

        if (fees.isEmpty()) {
            val error = NotFoundError("A empresa especificada não existe ou não possuí taxas cadastradas")
            return Result.failure(error)
        }

        val digestOutput = createDigesterOutput(fees)
        return Result.success(digestOutput)
    }

    fun createDigesterOutput(fees: List<Fee>): PaymentCompanyDigesterOutput {
        val grouped = fees.groupBy { it.paymentMethod.name }
        val paymentMethods = grouped.map { map ->
            PaymentMethodDigesterOutput(
                description = map.key,
                fees = map.value.map { fee ->
                    FeeDigesterOutput(
                        installment = fee.installment,
                        fixedAmount = fee.fixedAmount,
                        withdrawDays = fee.withdrawDays,
                        percentageAmount = fee.percentageValue,
                    )
                },
                hasInstallmentAvailable = map.value.any { fee -> fee.installment > 1 },
                hasMultipleWithdrawOptions = map.value.any { fee -> fee.withdrawDays != map.value.first().withdrawDays },
            )
        }

        val currentCompany = fees.first().company
        return PaymentCompanyDigesterOutput(
            name = currentCompany.name,
            paymentMethods = paymentMethods,
        )
    }
}