package ru.perm.v.springconfig_k

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.perm.v.springconfig_k.rest.HelloRest

@WebMvcTest(HelloRest::class)
class HelloRestMockMvcTest {
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun getHello() {
        mvc.perform(get("/hello/"))
            .andExpect(status().isOk)
            .andExpect(ResultMatcher {
                result -> assertEquals("hello", result.response.contentAsString)
            })
    }
}