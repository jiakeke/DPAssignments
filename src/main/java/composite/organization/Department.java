package composite.organization;

import java.util.*;

public class Department extends Component {

    private List<Component> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return this.children.get(index);
    }

    @Override
    public int getSalary() {
        int totalSalary = 0;
        for (Component child : this.children) {
            totalSalary += child.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String getXML() {
        return "<department name=\"" + this.name + "\">" + this.children.stream().map(Component::getXML).reduce("", (a, b) -> a + b) + "</department>";
    }
}
