package ex2

import org.junit.Assert.*
import org.junit.Test

class MainKtTest{
    @Test
    fun firstCard1() {
        val sum = 1000
        var amount = ((sum * 100) * 0.006 + 2000).toInt()
        amount += sum * 100
        val action = true
        if(action == true) {
            assertEquals("Сумма перевода $sum р. 1", firstCard(sum, true, 0))}
    }

    @Test
    fun firstCard2() {
        val sum = 100
        var amount = ((sum * 100) * 0.006 + 2000).toInt()
        amount += sum * 100
        val action = true
        if(action == true) {
            assertEquals("Сумма перевода ${amount / 100} р. ${amount % 100} кооп. 2", firstCard(sum, true, 0))
        }else assertEquals("Сумма перевода ${amount / 100} р. ${amount % 100} кооп. 3", firstCard(sum, false, 0))
    }

    @Test
    fun firstCard3() {
        val sum = 100
        var amount = ((sum * 100) * 0.006 + 2000).toInt()
        amount += sum * 100
        val action = false
        if(action == true) {
            assertEquals("Сумма перевода ${amount / 100} р. ${amount % 100} кооп. 2", firstCard(sum, true, 0))
        }else assertEquals("Сумма перевода ${amount / 100} р. ${amount % 100} кооп. 3", firstCard(sum, false, 0))
    }

    @Test
    fun firstCard4() {
        val sum = 500000
        var amount = ((sum * 100) * 0.006 + 2000).toInt()
        amount += sum * 100
        assertEquals("Превышен лимит отправки", firstCard(sum, true, 200000))
    }

    @Test
    fun secondCard1() {
        val sum = 100
        val amount = sum * 100 + 3500
        assertEquals("При переводе ${sum * 100}  коп. перевод с коммисией $amount  коп.1", secondCard(sum, 0))
    }

    @Test
    fun secondCard2() {
        val sum = 10000
        val amount = ((sum * 100 * 0.075) + (sum * 100)).toInt()
        assertEquals("При переводе ${sum * 100}  коп. перевод с коммисией $amount  коп.2", secondCard(sum, 0))
    }

    @Test
    fun secondCard3() {
        val sum = 1000000
        assertEquals("Превышен лимит отправки", secondCard(sum, 0))
    }

    @Test
    fun vkPay1() {
        val sum = 10000
        assertEquals("Сумма перевода $sum р.", vkPay(sum, 0))
    }

    @Test
    fun vkPay2() {
        val previouSumVK = 5000
        val sum = 100000
        when {
            (sum + previouSumVK < 40_000) && (sum < 15_000) -> {
                assertEquals("Сумма перевода $sum р.", vkPay(sum, previouSumVK))
            }
            else -> assertEquals("Превышен лимит отправки", vkPay(sum, previouSumVK))
        }
    }
}