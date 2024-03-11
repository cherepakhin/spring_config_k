package ru.perm.v.springconfig_k.conf

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

@Configuration
@ImportResource("classpath*:beans.xml")
class BeansFromXmlConfiguration {
}