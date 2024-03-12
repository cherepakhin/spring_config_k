package ru.perm.v.springconfig_k.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * One of the ways injection beans - beans from code.
 * All beans (beanOneConfigFromCode, beanTwoConfigFromCode, staticBean)
 * defined in ru.perm.v.springconfig_k.conf.BeansFromCode.kt
 * (the other way is through xml ru.perm.v.springconfig_k.rest.ConfigFromBeansXmlRest)
 */
@RestController
@RequestMapping("/config_from_code")
class ConfigFromCodeRest {
    // simple link by NAME var to config name bean
    @Autowired
    lateinit var beanOneConfigFromCode: String

    // name var and inject bean have different name. For link used QUALIFIER
    @Autowired
    @Qualifier("beanTwoConfigFromCode")
    lateinit var myVarBeanTwoConfigFromCode: String

    // bean with name "staticBean" defined in conf/BeansFromCodeConfiguration.kt class.
    // Linked by NAME var. @Qualifier("staticBean") not needed.
    @Autowired
    lateinit var staticBean: String

    @Autowired
    @Qualifier("fromValue")
    lateinit var myVarFromValue: String

    @GetMapping("/bean_one")
    fun beanOne() = beanOneConfigFromCode

    @GetMapping("/bean_two")
    fun beanTwo() = myVarBeanTwoConfigFromCode

    @GetMapping("/static_bean")
    fun staticBean() = staticBean

    @GetMapping("/from_value")
    fun fromValue() = myVarFromValue

}