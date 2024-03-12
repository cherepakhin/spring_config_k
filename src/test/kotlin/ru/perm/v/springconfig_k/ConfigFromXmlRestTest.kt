package ru.perm.v.springconfig_k

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConfigFromXmlRestTest {
    @LocalServerPort
    val port = 8980

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun getEnglishGreeterXml() {
        System.setProperty("user.name", "testuser")

        val result =
            restTemplate.getForObject(
                "http://127.0.0.1:$port/api/config_from_xml/english_greeter_xml/",
                String::class.java
            )

        assertEquals("Hello, testuser", result)
    }

    @Test
    fun getGermanyGreeterXml() {
        System.setProperty("user.name", "testuser")

        val result =
            restTemplate.getForObject(
                "http://127.0.0.1:$port/api/config_from_xml/germany_greeter_xml/",
                String::class.java
            )

        assertEquals("Guten Tag, testuser", result)
    }

    @Test
    fun getRussianGreeterXml() {
        System.setProperty("user.name", "testuser")

        val result =
            restTemplate.getForObject(
                "http://127.0.0.1:$port/api/config_from_xml/russian_greeter_xml/",
                String::class.java
            )

        assertEquals("Привет, tstuser", result)
    }

    @Test
    fun getSelectedGreeterXml() {
        System.setProperty("user.name", "testuser")
        val result =
            restTemplate.getForObject(
                "http://127.0.0.1:$port/api/config_from_xml/selected_greeter_xml/",
                String::class.java
            )

        assertEquals("Привет, testuser", result)
    }
}