package core.contracts

import core.entities.Fee

interface PaymentGatewayStore {
    fun findAllCompanyFees(companyName: String): List<Fee>
}