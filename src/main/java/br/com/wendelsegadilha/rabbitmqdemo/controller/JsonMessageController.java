package br.com.wendelsegadilha.rabbitmqdemo.controller;

import br.com.wendelsegadilha.rabbitmqdemo.dto.User;
import br.com.wendelsegadilha.rabbitmqdemo.producer.RabbitMQJsonProducer;
import br.com.wendelsegadilha.rabbitmqdemo.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

    private final RabbitMQJsonProducer jsonProducer;

    public JsonMessageController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publisher")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ...");
    }
}
