package com.sd.smarthouse.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitConnection {
    private final Channel channel;
    private Connection connection;

    @FunctionalInterface
    public interface OnMessage {
        void message(String message);
    }

    public RabbitConnection() throws IOException, TimeoutException {
        this.connection = createConnection();
        this.channel = connection.createChannel();
    }

    private Connection createConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        return factory.newConnection();
    }

    public void publish(String topic, String value) throws IOException {
        this.channel.basicPublish("amq.topic", topic, null, value.getBytes(StandardCharsets.UTF_8));
    }

    public void consume(String queue, OnMessage callback) throws IOException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            callback.message(message);
        };
        channel.basicConsume(queue, true, deliverCallback, consumerTag -> { });
    }

    public void close() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}
