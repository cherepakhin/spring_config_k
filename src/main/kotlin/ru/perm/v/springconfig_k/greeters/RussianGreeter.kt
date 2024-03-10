package ru.perm.v.springconfig_k.greeters

class RussianGreeter: Greeter {
    override fun sayHello(): String {
        return "Привет, " + System.getProperty("user.name")
    }
}