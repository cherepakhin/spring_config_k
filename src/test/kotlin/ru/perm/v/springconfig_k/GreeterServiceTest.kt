package ru.perm.v.springconfig_k

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.perm.v.springconfig_k.greeters.GermanyGreeter
import ru.perm.v.springconfig_k.greeters.RussianGreeter
import ru.perm.v.springconfig_k.service.GreeterService

class GreeterServiceTest {
    @Test
    fun defultInit() {
        val service = GreeterService()

        assertEquals("Hello, vasi", service.getHelloFromGreeter())
    }

    @Test
    fun setGermanyGreeter() {
        val service = GreeterService()
        service.greeter = GermanyGreeter()
        assertEquals("Guten Tag, vasi", service.getHelloFromGreeter())
    }
    @Test
    fun setRussianGreeter() {
        val service = GreeterService()
        service.greeter = RussianGreeter()
        assertEquals("Привет, vasi", service.getHelloFromGreeter())
    }

}
