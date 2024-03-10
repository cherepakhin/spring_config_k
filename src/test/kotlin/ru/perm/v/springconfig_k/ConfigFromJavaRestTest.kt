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
class ConfigFromJavaRestTest {
    @LocalServerPort
    val port = 8780

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun getBeanOne() {
        val result =
            restTemplate.getForObject("http://127.0.0.1:$port/api/simple_conf_k/bean_one", String::class.java)

        assertEquals("beanOne1", result)
    }
    @Test
    fun getBeanTwo() {
        val result =
            restTemplate.getForObject("http://127.0.0.1:$port/api/simple_conf_k/bean_two", String::class.java)

        assertEquals("beanTwo2", result)
    }
}