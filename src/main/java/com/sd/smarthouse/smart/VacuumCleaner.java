package com.sd.smarthouse.smart;

public class VacuumCleaner {
    public boolean working = false;

    public void start() {
        if (working) return;
        working = true;
        System.out.println("Start cleaner");
    }

    public void finish() {
        if(!working) return;
        working = false;
        System.out.println("Finish cleaner");
    }

    public void onCommand(String command) {
        if(command.equalsIgnoreCase("START")) {
            start();
        }
        if(command.equalsIgnoreCase("FINISH")) {
            finish();
        }
    }
}
