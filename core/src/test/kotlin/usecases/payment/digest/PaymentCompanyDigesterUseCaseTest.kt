package usecases.payment.digest

import app.contracts.PaymentGatewayStore
import app.entities.Company
import app.entities.Fee
import app.entities.PaymentMethod
import app.errors.NotFoundError
import app.usecases.payment.digest.PaymentCompanyDigesterExecutor
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("Testing use case that digest information about any payment gateway company")
class PaymentCompanyDigesterUseCaseTest {

    private lateinit var storeMock: PaymentGatewayStore
    private lateinit var sut: PaymentCompanyDigesterExecutor

    @BeforeEach
    fun `before each`() {
        storeMock = mockk()
        sut = PaymentCompanyDigesterExecutor(storeMock)
    }

    @Test
    fun `given company name that does not exists should return error`() {
        every { storeMock.findAllCompanyFees(any()) } returns emptyList()

        val testingCompanyName = "testingCompanyName"
        val result = sut.digest(testingCompanyName)

        assertTrue(result.isFailure)
        assertThrows<NotFoundError> {
            result.getOrThrow()
        }
    }

    @Test
    fun `given existing company name should success`() {

        val fakeFee = Fee(
            company = Company("expected company"),
            installment = 1,
            withdrawDays = 3,
            paymentMethod = PaymentMethod.PIX
        )

        every { storeMock.findAllCompanyFees("testing") } returns listOf(fakeFee)

        val result = sut.digest("testing")

        assertTrue(result.isSuccess)
        result.onSuccess {
            assertEquals(fakeFee.company.name, it.name)
        }
    }

    @Test
    fun `given list of fees should create output correctly`() {

        val company = Company("testing")

        val fees = listOf(
            Fee(company = company, withdrawDays = 3, paymentMethod = PaymentMethod.PIX),
            Fee(company = company, withdrawDays = 2, paymentMethod = PaymentMethod.PIX),
            Fee(company = company, withdrawDays = 1, paymentMethod = PaymentMethod.PIX),
        )

        every { storeMock.findAllCompanyFees(any()) } returns fees

        val result = sut.digest("testing")

        assertTrue(result.isSuccess)
        result.onSuccess { output ->
            val paymentMethods = output.paymentMethods
            assertEquals(company.name, output.name)
            assertEquals(1, paymentMethods.size)
            assertTrue(paymentMethods.first().hasMultipleWithdrawOptions)
            assertFalse(paymentMethods.first().hasInstallmentAvailable)
        }
    }
}