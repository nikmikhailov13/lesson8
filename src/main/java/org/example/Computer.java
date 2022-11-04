package org.example;

import java.util.UUID;

public class Computer {
  private int ram;
  private int currentRamSockets = 1;
  private int cores;
  private String name;
  private UUID number;
  private OperatingSystem operatingSystem;



  public void addRam(int newRam) {
    if(currentRamSockets > 3) throw new IllegalArgumentException("This computer cannot have more than 4 planks of ram");
    this.ram += newRam;
    currentRamSockets++;
  }

  public String load() {
    if(operatingSystem == null) throw new IllegalArgumentException("Computer can't load without operating system");
    return operatingSystem + " is loading...";
  }


  public String runProgram(String program) {
      if(ram < 4 || cores < 2) {
        throw new IllegalArgumentException("The specification of computer is to low to run the program " + program);
      }
      return program + " is running.";
  }



  public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
    this.ram = ram;
    this.cores = cores;
    this.name = name;
    this.operatingSystem = operatingSystem;
    this.number = UUID.randomUUID();
  }

  public int getRam() {
    return ram;
  }

  public int getCurrentRamSockets() {
    return currentRamSockets;
  }

  public int getCores() {
    return cores;
  }

  public String getName() {
    return name;
  }

  public UUID getNumber() {
    return number;
  }

  public OperatingSystem getOperatingSystem() {
    return operatingSystem;
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

  enum OperatingSystem{
    Windows,
    Linux,
    MacOS
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
