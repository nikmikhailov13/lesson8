package org.example;

import java.util.UUID;

public class Computer {
    private int ram;
    private int cores;
    private String name;
    private UUID number;
    private OperatingSystem operatingSystem;

    public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
        this.ram = ram;
        this.cores = cores;
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.number = UUID.randomUUID();
    }

    public UUID getNumber() {
        return number;
    }

    public boolean checkInventarize(int ram, int cores, UUID number, OperatingSystem operatingSystem) {
        return this.ram == ram && this.cores == cores && this.operatingSystem == operatingSystem && this.number.equals(number);
    }

    public boolean checkCompatibility(int ram, int cores, OperatingSystem operatingSystem) {
        return this.ram >= ram && this.cores >= cores && this.operatingSystem == operatingSystem;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int column = matrix[0].length;
        int row = matrix.length;
        int[][] result = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        int column = matrix[0].length;
        int row = matrix.length;
        int[][] result = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][row - 1 - i] = matrix[i][j];
            }
        }

        return result;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", cores=" + cores +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", operatingSystem=" + operatingSystem +
                '}';
    }

    enum OperatingSystem {
        WINDOWS,
        LINUX,
        MAC_OS
    }

    public static class ComputerBuilder {
        private int ram;
        private int cores;
        private String name;
        private UUID number;
        private OperatingSystem operatingSystem;

        public ComputerBuilder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder cores(int cores) {
            this.cores = cores;
            return this;
        }

        public ComputerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ComputerBuilder number() {
            this.number = UUID.randomUUID();
            return this;
        }

        public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(ram, cores, name, operatingSystem);
        }
    }
}