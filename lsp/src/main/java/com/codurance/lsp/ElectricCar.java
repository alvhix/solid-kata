package com.codurance.lsp;

public class ElectricCar extends Vehicle {
    protected static final int BATTERY_FULL = 100;
    protected int batteryLevel;

    public int batteryLevel() {
        return batteryLevel;
    }

    public void chargeBattery() {
        this.batteryLevel = BATTERY_FULL;
    }
}
