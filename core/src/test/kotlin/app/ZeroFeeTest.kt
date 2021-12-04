package app

import app.entities.ZeroFee
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

@DisplayName("Testing no fee.")
class ZeroFeeTest {

    @Test
    fun `text should give formatted value`() {
       assertEquals("Sem taxa", ZeroFee().text)
    }

    @Test
    fun `apply should return same value`() {
        assertEquals(BigDecimal(100), ZeroFee().apply(BigDecimal(100)))
    }

}