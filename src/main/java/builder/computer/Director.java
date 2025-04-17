package builder.computer;

public class Director {
    private ComputerBuilder builder;

    public Director(ComputerBuilder computerBuilder) {
        this.builder = computerBuilder;
    }

    public void constructComputer(String cpu, String ram, String storage, String gpu, String motherboard, String powerSupply) {
        builder.buildCPU(cpu);
        builder.buildRAM(ram);
        builder.buildStorage(storage);
        builder.buildGPU(gpu);
        builder.buildMotherboard(motherboard);
        builder.buildPowerSupply(powerSupply);
    }

    public Computer getComputer() {
        return builder.getComputer();
    }
}
