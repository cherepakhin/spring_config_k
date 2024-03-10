package ru.perm.v.springconfig_k.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigFromCode {

    @Bean
    fun beanOneConfigFromCode() = "beanOne1"
    @Bean
    fun beanTwoConfigFromCode() = "beanTwo2"
}