package pro.seag

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CoroutinesApplication {
}

fun main(args: Array<String>) {
    runApplication<CoroutinesApplication>(*args)
}