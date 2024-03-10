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
class HelloRestTest(
    @LocalServerPort var port: Int,
    @Autowired var restTemplate: TestRestTemplate
) {
    @Test
    fun getHello() {
        val result = restTemplate.getForObject("http://127.0.0.1:$port/api/hello/", String::class.java)
        assertEquals("hello", result)
    }

}