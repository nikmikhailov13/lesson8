package org.example;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @Test
    void checkInventarize() {
        Computer computer = Computer.builder()
                .ram(16)
                .cores(4)
                .name("Lenovo")
                .operatingSystem(Computer.OperatingSystem.LINUX)
                .number()
                .build();
        UUID uuid = computer.getNumber();

        assertThat(computer.checkInventarize(16, 4, uuid, Computer.OperatingSystem.LINUX)).isTrue();
        assertThat(computer.checkInventarize(8, 2, uuid, Computer.OperatingSystem.WINDOWS)).isFalse();
    }

    @Test
    void checkCompatibility() {
        Computer computer = Computer.builder()
                .ram(16)
                .cores(4)
                .name("Lenovo")
                .operatingSystem(Computer.OperatingSystem.LINUX)
                .number()
                .build();
        UUID uuid = computer.getNumber();

        assertThat(computer.checkCompatibility(8, 4, Computer.OperatingSystem.LINUX)).isTrue();
        assertThat(computer.checkCompatibility(16, 8, Computer.OperatingSystem.WINDOWS)).isFalse();
    }

    @Test
    void rotateMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] rotatedMatrix = {{4, 1}, {5, 2}, {6, 3}};

        assertThat(Computer.rotateMatrix(matrix)).hasDimensions(3,2);
        assertThat(Computer.rotateMatrix(matrix)).isEqualTo(rotatedMatrix);
    }

    @Test
    void transposeMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] transposedMatrix = {{1, 4}, {2, 5}, {3, 6}};

        assertThat(Computer.transposeMatrix(matrix)).hasDimensions(3,2);
        assertThat(Computer.transposeMatrix(matrix)).isEqualTo(transposedMatrix);
    }

}