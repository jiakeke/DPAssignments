package abstract_factory.ascii_art.widgets;

public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("{X} " + text);
    }
}