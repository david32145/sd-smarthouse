package com.sd.smarthouse.smart;

public class AirConditioner {
    private boolean isOn = false;
    public void turnOn() {
        if(isOn) {
            return;
        }
        isOn = true;
        System.out.println("Turn on Air Conditioner");
    }

    public void turnOff() {
        if(!isOn) {
            return;
        }
        isOn = false;
        System.out.println("Turn of Air Conditioner");
    }

    public void onTemperature(float temperature) {
        if (temperature < 25) {
            turnOff();
        } else {
            turnOn();
        }
    }
}
