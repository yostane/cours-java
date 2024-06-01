package com.mycompany.myapp.broker;

import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class KafkaConsumer implements Consumer<String> {

    private final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    private Sinks.Many<String> sink = Sinks.many().unicast().onBackpressureBuffer();

    public Flux<String> getFlux() {
        return this.sink.asFlux();
    }

    @Override
    public void accept(String input) {
        log.debug("Got message from kafka stream: {}", input);
        sink.emitNext(input, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
