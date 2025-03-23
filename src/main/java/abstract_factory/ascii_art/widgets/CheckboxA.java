package abstract_factory.ascii_art.widgets;

public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[X] " + text);
    }
}
