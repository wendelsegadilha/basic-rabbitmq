package br.com.wendelsegadilha.rabbitmqdemo.consumer;

import br.com.wendelsegadilha.rabbitmqdemo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${spring.rabbitmq.queue.json.name}"})
    public void jsonConsumer(User user){
        LOGGER.info(String.format("Received message -> %s", user.toString()));
    }

}
