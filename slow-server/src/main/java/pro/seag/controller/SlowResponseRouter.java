package pro.seag.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Router for slow responses.
 * Response time could be up to 4 seconds and determined randomly.
 * Average response time - 2 seconds
 */
@Configuration
public class SlowResponseRouter {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/"), (ServerRequest req) -> ok()
                .body(produceResponseForOneSecond())
        );
    }

    private BodyInserter<Flux<Map.Entry<String, String>>, ReactiveHttpOutputMessage> produceResponseForOneSecond() {
        return BodyInserters.fromProducer(
                Flux.fromStream(
                                IntStream.range(1, 11)
                                        .mapToObj(it -> Map.entry(it + " of 10", "ok")))
                        .delayElements(Duration.of(ThreadLocalRandom.current().nextLong(400), ChronoUnit.MILLIS))
                , Map.Entry.class);
    }
}
