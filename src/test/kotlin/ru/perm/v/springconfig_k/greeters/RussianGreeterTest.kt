package ru.perm.v.springconfig_k.greeters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RussianGreeterTest {
    @Test
    fun sayHello() {
        assertEquals("Привет, vasi", RussianGreeter().sayHello())
    }
}