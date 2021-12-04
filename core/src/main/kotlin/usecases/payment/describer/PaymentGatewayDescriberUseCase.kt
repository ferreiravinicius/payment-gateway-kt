package app.usecases.payment.describer

import app.entities.PaymentGateway

sealed interface PaymentGatewayDescriberUseCase {
    fun describe(companyName: String): Result<PaymentGateway>
}