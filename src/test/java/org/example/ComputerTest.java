package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void isGamingTest() {
        Computer computer = new Computer(16, 4, "Acer", Computer.OperatingSystem.Windows, 3.2);
        assertThat(computer.isGaming()).isFalse();
    }

    @Test
    void isOnTest() {
        Computer computer = new Computer(16, 4, "Acer", Computer.OperatingSystem.Windows, 3.2);
        computer.setOn(true);
        assertThat(computer.isOn()).isTrue();
    }

    @Test
    void isOfficeTest() {
        Computer computer = new Computer(16, 4, "Acer", Computer.OperatingSystem.Windows, 3.2);
        assertThat(computer.isOffice()).isTrue();
    }

    @Test
    void runsFreeSoftwareTest() {
        Computer computer = new Computer(16, 4, "Acer", Computer.OperatingSystem.Windows, 3.2);
        assertThat(computer.runsFreeSoftware()).isFalse();
    }

    @Test
    void boostProcTest() {
        Computer computer = new Computer(16, 4, "Acer", Computer.OperatingSystem.Windows, 3.2);
        computer.boostProc(2);
        assertThat(computer.getProcFreq()).isEqualTo(5.2);
    }
}