package org.example;

import java.util.UUID;

public class Computer {
  private int ram;
  private int cores;
  private String name;
  private UUID number;
  private OperatingSystem operatingSystem;

  private boolean freeze = false;
  private boolean isOn = false;


  public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
    this.ram = ram;
    this.cores = cores;
    this.name = name;
    this.operatingSystem = operatingSystem;
    this.number = UUID.randomUUID();
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

  public void turnOn (){
    this.isOn = true;
    this.freeze = false;
  }

  public void shutdown (){
    this.isOn = false;
    this.freeze = false;
  }

  public boolean isOn() {
    return isOn;
  }

  public void runMyFavoriteGame(){

    if(!this.isOn()){
      this.turnOn();
    }

    //good game well play
    this.freeze = true;

  }

  public boolean isFreeze() {
    return freeze;
  }

}
