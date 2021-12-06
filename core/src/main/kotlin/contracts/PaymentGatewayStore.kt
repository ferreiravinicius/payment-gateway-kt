package app.contracts

import app.entities.Fee

interface PaymentGatewayStore {
    fun findAllCompanyFees(companyName: String): List<Fee>
}