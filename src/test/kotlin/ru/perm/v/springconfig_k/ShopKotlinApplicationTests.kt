package ru.perm.v.springconfig_k

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
class ShopKotlinApplicationTests(
  @Autowired val mockMvc: MockMvc,
  @Autowired val objectMapper: ObjectMapper
) {
  @Test
  fun contextLoads() {
    assertTrue(true)
  }
}
