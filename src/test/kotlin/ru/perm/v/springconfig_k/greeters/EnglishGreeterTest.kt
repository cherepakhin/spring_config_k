package ru.perm.v.springconfig_k.greeters

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EnglishGreeterTest {
    @Test
    fun sayHello() {
        System.setProperty("user.name", "testuser")

        assertEquals("Hello, testuser", EnglishGreeter().sayHello())
    }
}