package ru.perm.v.springconfig_k.greeters

class EnglishGreeter: Greeter {
    override fun sayHello(): String {
        return "Hello, " + System.getProperty("user.name")
    }
}