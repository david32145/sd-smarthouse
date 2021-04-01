package com.sd.smarthouse;

import com.sd.smarthouse.rabbit.RabbitConnection;
import com.sd.smarthouse.smart.SmartHouse;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {
    public static void main(String[] args) throws IOException, TimeoutException {
        /*  Topics:

            temperature 30 ºC
            location 5m
            luminosity 12lux

            Initial state:
                - AirConditioner off;
                - Light off;
                - DigitalLock locked;
                - VacuumCleaner stop;
        */
        SmartHouse smartHouse = new SmartHouse();
        RabbitConnection rabbitConnection = new RabbitConnection();
        rabbitConnection.consume(SmartHouse.TEMPERATURE_QUEUE, message -> {
            smartHouse.airConditioner.onTemperature(Float.parseFloat(message));
        });
        rabbitConnection.consume(SmartHouse.LUMINOSITY_QUEUE, message -> {
            smartHouse.light.onLuminosity(Float.parseFloat(message));
        });
        rabbitConnection.consume(SmartHouse.LOCATION_QUEUE, message -> {
            smartHouse.digitalLock.onDistance(Float.parseFloat(message));
        });
        rabbitConnection.consume(SmartHouse.CLEAR_COMMAND_QUEUE, message -> {
            smartHouse.vacuumCleaner.onCommand(message.trim());
        });
    }
}
