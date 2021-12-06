package usecases

import org.junit.jupiter.api.DisplayName

@DisplayName("Testing usecase that shows information about any payment gateway")
class PaymentGatewayDescriberUseCaseTest {

//    private lateinit var storeMock: PaymentGatewayStore
//    private lateinit var sut: PaymentGatewayDescriberUseCase
//
//    @BeforeEach
//    fun `before each`() {
//        storeMock = mockk()
//        sut = PaymentGatewayDescriberInteractor(storeMock)
//    }
//
//    @Test
//    fun `it should wire components`() {
//        assertNotNull(storeMock)
//        assertNotNull(sut)
//    }
//
//    @Test
//    fun `given existing company name it should return success`() {
//        val expectedOne = PaymentGateway(Company("mocked"))
//        every { storeMock.findOne(any()) } returns expectedOne
//
//        val result = sut.describe("mocked")
//
//        assertTrue(result.isSuccess)
//        val describedOutput = result.getOrNull()
//        assertNotNull(describedOutput)
//        assertEquals(expectedOne.company.name, describedOutput.company.name)
//    }
//
//    @Test
//    fun `given company name that does not exists it return failure`() {
//        every { storeMock.findOne(any()) } returns null
//        val result = sut.describe("mocked")
//        assertTrue(result.isFailure)
//        assertThrows<UseCaseError> { result.getOrThrow() }
//    }
}
