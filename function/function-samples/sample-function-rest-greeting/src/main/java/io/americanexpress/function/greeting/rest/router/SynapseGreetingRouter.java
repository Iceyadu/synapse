package io.americanexpress.function.greeting.rest.router;

import io.americanexpress.function.greeting.rest.handler.SynapseGreetingHandler;
import io.americanexpress.synapse.function.rest.router.BaseReactiveReadMonoRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class SynapseGreetingRouter extends BaseReactiveReadMonoRouter<SynapseGreetingHandler>  {

    @Bean
    public RouterFunction<ServerResponse> route(SynapseGreetingHandler greetingHandler) {
        return RouterFunctions
                .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::read);
    }
}