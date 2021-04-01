package com.sd.smarthouse.smart;

public class DigitalLock {
    private boolean isOpened = false;

    public void lock() {
        if(!isOpened) {
            return;
        }
        isOpened = false;
        System.out.println("Locking doors");
    }

    public void open() {
        if(isOpened) {
            return;
        }
        isOpened = true;
        System.out.println("Open doors");
    }

    public void onDistance(float distance) {
        if(distance > 5) {
            lock();
        } else {
            open();
        }
    }
}
