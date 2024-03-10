package ru.perm.v.springconfig_k

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.perm.v.springconfig_k.greeters.GermanyGreeter
import ru.perm.v.springconfig_k.greeters.RussianGreeter
import ru.perm.v.springconfig_k.service.GreeterService

class GreeterServiceTest {
    @Test
    fun defultInit() {
        System.setProperty("user.name", "testuser")
        val service = GreeterService()

        assertEquals("Hello, testuser", service.getHelloFromGreeter())
    }

    @Test
    fun setGermanyGreeter() {
        System.setProperty("user.name", "testuser")

        val service = GreeterService()
        service.greeter = GermanyGreeter()

        assertEquals("Guten Tag, testuser", service.getHelloFromGreeter())
    }
    @Test
    fun setRussianGreeter() {
        System.setProperty("user.name", "testuser")

        val service = GreeterService()
        service.greeter = RussianGreeter()

        assertEquals("Привет, testuser", service.getHelloFromGreeter())
    }

}
