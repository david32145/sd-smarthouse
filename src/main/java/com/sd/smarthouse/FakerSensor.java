package com.sd.smarthouse;

import com.sd.smarthouse.rabbit.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FakerSensor {
    private enum ClearCommand {
        START,
        FINISH
    }
    public static void main(String[] args) throws IOException, TimeoutException {
        Float temperature = 24.0f;
        Float luminosity = 2.f;
        Float location = 3.f;
        ClearCommand clearCommand = ClearCommand.FINISH;
        RabbitConnection rabbitConnection = new RabbitConnection();
        if(temperature != null) {
            rabbitConnection.publish("temperature", temperature+"");
        }
        if(luminosity != null) {
            rabbitConnection.publish("luminosity", luminosity+"");
        }
        if(location != null) {
            rabbitConnection.publish("location", location+"");
        }
        if (clearCommand != null) {
            rabbitConnection.publish("clear_command", clearCommand.name());
        }
        rabbitConnection.close();
    }
}
