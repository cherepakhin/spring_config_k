package ru.perm.v.springconfig_k.greeters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GermanyGreeterTest {
    @Test
    fun sayHello() {
        System.setProperty("user.name", "testuser")

        assertEquals("Guten Tag, testuser", GermanyGreeter().sayHello())
    }
}