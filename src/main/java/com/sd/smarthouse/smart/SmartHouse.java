package com.sd.smarthouse.smart;

public class SmartHouse {
    public final AirConditioner airConditioner;
    public final DigitalLock digitalLock;
    public final Light light;
    public final VacuumCleaner vacuumCleaner;

    public SmartHouse() {
        this.airConditioner = new AirConditioner();
        this.digitalLock = new DigitalLock();
        this.light = new Light();
        this.vacuumCleaner = new VacuumCleaner();
    }

    public final static String TEMPERATURE_QUEUE = "smart_house_temperature";
    public final static String LOCATION_QUEUE = "smart_house_location";
    public final static String LUMINOSITY_QUEUE = "smart_house_luminosity";
    public final static String CLEAR_COMMAND_QUEUE = "smart_house_clear_command";
}
