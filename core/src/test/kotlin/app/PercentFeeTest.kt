package app

import org.junit.jupiter.api.DisplayName

@DisplayName("Testing percent fee. Eg. 2,3%.")
internal class PercentFeeTest {

//    @Test
//    fun `text should give formatted value`() {
//        assertEquals("3,25%", PercentFee(BigDecimal(3.25)).text)
//        assertEquals("3,25%", PercentFee(BigDecimal(3.25000)).text)
//        assertEquals("3,25%", PercentFee(BigDecimal(3.251)).text)
//        assertEquals("-3,25%", PercentFee(BigDecimal(-3.251)).text)
//        assertEquals("-3,25%", PercentFee(BigDecimal(-3.251)).text)
//        assertEquals("1%", PercentFee(BigDecimal(1)).text)
//        assertEquals("1%", PercentFee(BigDecimal(1.009)).text)
//        assertEquals("1,1%", PercentFee(BigDecimal(1.1)).text)
//    }
//
//    private fun roundPrecision(num: BigDecimal): BigDecimal {
//        return num.setScale(2, RoundingMode.DOWN)
//    }
//
//    @Test
//    fun `apply should sum percent fee in amount`() {
//        assertEquals(
//            expected = roundPrecision(BigDecimal(110)),
//            roundPrecision(PercentFee(BigDecimal(10)).apply(BigDecimal(100))),
//        )
//
//        assertEquals(
//            expected = roundPrecision(BigDecimal(110)),
//            roundPrecision(PercentFee(BigDecimal(10.00)).apply(BigDecimal(100)))
//        )
//
//        assertEquals(
//            expected = roundPrecision(BigDecimal(101.5)),
//            roundPrecision(PercentFee(BigDecimal(1.50)).apply(BigDecimal(100)))
//        )
//
//        assertEquals(
//            expected = roundPrecision(BigDecimal(812)),
//            roundPrecision(PercentFee(BigDecimal(1.5)).apply(BigDecimal(800)))
//        )
//
//        assertEquals(
//            expected = roundPrecision(BigDecimal(788)),
//            roundPrecision(PercentFee(BigDecimal(-1.5)).apply(BigDecimal(800)))
//        )
//    }
}