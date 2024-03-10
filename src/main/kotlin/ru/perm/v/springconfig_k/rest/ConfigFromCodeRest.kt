package ru.perm.v.springconfig_k.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Different ways injection beans
 */
@RestController
@RequestMapping("/simple_conf_k")
class ConfigFromCodeRest {
    // simple link by NAME var to config name bean
    @Autowired
    lateinit var beanOneConfigFromCode:String

    // name var and inject bean have different name. For link used QUALIFIER
    @Autowired
    @Qualifier("beanTwoConfigFromCode")
    lateinit var myVarBeanTwoConfigFromCode:String

    // name "staticBean" defined as @Bean("staticBean")
    @Autowired
    lateinit var staticBean:String

    @GetMapping("/bean_one")
    fun beanOne() = beanOneConfigFromCode
    @GetMapping("/bean_two")
    fun beanTwo() = myVarBeanTwoConfigFromCode
    @GetMapping("/static_bean")
    fun staticBean() = staticBean

}