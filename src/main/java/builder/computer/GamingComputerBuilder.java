package builder.computer;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU(String cpu) {
        computer.addComponent("Gaming CPU: " + cpu);
    }

    @Override
    public void buildRAM(String ram) {
        computer.addComponent("Gaming RAM: " + ram);
    }

    @Override
    public void buildStorage(String storage) {
        computer.addComponent("Gaming Storage: " + storage);
    }

    @Override
    public void buildGPU(String gpu) {
        computer.addComponent("Gaming GPU: " + gpu);
    }

    @Override
    public void buildMotherboard(String motherboard) {
        computer.addComponent("Gaming Motherboard: " + motherboard);
    }

    @Override
    public void buildPowerSupply(String powerSupply) {
        computer.addComponent("Gaming Power Supply: " + powerSupply);
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
