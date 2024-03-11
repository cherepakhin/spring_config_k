package ru.perm.v.springconfig_k.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.perm.v.springconfig_k.greeters.EnglishGreeter
import ru.perm.v.springconfig_k.greeters.GermanyGreeter
import ru.perm.v.springconfig_k.greeters.RussianGreeter
import ru.perm.v.springconfig_k.service.GreeterService

@RestController
@RequestMapping("/config_from_xml")
class ConfigFromXmlRest {
    // simple link by NAME var to config name bean
    // name var and inject bean have different name. For link used QUALIFIER
    @Autowired
    @Qualifier("russianGreeterXml")
    lateinit var russianGreeterXmlService: RussianGreeter

    @Autowired
    @Qualifier("germanyGreeterXml")
    lateinit var germanyGreeterXmlService: GermanyGreeter

    @Autowired
    @Qualifier("englishGreeterXml")
    lateinit var englishGreeterXmlService: EnglishGreeter

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