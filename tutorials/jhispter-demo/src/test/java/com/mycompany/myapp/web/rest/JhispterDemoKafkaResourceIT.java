package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.config.EmbeddedKafka;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.MimeTypeUtils;

@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_TIMEOUT)
@WithMockUser
@EmbeddedKafka
@IntegrationTest
@ImportAutoConfiguration(TestChannelBinderConfiguration.class)
class JhispterDemoKafkaResourceIT {

    private static String KAFKA_API = "/api/jhispter-demo-kafka/{command}";

    @Autowired
    private WebTestClient client;

    @Autowired
    private InputDestination input;

    @Autowired
    private OutputDestination output;

    @Test
    void producesMessages() throws InterruptedException {
        client
            .post()
            .uri(uriBuilder -> uriBuilder.path(KAFKA_API).queryParam("message", "value-produce").build("publish"))
            .exchange()
            .expectStatus()
            .isNoContent();
        assertThat(output.receive(1000, "binding-out-0").getPayload()).isEqualTo("value-produce".getBytes());
    }

    @Test
    void producesPooledMessages() throws Exception {
        assertThat(output.receive(1500, "kafkaProducer-out-0").getPayload()).isEqualTo("kakfa_producer".getBytes());
    }

    @Test
    void consumesMessages() {
        Map<String, Object> map = new HashMap<>();
        map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN_VALUE);
        MessageHeaders headers = new MessageHeaders(map);
        Message<String> testMessage = new GenericMessage<>("value-consume", headers);
        input.send(testMessage);
        String value = client
            .get()
            .uri(KAFKA_API, "consume")
            .accept(MediaType.TEXT_EVENT_STREAM)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.TEXT_EVENT_STREAM)
            .returnResult(String.class)
            .getResponseBody()
            .blockFirst(Duration.ofSeconds(10));
        assertThat(value).isEqualTo("value-consume");
    }
}
