package org.example;

import java.util.UUID;

public class Computer {
  private int ram;
  private int cores;
  private String name;
  private UUID number;
  private OperatingSystem operatingSystem;

  private double procFreq;

  private boolean isOn;

  public Computer(int ram, int cores, String name, OperatingSystem operatingSystem, double procFreq) {
    this.ram = ram;
    this.cores = cores;
    this.name = name;
    this.operatingSystem = operatingSystem;
    this.number = UUID.randomUUID();
    this.procFreq = procFreq;
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
            ", proc. freq.=" + procFreq +
            '}';
  }

  public boolean isGaming(){
    return cores > 4 && ram > 16;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public double getProcFreq() {
    return procFreq;
  }

  public void setProcFreq(double procFreq) {
    this.procFreq = procFreq;
  }

  public boolean isOn() {
    return isOn;
  }

  public void setOn(boolean on) {
    isOn = on;
  }

  public boolean isOffice(){
    return cores > 1 && ram > 2;
  }

  public boolean runsFreeSoftware(){
    return operatingSystem == OperatingSystem.Linux;
  }

  public void on(){
    this.isOn = true;
  }

  public void off(){
    this.isOn = false;
  }
  public void addRam(int amount){
    this.ram+= amount;
  }

  public void boostProc(int amount){
    this.procFreq+= amount;
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
    private boolean isOn;

    private double procFreq;

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

    public ComputerBuilder procFreq(double amount) {
      this.procFreq = amount;
      return this;
    }

    public ComputerBuilder addRam(int amount) {
      this.ram += amount;
      return this;
    }

    public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
      this.operatingSystem = operatingSystem;
      return this;
    }

    public Computer build() {
      return new Computer(ram, cores, name, operatingSystem, procFreq);
    }
  }

}
