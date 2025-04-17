package builder.computer;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<String> components;

    public Computer() {
        this.components = new ArrayList<>();
    }

    public void addComponent(String component) {
        components.add(component);
    }

    public String toString() {
        String result = "Computer configuration:\n";
        for (String component : components) {
            result += "- " + component + "\n";
        }
        return result;
    }
}
