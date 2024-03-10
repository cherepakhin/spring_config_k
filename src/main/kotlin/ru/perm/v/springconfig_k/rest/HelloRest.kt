package ru.perm.v.springconfig_k.rest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/hello")
class HelloRest {
    @RequestMapping("/")
    fun hello() = "hello"
}