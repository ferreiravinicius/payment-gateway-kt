package merreis.httpapi.controllers

import contracts.PaymentGatewayStore
import entities.Company
import entities.Fee
import entities.PaymentMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import usecases.payment.digest.PaymentCompanyDigesterExecutor
import usecases.payment.digest.PaymentCompanyDigesterOutput
import java.math.BigDecimal

class MockStore : PaymentGatewayStore {
    override fun findAllCompanyFees(companyName: String): List<Fee> {
        if (!"mercado-pago".equals(companyName)) {
            return emptyList()
        }
        val company = Company("Mercado Pago")
        return listOf(
            Fee(company = company, paymentMethod = PaymentMethod.PIX, withdrawDays = 0, percentageAmount = BigDecimal(0.99)),
            Fee(company = company, paymentMethod = PaymentMethod.PAPER, withdrawDays = 3, fixedAmount = BigDecimal(3.49)),
            Fee(company = company, paymentMethod = PaymentMethod.CREDIT_CARD, withdrawDays = 0, percentageAmount = BigDecimal(4.99)),
            Fee(company = company, paymentMethod = PaymentMethod.CREDIT_CARD, withdrawDays = 14, percentageAmount = BigDecimal(4.49)),
            Fee(company = company, paymentMethod = PaymentMethod.CREDIT_CARD, withdrawDays = 30, percentageAmount = BigDecimal(3.99)),
        )
    }
}

@RestController
@RequestMapping("payment")
class PaymentCompanyController {

    private val store = MockStore()

    @GetMapping("/{name}")
    fun findOne(@PathVariable name: String): PaymentCompanyDigesterOutput {
        val executor = PaymentCompanyDigesterExecutor(store)
        val result = executor.digest(name)
        return result.getOrThrow()
    }

}