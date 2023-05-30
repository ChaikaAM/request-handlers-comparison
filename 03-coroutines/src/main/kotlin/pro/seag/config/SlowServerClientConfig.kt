package pro.seag.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class SlowServerClientConfig {

    @Bean
    open fun slowServerClient(): WebClient =
            WebClient.builder().baseUrl("http://127.0.0.1:8000").build()

}