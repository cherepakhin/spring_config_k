package ru.perm.v.springconfig_k.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.perm.v.springconfig_k.greeters.Greeter
import ru.perm.v.springconfig_k.service.GreeterService

@RestController
@RequestMapping("/config_from_xml")
class ConfigFromXmlRest {
    @Autowired
    @Qualifier("russianGreeterXml")
    lateinit var russianGreeterXmlService: Greeter

    @Autowired
    @Qualifier("germanyGreeterXml")
    lateinit var germanyGreeterXmlService: Greeter

    @Autowired
    @Qualifier("englishGreeterXml")
    lateinit var englishGreeterXmlService: Greeter

    @Autowired
    @Qualifier("selectedGreeterServiceXml")
    lateinit var selectedGreeterServiceXml: GreeterService

    @GetMapping("/russian_greeter_xml")
    fun getRussianGreeterXml() = russianGreeterXmlService.sayHello()

    @GetMapping("/germany_greeter_xml")
    fun getGermanyGreeterXml() = germanyGreeterXmlService.sayHello()

    @GetMapping("/english_greeter_xml")
    fun getEnglishGreeterXml() = englishGreeterXmlService.sayHello()

    @GetMapping("/selected_greeter_xml")
    fun getSelectedGreeterXml() = selectedGreeterServiceXml.getHelloFromGreeter()
}