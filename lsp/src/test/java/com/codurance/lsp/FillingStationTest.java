package com.codurance.lsp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FillingStationTest {

    private static final int FULL = 100;
    private final FillingStation fillingStation = new FillingStation();

    @Test
    public void refuel_a_petrol_car() {
        PetrolCar petrolCar = new PetrolCar();
        fillingStation.refuel(petrolCar);

        assertThat(petrolCar.fuelTankLevel()).isEqualTo(FULL);
    }

    @Test
    public void recharge_an_electric_car() {
        ElectricCar electricCar = new ElectricCar();
        fillingStation.charge(electricCar);

        assertThat(electricCar.batteryLevel()).isEqualTo(FULL);
    }

}
