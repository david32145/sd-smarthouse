package com.sd.smarthouse.smart;

public class Light {
    private boolean isOn = false;

    public void turnOn() {
        if (isOn) {
            return;
        }
        isOn = true;
        System.out.println("Light on light");
    }

    public void turnOff() {
        if (!isOn) {
            return;
        }
        isOn = false;
        System.out.println("Turn of light");
    }

    public void onLuminosity(float luminosity) {
        if (luminosity < 5) {
            turnOn();
        } else {
            turnOff();
        }
    }
}
