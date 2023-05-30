package pro.seag.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Router for slow responses. Response time could be up to 7 seconds and determined randomly
 */
@Configuration
public class ApplicationRouter {

    @Bean
    public WebClient slowServerClient() {
        return WebClient.builder()
                .baseUrl("http://127.0.0.1:8000")
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routes(WebClient slowServerClient) {
        return route(GET("/"), (ServerRequest req) -> ok()
                .body(
                        slowServerClient
                                .get()
                                .exchangeToFlux(resp -> resp.bodyToFlux(Object.class)),
                        Object.class
                ));
    }

}
