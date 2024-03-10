Различные способы задания конфигурации Spring Beans с Kotlin
----------------

Аналогичный проект на java [https://github.com/cherepakhin/spring_config](https://github.com/cherepakhin/spring_config)

1. [С помощью xml-файла resources/beans.xml](#xml_file)

<a id="xml_file"></a>
### 1. С помощью xml-файла.

Определение beans в [resources/beans.xml](https://github.com/cherepakhin/spring_config_k/blob/main/src/main/resources/beans.xml):

### Примечания.

Используется Java 11:

````shell
~/prog/kotlin/spring_config_k$ export JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64
~/prog/kotlin/spring_config_k$ ./gradlew clean test
````