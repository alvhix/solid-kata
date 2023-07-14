package com.codurance.lsp;

public class PetrolCar extends Vehicle {
    protected static final int FUEL_TANK_FULL = 100;
    protected int fuelTankLevel = 0;

    public int fuelTankLevel() {
        return fuelTankLevel;
    }

    public void fillUpWithFuel() {
        this.fuelTankLevel = FUEL_TANK_FULL;
    }
}
