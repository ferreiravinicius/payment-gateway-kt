package merreis.httpapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HttpapiApplication

fun main(args: Array<String>) {
	runApplication<HttpapiApplication>(*args)
}
