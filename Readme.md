Различные способы задания конфигурации Spring Beans с Kotlin
----------------

Простой проект с конфигурацией Spring beans в xml __И__ использования аннотации @Bean. Для подготовки опытов с проектом с [Camel](https://github.com/cherepakhin/camel_rest).

В [resources/beans.xml](https://github.com/cherepakhin/spring_config_k/blob/main/src/main/resources/beans.xml) определено несколько приветствий на разных языках. Установлено приветствие по умолчанию. Для доступа к приветствиям сделаны Rest контроллеры. Часть конфигурации задана в beans.xml , часть в аннотациях с использованием __@Bean__.  

Аналогичный проект на java [https://github.com/cherepakhin/spring_config](https://github.com/cherepakhin/spring_config)

1. [Установки для Java 11](#set_java_version)
2. [Настройки Spring beans с помощью xml-файла resources/beans.xml](#xml_file)
3. [Настройки Spring beans с помощью аннотаций @Configuration и @Bean в conf/ConfigFromJava](#configuration)
4. [Тесты](#tests)

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

<bean id="russianGreeter" class="ru.perm.v.springconfig_k.greeters.RussianGreeter"/>
<bean id="germanyGreeter" class="ru.perm.v.springconfig_k.greeters.GermanyGreeter"/>
<bean id="englishGreeter" class="ru.perm.v.springconfig_k.greeters.EnglishGreeter"/>

<bean id="selectedGreeterService" class="ru.perm.v.springconfig.service.GreeterService">
<property name="greeter" ref="russianGreeter"/>
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

После этих мероприятий бины определенные в beans.xml будут в доступны в контексте Spring (см. [rest/ConfigFromXmlRest.kt](https://github.com/cherepakhin/spring_config_k/blob/master/src/main/kotlin/ru/perm/v/springconfig_k/rest/ConfigFromXmlRest.kt) ). Аннотация @Qualifier __в данном случае__ используется для уточнения связи, т.к. RussianGreeter, GermanyGreeter, EnglishGreeter реализуют один и тот же интерфейс [greeters/Greeter.kt](https://github.com/cherepakhin/spring_config_k/blob/master/src/main/kotlin/ru/perm/v/springconfig_k/greeters/Greeter.kt). Без этого Spring не сможет определить, какой bean использовать в целевом классе. 

<a id="configuration"></a>
### 3. С помощью аннотаций @Configuration и @Bean в [conf/BeansFromCodeConfiguration.kt](https://github.com/cherepakhin/spring_config_k/blob/master/src/main/kotlin/ru/perm/v/springconfig_k/conf/BeansFromCodeConfiguration.kt).

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

<a id="tests"></a>
### 4. Тесты

Используется Java 11:

````shell
~/prog/kotlin/spring_config_k$ export JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64
~/prog/kotlin/spring_config_k$ ./gradlew clean test
````