package builder.computer;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU(String cpu) {
        computer.addComponent("Office CPU: " + cpu);
    }

    @Override
    public void buildRAM(String ram) {
        computer.addComponent("Office RAM: " + ram);
    }

    @Override
    public void buildStorage(String storage) {
        computer.addComponent("Office Storage: " + storage);
    }

    @Override
    public void buildGPU(String gpu) {
        computer.addComponent("Office GPU: " + gpu);
    }

    @Override
    public void buildMotherboard(String motherboard) {
        computer.addComponent("Office Motherboard: " + motherboard);
    }

    @Override
    public void buildPowerSupply(String powerSupply) {
        computer.addComponent("Office Power Supply: " + powerSupply);
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
