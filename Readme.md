Различные способы задания конфигурации Spring Beans с Kotlin
----------------

Простой проект с конфигурацией Spring beans в xml __И__ использования аннотации @Bean. Для подготовки опытов с проектом с [Camel](https://github.com/cherepakhin/camel_rest).

В [resources/beans.xml](https://github.com/cherepakhin/spring_config_k/blob/main/src/main/resources/beans.xml) определено несколько приветствий на разных языках. Установлено приветствие по умолчанию. Для доступа к приветствиям сделаны Rest контроллеры. Часть конфигурации задана в beans.xml , часть в аннотациях с использованием __@Bean__.  

Аналогичный проект на java [https://github.com/cherepakhin/spring_config](https://github.com/cherepakhin/spring_config)

1. [Установки для Java 11](#set_java_version)
2. [Настройки Spring beans с помощью xml-файла resources/beans.xml](#xml_file)
3. [Настройки Spring beans с помощью аннотаций @Configuration и @Bean в conf/ConfigFromJava](#configuration)
4. [Тесты](#tests)
5. [Const value bean](#const_value)
6. [Сборка jar](#build_jar)
7. [Разное](#other)


<a id="set_java_version"></a>
### 1. Установки для Java 11.

Использована Java 11. 

````shell
$ echo $JAVA_HOME
> /usr/lib/jvm/java-1.11.0-openjdk-amd64

````

Для установки выполнить:

````shell
export JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64
````

В Idea установить File->Project Structure->Project Settings->Project->SDK

![sdk](doc/java11.png)

<a id="xml_file"></a>
### 2. Настройки Spring beans с помощью xml-файла resources/beans.xml.

Определение beans в [resources/beans.xml](https://github.com/cherepakhin/spring_config_k/blob/main/src/main/resources/beans.xml):

````xml
<bean id="russianGreeterXml" class="ru.perm.v.springconfig_k.greeters.RussianGreeter"/>
<bean id="germanyGreeterXml" class="ru.perm.v.springconfig_k.greeters.GermanyGreeter"/>
<bean id="englishGreeterXml" class="ru.perm.v.springconfig_k.greeters.EnglishGreeter"/>

<bean id="selectedGreeterServiceXml" class="ru.perm.v.springconfig_k.service.GreeterService">
<property name="greeter" ref="russianGreeterXml"/>
</bean>
````

Для импортирования бинов, определенных в beans.xml, создан класс:

````kotlin
package ru.perm.v.springconfig_k.conf

@Configuration
@ImportResource("classpath*:beans.xml")
class BeansFromXmlConfiguration {
}
````

После этих мероприятий бины определенные в beans.xml будут в доступны в контексте Spring (см. [rest/ConfigFromXmlRest.kt](https://github.com/cherepakhin/spring_config_k/blob/master/src/main/kotlin/ru/perm/v/springconfig_k/rest/ConfigFromXmlRest.kt) ). 

Аннотация @Qualifier __в данном случае__ используется для уточнения связи, т.к. RussianGreeter, GermanyGreeter, EnglishGreeter реализуют один и тот же интерфейс [greeters/Greeter.kt](https://github.com/cherepakhin/spring_config_k/blob/master/src/main/kotlin/ru/perm/v/springconfig_k/greeters/Greeter.kt). Без этого Spring не сможет определить, какой bean использовать в целевом классе: 

````kotlin
@RestController
@RequestMapping("/config_from_xml")
class ConfigFromXmlRest {
    @Autowired
    @Qualifier("russianGreeterXml")
    lateinit var russianGreeterXmlService: RussianGreeter
....
````

<a id="configuration"></a>
### 3. С помощью аннотаций @Configuration и @Bean в [conf/BeansFromCodeConfiguration.kt](https://github.com/cherepakhin/spring_config_k/blob/master/src/main/kotlin/ru/perm/v/springconfig_k/conf/BeansFromCodeConfiguration.kt).

Определение bean:

````kotlin
@Configuration
class BeansFromCodeConfiguration {

    /**
     * for injection use
     * @Autowired
     * lateinit var staticBean:String
     */
    @Bean("staticBean")
    fun getMyStaticBean() = "STATIC_BEAN"

    @Bean
    fun beanOneConfigFromCode() = "BEAN_ONE"

````

Использование:

````kotlin
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

````

При использовании аннотаций для точного указания имени Spring bean использовано @Bean("__staticBean__"). В классах, которые будут использовать bean можно использовать __@Autowired staticBean__ (см. [rest/ConfigFromCodeRest.kt](https://github.com/cherepakhin/spring_config_k/blob/master/src/main/kotlin/ru/perm/v/springconfig_k/rest/ConfigFromCodeRest.kt)). 

<a id="tests"></a>
### 4. Тесты

Используется Java 11:

````shell
~/prog/kotlin/spring_config_k$ export JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64
~/prog/kotlin/spring_config_k$ ./gradlew clean test
````

<a id="const_value"></a>
### 5. Const value bean

Static в Kotlin нет. Поэтому показан следующий вариант:

Определение константы:

````kotlin
@Configuration
class BeansFromCodeConfiguration {
....
    
    @get:Bean("fromValue")
    val fromValue = "FROM_VALUE"
}
````

Использование в ConfigFromCodeRest:

````kotlin
@RestController
@RequestMapping("/config_from_code") {
    ....
    @Autowired
    @Qualifier("fromValue")
    lateinit var myVarFromValue: String
    ...    
}

````

<a id="build_jar"></a>
### 6. Сборка jar

````shell
./gradlew bootJar

````

Собранный jar будет в build/libs. Запуск:

````shell
java -jar build/libs/spring_config_k-0.0.1-SNAPSHOT.jar

````

<a id="other"></a>
### 7. Разное:

Можно задать значения переменных application.yaml через специальноую переменную __SPRING_APPLICATION_JSON__:

````shell
$ export SPRING_APPLICATION_JSON='{"server":{"port":8960}}'
$ java -jar build/libs/spring_config_k-0.0.1-SNAPSHOT.jar
....
INFO 23327 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8960 (http)
.... 
````