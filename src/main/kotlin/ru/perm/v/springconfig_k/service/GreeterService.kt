package ru.perm.v.springconfig_k.service

import ru.perm.v.springconfig_k.greeters.EnglishGreeter
import ru.perm.v.springconfig_k.greeters.Greeter

class GreeterService {
    var greeter: Greeter = EnglishGreeter()
        set(value) {
            field = value
        }

    fun getHelloFromGreeter():String = greeter.sayHello()
}