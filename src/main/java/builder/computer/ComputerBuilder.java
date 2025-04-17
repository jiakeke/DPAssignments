package builder.computer;

public interface ComputerBuilder {
    void buildCPU(String cpu);
    void buildRAM(String ram);
    void buildStorage(String storage);
    void buildGPU(String gpu);
    void buildMotherboard(String motherboard);
    void buildPowerSupply(String powerSupply);
    Computer getComputer();
}
