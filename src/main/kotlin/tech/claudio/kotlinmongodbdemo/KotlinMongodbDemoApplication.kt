package tech.claudio.kotlinmongodbdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMongodbDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinMongodbDemoApplication>(*args)
}
