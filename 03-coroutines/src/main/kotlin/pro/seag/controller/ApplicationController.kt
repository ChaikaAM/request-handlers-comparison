package pro.seag.controller

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.reactive.function.client.bodyToFlow

@RestController
@RequestMapping
open class ApplicationController(private val slowServerClient: WebClient) {

    @GetMapping
    suspend fun callSlowServer(): Flow<Any> {
        return slowServerClient.get().awaitExchange().bodyToFlow(String::class)
    }

}