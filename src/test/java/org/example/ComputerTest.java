package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ComputerTest {

    Computer computer;
    @BeforeEach
    void setUp() {
        computer = Computer.builder()
                .name("Dell")
                .ram(4)
                .cores(2)
                .operatingSystem(Computer.OperatingSystem.Linux)
                .build();
    }

    @Test
    void shouldAddRam() {

        computer.addRam(2);

        assertThat(computer.getCurrentRamSockets())
                .isEqualTo(2);
        assertThat(computer.getRam())
                .isEqualTo(6);

    }

    @Test
    void shouldNotAddRam() {

        computer.addRam(2);
        computer.addRam(2);
        computer.addRam(2);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> computer.addRam(2))
                .withMessage("This computer cannot have more than 4 planks of ram");

        assertThat(computer.getRam())
                .isEqualTo(10);

        assertThat(computer.getCurrentRamSockets())
                .isEqualTo(4);

    }

    @Test
    void shouldLoad() {

        String message = computer.load();

        assertThat(message)
                .isEqualTo("Linux is loading...");

    }

    @Test
    void shouldNotLoad() {

        Computer computer = Computer.builder()
                .name("Dell")
                .ram(4)
                .cores(2)
                .build();


        assertThatIllegalArgumentException()
                .isThrownBy(() -> computer.load())
                .withMessage("Computer can't load without operating system");

    }

    @Test
    void shouldRunProgram() {


        String message = computer.runProgram("Zoom");


        assertThat(message)
                .isEqualTo("Zoom is running.");
    }

    @Test
    void shouldNotRunProgramWhenRamLessThan4GB() {
        Computer computer = Computer.builder()
                .name("Dell")
                .ram(3)
                .cores(2)
                .operatingSystem(Computer.OperatingSystem.Linux)
                .build();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> computer.runProgram("KMP"))
                .withMessage("The specification of computer is to low to run the program KMP");
    }

    @Test
    void shouldNotRunProgramWhenCoresLessThan2() {
        Computer computer = Computer.builder()
                .name("Dell")
                .ram(4)
                .cores(1)
                .operatingSystem(Computer.OperatingSystem.Linux)
                .build();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> computer.runProgram("KMP"))
                .withMessage("The specification of computer is to low to run the program KMP");
    }
}