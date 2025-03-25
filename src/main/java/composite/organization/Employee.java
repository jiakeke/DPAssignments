package composite.organization;

public class Employee extends Component{
    private int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from an employee");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from an employee");
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public String getXML() {
        return "<employee name=\"" + this.name + "\" salary=\"" + this.salary + "\"/>";
    }
}
