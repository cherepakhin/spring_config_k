package ru.perm.v.springconfig_k.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansFromCodeConfiguration {

    /**
     * for injection use
     * @Autowired
     * lateinit var staticBean:String
     */
    @Bean("staticBean")
    fun getMyStaticBean() = "STATIC_BEAN"

    @Bean
    fun beanOneConfigFromCode() = "BEAN_ONE"

    @Bean
    fun beanTwoConfigFromCode() = "BEAN_TWO"

    @get:Bean("fromValue")
    val fromValue = "FROM_VALUE"
}