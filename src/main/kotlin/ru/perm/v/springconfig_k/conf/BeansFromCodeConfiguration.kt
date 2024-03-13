package ru.perm.v.springconfig_k.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansFromCodeConfiguration {

    /**
     * for injection use
     * @Autowired
     * lateinit var namedBean:String
     *
     * the bean name is specified in the annotation.
     * The function name can be any.
     */
    @Bean("namedBean")
    fun anyFunctionName() = "NAMED_BEAN"

    @Bean
    fun beanOneConfigFromCode() = "BEAN_ONE"

    @Bean
    fun beanTwoConfigFromCode() = "BEAN_TWO"

    // As static value
    @get:Bean("fromValue")
    val fromValue = "FROM_VALUE"
}