package io.americanexpress.function.greeting.rest.handler;

import io.americanexpress.function.greeting.rest.model.Greeting;
import io.americanexpress.synapse.function.reactive.handler.BaseDeleteMonoHandler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DeleteMonoGreetingHandler extends BaseDeleteMonoHandler {

    @Override
    protected Mono<ServerResponse> executeDelete(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring!!")));
    }
}