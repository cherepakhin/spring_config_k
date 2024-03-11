package ru.perm.v.springconfig_k

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.perm.v.springconfig_k.rest.HelloRest

@WebMvcTest(HelloRest::class)
class HelloRestMockMvcTest {
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun checkStatusAndResultWithExpect() {
        mvc.perform(get("/hello/"))
            .andExpect(status().isOk)
            .andExpect(ResultMatcher { result ->
                assertEquals("hello", result.response.contentAsString)
            })
    }

    @Test
    fun checkStatusAndResultFromResult() {
        val result = mvc.perform(get("/hello/"))

        assertEquals(HttpStatus.OK.value(), result.andReturn().response.status)
        assertEquals("hello", result.andReturn().response.contentAsString)
    }
}