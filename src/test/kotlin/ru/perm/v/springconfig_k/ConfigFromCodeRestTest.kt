package ru.perm.v.springconfig_k

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConfigFromCodeRestTest {
    @LocalServerPort
    val port = 8780

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun getBeanOne() {
        val result =
            restTemplate.getForObject("http://127.0.0.1:$port/api/config_from_code/bean_one", String::class.java)

        assertEquals("BEAN_ONE", result)
    }
    @Test
    fun getBeanTwo() {
        val result =
            restTemplate.getForObject("http://127.0.0.1:$port/api/config_from_code/bean_two", String::class.java)

        assertEquals("BEAN_TWO", result)
    }
    @Test
    fun getStaticBean() {
        val result =
            restTemplate.getForObject("http://127.0.0.1:$port/api/config_from_code/static_bean", String::class.java)

        assertEquals("STATIC_BEAN", result)
    }
}