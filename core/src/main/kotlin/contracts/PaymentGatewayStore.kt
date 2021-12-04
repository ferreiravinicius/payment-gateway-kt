package app.contracts

import app.entities.PaymentGateway

interface PaymentGatewayStore {
    fun findOne(companyName: String): PaymentGateway?
}