package builder.computer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an menu to choose the type of computer
        Scanner scanner = new Scanner(System.in);
        List<String> cpus = List.of("Intel i5", "Intel i7", "Intel i9", "AMD Ryzen 5", "AMD Ryzen 7");
        List<String> rams = List.of("8GB", "16GB", "32GB", "64GB", "128GB");
        List<String> storages = List.of("1TB HDD", "512GB SSD", "1TB SSD", "2TB HDD", "2TB SSD");
        List<String> gpus = List.of("Integrated Graphics", "NVIDIA GTX 1650", "NVIDIA RTX 2060", "NVIDIA RTX 3060", "NVIDIA RTX 3080");
        List<String> motherboards = List.of("ASUS Prime", "MSI B450", "Gigabyte AORUS", "ASRock Phantom Gaming", "ASUS ROG Strix");
        List<String> powerSupplies = List.of("450W", "500W", "600W", "750W", "850W");

        System.out.println("Choose the type of computer to build:");
        System.out.println("1. Basic Gaming Computer");
        System.out.println("2. Basic Office Computer");
        System.out.println("3. Custom Computer");
        System.out.println("Enter your choice (1, 2 or 3):");

        int choice = scanner.nextInt();
        String cpu="", ram="", storage="", gpu="", motherboard="", powerSupply="";
        ComputerBuilder builder = null;
        switch (choice) {
            case 1:
                // Create a Gaming Computer Builder
                builder = new GamingComputerBuilder();
                cpu = cpus.get(2);
                ram = rams.get(2);
                storage = storages.get(2);
                gpu = gpus.get(2);
                motherboard = motherboards.get(2);
                powerSupply = powerSupplies.get(2);
                break;
            case 2:
                // Create an Office Computer Builder
                builder = new OfficeComputerBuilder();
                cpu = cpus.get(0);
                ram = rams.get(0);
                storage = storages.get(0);
                gpu = gpus.get(0);
                motherboard = motherboards.get(0);
                powerSupply = powerSupplies.get(0);
                break;
            case 3:
                // Create a Custom Computer Builder
                System.out.println("Which type of computer do you want to customize?");
                System.out.println("1. Gaming Computer");
                System.out.println("2. Office Computer");
                int type = scanner.nextInt();
                if (type == 1) {
                    builder = new GamingComputerBuilder();
                } else if (type == 2) {
                    builder = new OfficeComputerBuilder();
                } else {
                    System.out.println("Invalid choice.");
                    return;
                }

                cpu = chooseComponent("CPU", cpus);
                ram = chooseComponent("RAM", rams);
                storage = chooseComponent("Storage", storages);
                gpu = chooseComponent("GPU", gpus);
                motherboard = chooseComponent("Motherboard", motherboards);
                powerSupply = chooseComponent("Power Supply", powerSupplies);

                break;
            default:
                System.out.println("Invalid choice.");
        }

        // Create a Director with the selected builder
        if (builder != null) {
            Director director = new Director(builder);

            director.constructComputer(cpu, ram, storage, gpu, motherboard, powerSupply);
            Computer computer = director.getComputer();
            System.out.println(computer);
        }
    }

    public static String chooseComponent(String componentType, List<String> options) {
        System.out.println("Choose " + componentType + ":");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return options.get(choice - 1);
    }
}
