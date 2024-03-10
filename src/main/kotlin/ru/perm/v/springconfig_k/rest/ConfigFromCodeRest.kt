package ru.perm.v.springconfig_k.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/simple_conf_k")
class ConfigFromCodeRest {
    @Autowired
    lateinit var beanOneConfigFromCode:String
    @Autowired
    lateinit var beanTwoConfigFromCode:String

    @GetMapping("/bean_one")
    fun beanOne() = beanOneConfigFromCode
    @GetMapping("/bean_two")
    fun beanTwo() = beanTwoConfigFromCode

}