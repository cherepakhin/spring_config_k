package ru.perm.v.springconfig_k.greeters

class GermanyGreeter: Greeter {
    override fun sayHello(): String {
        return "Guten Tag, " + System.getProperty("user.name")
    }
}