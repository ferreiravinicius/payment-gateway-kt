package app.usecases.payment.describer

import app.contracts.PaymentGatewayStore
import app.entities.PaymentGateway

class PaymentGatewayDescriberInteractor(private val store: PaymentGatewayStore) : PaymentGatewayDescriberUseCase {
    override fun describe(companyName: String): Result<PaymentGateway> {
        val paymentGateway: PaymentGateway? = store.findOne(companyName)
        paymentGateway?.let {
            return Result.success(it)
        }
        return Result.failure(PaymentGatewayNotFound())
    }
}