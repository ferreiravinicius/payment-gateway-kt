package contracts

import entities.Fee

interface PaymentGatewayStore {
    fun findAllCompanyFees(companyName: String): List<Fee>
}